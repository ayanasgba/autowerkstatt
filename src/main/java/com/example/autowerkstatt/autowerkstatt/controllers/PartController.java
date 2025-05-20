package com.example.autowerkstatt.autowerkstatt.controllers;

import com.example.autowerkstatt.autowerkstatt.model.Part;
import com.example.autowerkstatt.autowerkstatt.services.PartService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/part")
public class PartController {

    private PartService partService;

    public PartController(PartService partService) {
        this.partService = partService;
    }

    @GetMapping("/getAll")
    public List<Part> getAll() {
        return partService.findAll();
    }

    @GetMapping("/{id}")
    public Part getById(@PathVariable int id) {
        return partService.findById(id).orElse(null);
    }

    @DeleteMapping ("/delete/{id}")
    public void deleteById(@PathVariable int id) {
        partService.delete(id);
    }

    @PutMapping( "/update/{id}")
    public void update(@PathVariable int id, @RequestBody Part part) {
        partService.update(id, part);
    }
    @PostMapping("/save")
    public void save(@RequestBody Part part) {
        partService.save(part);
    }
}
