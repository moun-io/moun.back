package io.moun.api.song.controller;

import io.moun.api.auction.controller.dto.AuctionRequest;
import io.moun.api.song.controller.dto.SongRequest;
import io.moun.api.song.service.SongService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
public class SongController {
    
    private final SongService songService;

    @PostMapping("/songs")
    public ResponseEntity<String> createSongAndAuction(@RequestHeader("Aucthorization")String token,
                                                       @RequestBody SongRequest songRequest,
                                                       @RequestBody AuctionRequest auctionRequest,
                                                       @RequestPart(value = "song-file")MultipartFile songFile,
                                                       @RequestPart(value = "cover-file")MultipartFile coverFile) {

        

        return songService.uploadSongAndAuction(token, songRequest, auctionRequest, songFile, coverFile);
    }
}
