package com.example.demo.events;

import com.example.demo.bathroom.Bathroom;
import com.example.demo.bathroom.BathroomRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class MapController {

  @Autowired
  private BathroomRepository repository;

  public static class LatLon {
    double lat;
    double lon;

    public LatLon(double lat, double lon) {
      this.lat = lat;
      this.lon = lon;
    }

    public double getLat() {
      return lat;
    }

    public double getLon() {
      return lon;
    }

    @Override public String toString() {
      return "LatLon{" +
          "lat=" + lat +
          ", lon=" + lon +
          '}';
    }
  }


  @GetMapping("/map")
  public String dashboard(Model model) {
    //    LatLon location = new LatLon(47.6062, -122.3321);
    //    LatLon location2 = new LatLon(45.5122, -122.6587);

    List<Bathroom> bathrooms = (List<Bathroom>) repository.findAll();


//    model.addAttribute("Location", location);
//    model.addAttribute("Location2", location2);

    model.addAttribute("bathrooms", bathrooms);
    return "map";
  }

}
