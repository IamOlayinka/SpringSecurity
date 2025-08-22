package com.olayinka.DTOs;

// RatingRequestDTO.java

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class RatingRequestDTO {

    @NotNull(message = "Rating is required")
    @Min(value = 1, message = "Rating must be at least 1")
    @Max(value = 5, message = "Rating cannot exceed 5")
    private Integer rating;

    @Size(max = 1000, message = "Review cannot exceed 1000 characters")
    private String review;

    // Constructors
    public RatingRequestDTO() {}

    public RatingRequestDTO(Integer rating, String review) {
        this.rating = rating;
        this.review = review;
    }

    // Getters and setters
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
}


