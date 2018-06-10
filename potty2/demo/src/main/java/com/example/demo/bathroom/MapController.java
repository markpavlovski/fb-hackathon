package com.example.demo.bathroom;

import com.example.demo.bathroom.Bathroom;
import com.example.demo.bathroom.BathroomRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class MapController {

    @Autowired
    private BathroomRepository repository;


    @RequestMapping(value = "add")
    public String addStudent(Model model) {
        model.addAttribute("bathroom", new Bathroom());
        return "addBathroom";
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

    @PostMapping("/save")
    public String save(@ModelAttribute Bathroom bathroom) {
        repository.save(bathroom);
        return "redirect:/map";
    }

}
