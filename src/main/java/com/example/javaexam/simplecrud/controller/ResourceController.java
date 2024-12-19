package com.example.javaexam.simplecrud.controller;

import com.example.javaexam.simplecrud.model.Resource;
import com.example.javaexam.simplecrud.service.ResourceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/resources")
public class ResourceController {
    private final ResourceService service;

    public ResourceController(ResourceService service) {
        this.service = service;
    }

    @GetMapping
    @ResponseBody
    public List<Resource> getAllResources() {
        List<Resource> resources = service.findAll();
        resources.forEach(resource -> System.out.println("Resource: " + resource.toString()));  // Логируем каждый ресурс
        return resources;
    }

    @PostMapping
    public Resource createResource(@RequestBody Resource resources) {
        return service.save(resources);
    }

    @GetMapping("/{id}")
    public Resource getResourceById(@PathVariable Long id) {
        return service.findById(id)
                .orElseThrow(() -> new RuntimeException("Resource not found with id: " + id));
    }

    @DeleteMapping("/{id}")
    public void deleteResource(@PathVariable Long id) { service.deleteById(id); }

}
