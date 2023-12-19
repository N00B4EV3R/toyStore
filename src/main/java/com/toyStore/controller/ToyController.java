package com.toyStore.controller;

import com.toyStore.entity.Toy;
import com.toyStore.service.ToyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ToyController {

    @Autowired
    private ToyService service;

    @GetMapping("/filter")
    public String home(){
        return "filter";
    }

    @GetMapping("/addToys")
    public String addToys(){
        return "addToys";
    }

    @GetMapping("/")
    public ModelAndView getAllToys(){
        List<Toy> toys = service.getAllToys();
        ModelAndView m = new ModelAndView();
        m.setViewName("toyList");
        m.addObject("toy",toys);
        return new ModelAndView("toyList","toy",toys);
    }

    @PostMapping("/save")
    public String add(@ModelAttribute Toy toy){
        service.save(toy);
        return "redirect:/";
    }
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id){
        service.deleteById(id);
        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model){
        Toy toy = service.getToyById(id);
        model.addAttribute("toy", toy);
        return "toyEdit";
    }

    @GetMapping("available_toys_Price")
    public ModelAndView getAllToysCheaperThan(){
        List<Toy> toys = service.findByPretGreaterThanEqual(500);
        ModelAndView m = new ModelAndView();
        m.setViewName("toyList");
        m.addObject("toy",toys);
        return new ModelAndView("toyListPrice","toy",toys);
    }

    @GetMapping("/filterToys")
    public ModelAndView filterToys(@RequestParam(name="tara") String tara,
                                   @RequestParam(name="pret") double pret) {

        List<Toy> toys = service.filterToys(tara, pret);

        ModelAndView modelAndView = new ModelAndView("toyFilter");
        modelAndView.addObject("toys", toys);
        return new ModelAndView("toyFilter","toys",toys);
    }
}
