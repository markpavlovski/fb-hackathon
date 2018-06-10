package com.example.demo;

import com.example.demo.bathroom.Bathroom;
import com.example.demo.bathroom.BathroomRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties(GithubProperties.class)
public class DemoApplication {

  public static void main(String[] args) {
    SpringApplication.run(DemoApplication.class, args);
  }

  // save some data to h2 db
  @Bean
  public CommandLineRunner demo(BathroomRepository repository) {

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

      repository.save(wholefoods);
      repository.save(bioSphere);

    };
  }
}
