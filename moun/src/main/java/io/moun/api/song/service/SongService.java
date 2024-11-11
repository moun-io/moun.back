package io.moun.api.song.service;

import io.moun.api.auction.controller.dto.AuctionRequest;
import io.moun.api.auction.domain.Auction;
import io.moun.api.auction.domain.AuctionRepository;
import io.moun.api.common.domain.MounFile;
import io.moun.api.common.service.MounFileService;
import io.moun.api.etc.utils.JWTUtils;
import io.moun.api.member.domain.Member;
import io.moun.api.member.domain.MemberRepository;
import io.moun.api.song.controller.dto.SongRequest;
import io.moun.api.song.controller.dto.SongResponse;
import io.moun.api.song.domain.Song;
import io.moun.api.song.domain.SongRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SongService {

    private final SongRepository songRepository;
    private final ModelMapper modelMapper;
    private final AuctionRepository auctionRepository;
    private final MemberRepository memberRepository;
    private final MounFileService mounFileService;
    private final StringHttpMessageConverter stringHttpMessageConverter;

    @Transactional
    public ResponseEntity<String> uploadSongAndAuction(String token,
                                                       SongRequest songRequest,
                                                       AuctionRequest auctionRequest,
                                                       MultipartFile songFile,
                                                       MultipartFile coverFile) {
        
        String payloadId = JWTUtils.getMemberPayLoadsFromJWT(token).getId();

        long id;
        try {
            id = Long.parseLong(payloadId);
        } catch (NumberFormatException e) {
            throw new RuntimeException("Can't find member with token.");
        }
        Member member = memberRepository.findById(1L).orElseThrow(() -> new NoSuchElementException("Can't find member with id."));
        Auction savedAuction = auctionRepository.save(modelMapper.map(auctionRequest, Auction.class));
        
        MounFile savedSongFile = mounFileService.uploadFileToLocalAndSave(songFile);
        MounFile savedCoverFile = mounFileService.uploadFileToLocalAndSave(coverFile);
        
        Song.builder()
                .member(member)
                .auction(savedAuction)
                .songFile(savedSongFile)
                .coverImageFile(savedCoverFile)
                .title(songRequest.getTitle())
                .description(songRequest.getDescription())
                .build();

        return ResponseEntity.status(HttpStatus.CREATED).body("Successful upload");
    }
    
    
    public ResponseEntity<List<SongResponse>> findAllSongByMemberId(Long id) {
        
        Member member = memberRepository.findById(id).orElseThrow(() -> 
                new NoSuchElementException("Can't find member with id."));
        
        List<Song> songsByMember = songRepository.findAllByMember(member);

        List<SongResponse> songResponseList = songsByMember.stream()
                .map(song -> {
                    String songFileDir = mounFileService.LOCAL_UPLOAD_DIR + "/" + song.getSongFile().getFileName();
                    String coverFileDir = mounFileService.LOCAL_UPLOAD_DIR + "/" + song.getCoverImageFile().getFileName();
                    
                    return SongResponse.builder()
                        .id(song.getId())
                        .title(song.getTitle())
                        .description(song.getDescription())
                        .member(member)
                        .auction(song.getAuction())
                        .songUrl(songFileDir)
                        .coverUrl(coverFileDir)
                        .build();})
                .collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(songResponseList);
    }
}
