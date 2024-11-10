package io.moun.api.song.controller.dto;

import lombok.Data;
import lombok.Getter;

@Data
public class SongRequest {
    
    private String title;
    private String description;
    private String songFile;
    private String coverImage;
}
