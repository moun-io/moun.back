package io.moun.api.song.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SongService {
    
    public ResponseEntity<String> uploadSongAndAuction(Long memberId) {

        
        
        return ResponseEntity.status(HttpStatus.CREATED).body("Successful upload");
    }
}
