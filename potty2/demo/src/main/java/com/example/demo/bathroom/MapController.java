package com.example.demo.bathroom;

import com.example.demo.review.ReviewRepository;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MapController {

    @Autowired
    private BathroomRepository bathroomRepository;

    @Autowired
    private ReviewRepository reviewRepository;


    // Adding a Bathroom
    @RequestMapping(value = "add")
    public String addBathroom(Model model) {
        model.addAttribute("bathroom", new Bathroom());
        return "addBathroom";
    }

    //Adding a Review
    @RequestMapping(value = "addReview")
    public String addComment(Model model) {
        model.addAttribute("bathroom", new Bathroom());
        return "addReview";
    }

    @GetMapping("/map")
    public String dashboard(Model model) {
        List<Bathroom> bathrooms = (List<Bathroom>) bathroomRepository.findAll();
        Gson gsonBuilder = new GsonBuilder()
                .setExclusionStrategies(new BathroomExclStrat()).create();
        model.addAttribute("bathrooms", gsonBuilder.toJson(bathrooms));
        return "map";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Bathroom bathroom) {
        bathroomRepository.save(bathroom);
        return "redirect:/map";
    }

}
