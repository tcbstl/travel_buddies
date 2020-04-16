package com.tommybalestreri.hellospring.controllers;

import com.tommybalestreri.hellospring.data.DestinationData;
import com.tommybalestreri.hellospring.models.Destination;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Controller
public class HomeController implements WebMvcConfigurer {

//    private static List<String> destinations = new ArrayList<>();
//    private static List<Destination> destinations = new ArrayList<>();

    @GetMapping
    public String homepage(Model model) {
        model.addAttribute("destinations", DestinationData.getAll());
        return "home";
    }

    @PostMapping("home")
    public String addDestinationForm(@ModelAttribute Destination newDestination) {
//        public String addDestinationForm(@RequestParam String destination) {
//        DestinationData.add(new Destination(destination));
        DestinationData.add(newDestination);
        return "redirect:";
    }

    @GetMapping("delete")
    public String displayDeleteDestinationForm(Model model){
        model.addAttribute("title", "Delete Destination");
        model.addAttribute("destinations", DestinationData.getAll());
        return "home/delete";
    }

    @PostMapping("delete")
    public String processDeleteDestinationForm(@RequestParam(required = false) int[] destinationIds){

        if (destinationIds != null) {
            for (int id : destinationIds) {
                DestinationData.remove(id);
            }
        }

        return "redirect:";

    }
}
