package com.olayinka.DTOs;

import com.olayinka.Model.Rating;
import java.time.LocalDateTime;

// RatingResponseDTO.java
public class RatingResponseDTO {

    private Integer ratingId;
    private Integer userId;
    private String username;
    private Integer rating;
    private String review;
    private LocalDateTime createdAt;

    // Constructors
    public RatingResponseDTO() {}

    public RatingResponseDTO(Rating rating) {
        this.ratingId = rating.getRatingId();
        this.userId = rating.getUser().getId();
        this.username = rating.getUser().getFirstname();
        this.rating = rating.getRating();
        this.review = rating.getReview();
        this.createdAt = rating.getCreatedAt();
    }

    // Getters and setters
    public Integer getRatingId() {
        return ratingId;
    }

    public void setRatingId(Integer ratingId) {
        this.ratingId = ratingId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
