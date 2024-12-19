package com.example.javaexam.simplecrud.service;

import com.example.javaexam.simplecrud.model.Resource;
import com.example.javaexam.simplecrud.repository.ResourceRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ResourceServiceTest {

    private ResourceService resourceService;
    private ResourceRepository resourceRepository;

    @BeforeEach
    public void setUp() {
        // Мокаем репозиторий, чтобы не обращаться к настоящей базе данных
        resourceRepository = Mockito.mock(ResourceRepository.class);
        resourceService = new ResourceService(resourceRepository);
    }

    @Test
    public void testSaveResource() {
        // Создаем ресурс для теста
        Resource resource = new Resource();
        resource.setName("Test Resource");
        resource.setEmail("test@example.com");

        // Мокаем поведение репозитория
        Mockito.when(resourceRepository.save(Mockito.any(Resource.class))).thenReturn(resource);

        // Проверяем, что сервис сохраняет ресурс
        Resource savedResource = resourceService.save(resource);
        assertNotNull(savedResource);
        assertEquals("Test Resource", savedResource.getName());
        assertEquals("test@example.com", savedResource.getEmail());
    }

    @Test
    public void testFindAllResources() {
        // Создаем несколько ресурсов для теста
        Resource resource1 = new Resource();
        resource1.setName("Resource 1");
        resource1.setEmail("resource1@example.com");

        Resource resource2 = new Resource();
        resource2.setName("Resource 2");
        resource2.setEmail("resource2@example.com");

        List<Resource> resources = Arrays.asList(resource1, resource2);

        // Мокаем поведение репозитория
        Mockito.when(resourceRepository.findAll()).thenReturn(resources);

        // Проверяем, что сервис возвращает все ресурсы
        List<Resource> allResources = resourceService.findAll();
        assertEquals(2, allResources.size());
        assertEquals("Resource 1", allResources.get(0).getName());
        assertEquals("Resource 2", allResources.get(1).getName());
    }
}

