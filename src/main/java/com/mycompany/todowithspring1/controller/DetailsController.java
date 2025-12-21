package com.mycompany.todowithspring1.controller;


import com.mycompany.todowithspring1.services.DetailsServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author servan
 */
@Controller
@RequestMapping("/details")
public class DetailsController {

    private final DetailsServices detailsServices;

    public DetailsController(DetailsServices detailsServices) {
        this.detailsServices = detailsServices;
    }

   
    @GetMapping("/{duty}")
    public String showDetails(@PathVariable("duty") String duty, Model model) {
        model.addAttribute("details", detailsServices.getDetailsByTodoDuty(duty));
        model.addAttribute("duty", duty);
        return "details";
    }

    // 🔹 CREATE
    @PostMapping("/create")
    public String create(
            @RequestParam("title") String title,
            @RequestParam("duty") String duty
    ) {
        detailsServices.createDetails(title, duty);
        return "redirect:/details/" + duty;
    }

    // 🔹 DELETE
    @PostMapping("/delete")
    public String delete(
            @RequestParam("title") String title,
            @RequestParam("duty") String duty
    ) {
        detailsServices.deleteDetails(title, duty);
        return "redirect:/details/" + duty;
    }
}