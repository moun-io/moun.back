package io.moun.api.auction.controller.dto;

import jakarta.validation.constraints.NotNull;

public class AuctionRequest {

    @NotNull
    private String title;
    @NotNull
    private String description;
    @NotNull
    private String songFile;
    @NotNull
    private String coverImage;
}
