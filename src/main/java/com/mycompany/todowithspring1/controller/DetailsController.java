package com.mycompany.todowithspring1.controller;


import com.mycompany.todowithspring1.dto.DetailsDeleteRequest;
import com.mycompany.todowithspring1.services.DetailsServices;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.mycompany.todowithspring1.dto.DetailsCreateRequest;

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
           @Valid @ModelAttribute DetailsCreateRequest request,
           BindingResult result
    ) {
        if (result.hasErrors()) {
            return "redirect:/details/" + request.getDuty();
        }
        detailsServices.createDetails(request.getTitle(), request.getDuty());
        return "redirect:/details/" + request.getDuty();
    }

    // 🔹 DELETE
    @PostMapping("/delete")
    public String delete(
            @Valid @ModelAttribute DetailsDeleteRequest request,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            return "redirect:/details/" + request.getDuty();
        }
        detailsServices.deleteDetails(request.getId());
        return "redirect:/details/" + request.getDuty();
    }

}