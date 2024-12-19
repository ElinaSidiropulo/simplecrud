package com.example.javaexam.simplecrud.service;

import com.example.javaexam.simplecrud.model.Resource;
import com.example.javaexam.simplecrud.repository.ResourceRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;

@Service
public class ResourceService {
    private final ResourceRepository repository;

    public ResourceService(ResourceRepository repository) {
        this.repository = repository;
    }

    public List<Resource> findAll() {
        return repository.findAll();
    }

    public Resource save(Resource resources) {
        return repository.save(resources);
    }

    public Optional<Resource> findById(Long id) { return repository.findById(id); }

    public void deleteById(Long id) { repository.deleteById(id); }

}
