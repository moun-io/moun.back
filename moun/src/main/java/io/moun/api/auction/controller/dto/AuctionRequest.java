package io.moun.api.auction.controller.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AuctionRequest {
    
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private int startBid;
    private int winningBid;
    private boolean isCopyrightTransfer;
    private boolean isExpired;
}
