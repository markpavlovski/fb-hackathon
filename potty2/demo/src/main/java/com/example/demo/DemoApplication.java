package com.example.demo;

import com.example.demo.bathroom.Bathroom;
import com.example.demo.bathroom.BathroomRepository;

import com.example.demo.bathroom.Review;
import com.example.demo.review.ReviewRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
@EnableConfigurationProperties(GithubProperties.class)
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    // save some data to h2 db
    @Bean
    public CommandLineRunner demo(BathroomRepository bathroomRepository, ReviewRepository reviewRepository) {

        return (args) -> {
            Bathroom wholefoods = new Bathroom(
                    47.6183,
                    -122.3381,
                    "WholeFoods Market SLU",
                    "All");

            Bathroom bioSphere = new Bathroom(
                    47.610954,
                    -122.337013,
                    "Biosphere",
                    "Gender Neutral");
            bathroomRepository.save(wholefoods);
            bathroomRepository.save(bioSphere);

            Review wholefoodsRev1 = new Review(
                    "It has a female and male restroom, current access code 10231",
                    "Jenny Lian", new Date());

            Review wholefoodsRev2 = new Review(
                    "It is clean and has 4 stalls in the women's bathroom",
                    "Joey Tran", new Date());


            Review bioSphere1 = new Review(
                    "It only opens while the bioSphere is open",
                    "Ashika Aki", new Date());

            Review bioSphere2 = new Review(
                    "It only opens while the bioSphere is open",
                    "Wendy Parson", new Date());

            // Reviews to save

            wholefoodsRev1.setBathroom(wholefoods);
            wholefoodsRev2.setBathroom(wholefoods);

            bioSphere1.setBathroom(bioSphere);
            bioSphere2.setBathroom(bioSphere);

            reviewRepository.save(wholefoodsRev1);
            reviewRepository.save(wholefoodsRev2);
            reviewRepository.save(bioSphere1);
            reviewRepository.save(bioSphere2);


            // Adding reviews to the bathrooms
            Set<Review> wholefoodsReviews = new HashSet<>();
            wholefoodsReviews.add(wholefoodsRev1);
            wholefoodsReviews.add(wholefoodsRev2);
            wholefoods.setReviews(wholefoodsReviews);

            Set<Review> bioSphereReviews = new HashSet<>();
            bioSphereReviews.add(bioSphere1);
            bioSphereReviews.add(bioSphere2);
            bioSphere.setReviews(bioSphereReviews);


            // Saving the bathrooms
            bathroomRepository.save(wholefoods);
            bathroomRepository.save(bioSphere);
        };
    }
}
