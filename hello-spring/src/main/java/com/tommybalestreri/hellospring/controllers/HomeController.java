package com.tommybalestreri.hellospring.controllers;

import com.tommybalestreri.hellospring.data.DestinationRepository;
import com.tommybalestreri.hellospring.models.Destination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Controller
public class HomeController implements WebMvcConfigurer {

        @Autowired
        private DestinationRepository destinationRepository;

//    private static List<String> destinations = new ArrayList<>();
//    private static List<Destination> destinations = new ArrayList<>();

    @GetMapping
    public String homepage(Model model) {
//        model.addAttribute("destinations", DestinationData.getAll());
//        model.addAttribute("destinations", destinationRepository.findAll());
        model.addAttribute("destinations", destinationRepository.findAll());
        model.addAttribute(new Destination());
        return "home";
    }

    @PostMapping("home")
    public String addDestinationForm(@ModelAttribute Destination newDestination) {
//        public String addDestinationForm(@RequestParam String destination) {
//        DestinationData.add(new Destination(destination));
//        DestinationData.add(newDestination);
        destinationRepository.save(newDestination);
        return "redirect:";
    }

    @GetMapping("delete")
    public String displayDeleteDestinationForm(Model model){
        model.addAttribute("title", "Delete Destination");
//        model.addAttribute("destinations", DestinationData.getAll());
        model.addAttribute("destinations", destinationRepository.findAll());
        return "home/delete";
    }

    @PostMapping("delete")
    public String processDeleteDestinationForm(@RequestParam(required = false) int[] destinationIds){

        if (destinationIds != null) {
            for (int id : destinationIds) {
//                DestinationData.remove(id);
                destinationRepository.deleteById(id);
            }
        }

        return "redirect:";

    }
}
