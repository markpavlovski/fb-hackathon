package com.example.demo.bathroom;

import com.example.demo.bathroom.Bathroom;
import com.example.demo.bathroom.BathroomRepository;

import com.google.gson.Gson;
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


        List<Bathroom> bathrooms = (List<Bathroom>) repository.findAll();

        model.addAttribute("bathrooms", new Gson().toJson(bathrooms));
        return "map";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Bathroom bathroom) {
        repository.save(bathroom);
        return "redirect:/map";
    }

}
