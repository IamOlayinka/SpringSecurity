package com.olayinka.Repository;

import com.olayinka.Model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Integer> {
    List<Rating> findByProductProductIdOrderByCreatedAtDesc(Integer productId);

    Optional<Rating> findByProductProductIdAndUserUserId(Integer productId, Integer userId);

    @Query("SELECT AVG(CAST(r.rating AS double)) FROM Rating r WHERE r.product.productId = :productId")
    Double findAverageRatingByProductId(@Param("productId") Integer productId);

    @Query("SELECT COUNT(r) FROM Rating r WHERE r.product.productId = :productId")
    Long countByProductId(@Param("productId") Integer productId);
}
