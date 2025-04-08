package com.workintech.fswebs17d1.controller;

import com.workintech.fswebs17d1.entity.Animal;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/workintech/animal")
public class AnimalController {

    // application.properties üzerinden alınan değerler
    @Value("${course.name}")
    private String courseName;

    @Value("${project.developer.fullname}")
    private String projectDeveloperFullname;

    // CRUD işlemleri için in-memory Map tanımı: id -> Animal
    private Map<Integer, Animal> animals = new HashMap<>();

    // [GET] /workintech/animal : tüm animal değerlerini list olarak döndürür
    @GetMapping
    public List<Animal> getAllAnimals() {
        return animals.values().stream().collect(Collectors.toList());
    }

    // [GET] /workintech/animal/{id} : ilgili id'ye ait animal döndürülür
    @GetMapping("/{id}")
    public Animal getAnimalById(@PathVariable Integer id) {
        return animals.get(id);
    }

    // [POST] /workintech/animal : yeni animal ekleme
    @PostMapping
    public void addAnimal(@RequestBody Animal animal) {
        animals.put(animal.getId(), animal);
    }

    // [PUT] /workintech/animal/{id} : ilgili id'deki animal güncelleme
    @PutMapping("/{id}")
    public void updateAnimal(@PathVariable Integer id, @RequestBody Animal updatedAnimal) {
        animals.put(id, updatedAnimal);
    }

    // [DELETE] /workintech/animal/{id} : ilgili id'deki animal silinir
    @DeleteMapping("/{id}")
    public void deleteAnimal(@PathVariable Integer id) {
        animals.remove(id);
    }
}
