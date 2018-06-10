package com.example.demo.bathroom;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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

  @Override public String toString() {
    return "LatLon{" +
        "lat=" + lat +
        ", lon=" + lon +
        '}';
  }
}
