package com.example.demo.bathroom;

import com.example.demo.events.Student;
import com.example.demo.review.ReviewRepository;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

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
    @RequestMapping(value = "/addReview/{id}",  method = RequestMethod.GET)
    public String addReview(@PathVariable("id") Long bathroomId, Model model) {
        Optional<Bathroom> bathroom = bathroomRepository.findById(bathroomId);
        Review review = new Review();

        if (!bathroom.isPresent()){
            throw new RuntimeException("bathroom for this ID is missing");
        }

        review.setBathroom(bathroom.get());
        model.addAttribute("review", review);
        return "addReview";
    }

    @GetMapping("/map")
    public String dashboard(Model model) {
        List<Bathroom> bathrooms = (List<Bathroom>) bathroomRepository.findAll();
        Gson gsonBuilder = new GsonBuilder()
                .setExclusionStrategies(new BathroomExclStrat()).create();
        model.addAttribute("bathrooms", gsonBuilder.toJson(bathrooms));
        model.addAttribute("bathroomsData",bathrooms);

        return "map";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Bathroom bathroom) {
        bathroomRepository.save(bathroom);
        return "redirect:/map";
    }

    @RequestMapping(value = "/saveReview", method = RequestMethod.POST)
    public String saveReview(@ModelAttribute Review review, BindingResult result) {
        if (result.hasErrors()) {
            throw new RuntimeException();
        }

        System.out.println(review);

        reviewRepository.save(review);

        return "redirect:/map";
    }

}
