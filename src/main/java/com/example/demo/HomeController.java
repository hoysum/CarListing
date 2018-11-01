package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@Controller
public class HomeController {

    @Autowired
    CategoryRepository categoryRepository;

    @RequestMapping("/")
    public String listCategories(Decription description) {
        //first let's create a category
        model.addAttribute("categories", categoryRepository.findAll());
        return "list";
    }

    @GetMapping("/add")
    public String categoryForm(Model model) {
        model.addAttribute("category", new Category());
        return "categoryform";
    }

    @PostMapping("/process")
    public String processForm(@Valid Category category,
                              BindingResult result) {
        if (result.hasErrors()) {
            return "categoryform";
        }
        categoryRepository.save(category);
        return "redirect:/";


    }
        @RequestMapping("/detail/{id}")
    public String showCourse(@PathVariable("id") long id, Model model)
        {
            model.addAttribute("category", categoryRepository.findById(id).get());

        }



}



