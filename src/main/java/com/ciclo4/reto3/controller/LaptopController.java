package com.ciclo4.reto3.controller;

import com.ciclo4.reto3.model.Laptop;
import com.ciclo4.reto3.service.LaptopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/laptop")
@CrossOrigin("*")
public class LaptopController {

    @Autowired
    private LaptopService laptopService;

    @GetMapping("/all")
    public List<Laptop> getAllLaptops() {
        return laptopService.getAll();
    }

    @GetMapping("{id}")
    public Optional<Laptop> getLaptop(@PathVariable("id") int id) {
        return laptopService.getLaptop(id);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Laptop create(@RequestBody Laptop laptop) {
        return laptopService.create(laptop);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Laptop update(@RequestBody Laptop laptop) {
        return laptopService.update(laptop);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id) {
        return laptopService.delete(id);
    }

    // Reto 5
    @GetMapping("/price/{price}")
    public List<Laptop> gadgetsByPrice(@PathVariable("price") double precio) {
        return laptopService.gadgetsByPrice(precio);
    }

    @GetMapping("/description/{description}")
    public List<Laptop> findByDescriptionLike(@PathVariable("description") String description) {
        return laptopService.findByDescriptionLike(description);
    }

}
