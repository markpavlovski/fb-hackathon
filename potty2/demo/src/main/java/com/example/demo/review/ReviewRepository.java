package com.example.demo.review;

import com.example.demo.bathroom.Review;
import org.springframework.data.repository.CrudRepository;

public interface ReviewRepository extends CrudRepository<Review, Long>  {
}
