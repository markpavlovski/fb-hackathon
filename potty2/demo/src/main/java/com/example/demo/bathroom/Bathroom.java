package com.example.demo.bathroom;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Bathroom {

  @Id
  @GeneratedValue
  private Long id;

  double lat;
  double lon;

  @Column(name="description")
  String description;

  @Column(name="gender")
  String gender;


  @OneToMany(mappedBy = "post", cascade = CascadeType.REMOVE)
  private Collection<Review> comments;

  public Bathroom(){

  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setLat(double lat) {
    this.lat = lat;
  }

  public void setLon(double lon) {
    this.lon = lon;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public Bathroom(double lat, double lon, String description, String gender) {
    this.lat = lat;
    this.lon = lon;
    this.description = description;

    this.gender = gender;
  }

  public double getLat() {
    return lat;
  }

  public double getLon() {
    return lon;
  }

  public String getDescription() {
    return description;
  }

  public String getGender() {
    return gender;
  }

  public void setComments(Collection<Review> comments) {
    this.comments = comments;
  }

  public Collection<Review> getComments() {

    return comments;
  }

  @Override public String toString() {
    return "LatLon{" +
        "lat=" + lat +

        ", lon=" + lon +
        '}';
  }
}
