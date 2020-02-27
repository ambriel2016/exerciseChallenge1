package com.cristian.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class HomeController {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    PetRepository petRepository;

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("persons", personRepository.findAll());
        model.addAttribute("pets", petRepository.findAll());
        return "index";
    }

    @RequestMapping("/about")
    public String about(){
        return "about";
    }

    @GetMapping("/addPerson")
    public String personForm(Model model){
        model.addAttribute("person", new Person());
        return "personform";
    }
    @PostMapping("/processPerson")
    public String processForm(@ModelAttribute Person person){
        personRepository.save(person);
        return "redirect:/";
    }
    @RequestMapping("/detailPerson/{id}")
    public String showPerson(@PathVariable("id") long id, Model model){
        model.addAttribute("person", personRepository.findById(id).get());
        return "show";
    }

    @RequestMapping("/updatePerson/{id}")
    public String updatePerson(@PathVariable("id") long id, Model model){
        model.addAttribute("person", personRepository.findById(id).get());
        return "personform";
    }

    @RequestMapping("/deletePerson/{id}")
    public String delPerson(@PathVariable("id") long id){
        personRepository.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/addPet")
    public String petForm(Model model){
        model.addAttribute("pet", new Pet());
        return "petform";
    }
    @PostMapping("/processPet")
    public String processForm(@ModelAttribute Pet pet){
        petRepository.save(pet);
        return "redirect:/";
    }
    @RequestMapping("/detailPet/{id}")
    public String showPet(@PathVariable("id") long id, Model model){
        model.addAttribute("pet", petRepository.findById(id).get());
        return "show";
    }

    @RequestMapping("/updatePet/{id}")
    public String updatePet(@PathVariable("id") long id, Model model){
        model.addAttribute("pet", petRepository.findById(id).get());
        return "petform";
    }

    @RequestMapping("/deletePet/{id}")
    public String delPet(@PathVariable("id") long id){
        petRepository.deleteById(id);
        return "redirect:/";
    }

    @RequestMapping("/search")
    public String searchPerson(@RequestParam("search") String search, Model model){
        model.addAttribute("peopleSearch", personRepository.findByFirstName(search));
        model.addAttribute("petSearch", petRepository.findByName(search));
        return "searchList";
    }
}
