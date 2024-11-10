package io.moun.api.song.service;

import io.jsonwebtoken.Claims;
import io.moun.api.auction.controller.dto.AuctionRequest;
import io.moun.api.auction.domain.Auction;
import io.moun.api.auction.domain.AuctionRepository;
import io.moun.api.common.utils.JWTUtils;
import io.moun.api.member.domain.MemberRepository;
import io.moun.api.song.controller.dto.SongRequest;
import io.moun.api.song.domain.Song;
import io.moun.api.song.domain.SongRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SongService {

    private final SongRepository songRepository;
    private final ModelMapper modelMapper;
    private final AuctionRepository auctionRepository;
    private final MemberRepository memberRepository;
    
    public ResponseEntity<String> uploadSongAndAuction(String token, SongRequest songRequest, AuctionRequest auctionRequest) {

        String payloadId = JWTUtils.getMemberPayLoadsFromJWT(token).getId();

        Auction auction = modelMapper.map(auctionRequest, Auction.class);
        Song song = Song.builder()
                .title(songRequest.getTitle())
                .description(songRequest.getDescription())
                .coverImage(songRequest.getCoverImage())
                .auction(auction)
                .songFile(songRequest.getSongFile())
                .build();

        songRepository.save(song);

        return ResponseEntity.status(HttpStatus.CREATED).body("Successful upload");
    }
}
