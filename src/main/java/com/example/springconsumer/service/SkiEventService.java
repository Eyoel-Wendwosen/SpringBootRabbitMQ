package com.example.springconsumer.service;

import com.example.springconsumer.model.Resort;
import com.example.springconsumer.model.SkiEvent;
import com.example.springconsumer.model.SkiEventPOJO;
import com.example.springconsumer.model.Skier;
import com.example.springconsumer.repository.ResortService;
import com.example.springconsumer.repository.SkiEventRepository;
import com.example.springconsumer.repository.SkierService;
import com.github.javafaker.Faker;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SkiEventService {
    SkiEventRepository skiEventRepository;
    ResortService resortService;
    SkierService skierService;
    Faker fakerGenerator;

    public SkiEventService(SkiEventRepository skiEventRepository, ResortService resortService, SkierService skierService) {
        this.skiEventRepository = skiEventRepository;
        this.resortService = resortService;
        this.skierService = skierService;
        fakerGenerator = new Faker();
    }

    public SkiEvent createSkiEvent(SkiEventPOJO skiEventPOJO) {

        List<Resort> resort = resortService.findResortByResortId(skiEventPOJO.getResortId());
        List<Skier> skier = skierService.findSkierBySkierId(skiEventPOJO.getSkierId());

        // check if resort exists
        if (resort.isEmpty()) {
            resort.add(new Resort(skiEventPOJO.getResortId(), fakerGenerator.name().name(), fakerGenerator.address().fullAddress()));
            resortService.save(resort.get(0));
        }

        // check if Skier exist
        if (skier.isEmpty()) {
            skier.add(new Skier(skiEventPOJO.getSkierId(), fakerGenerator.name().name(), fakerGenerator.number().numberBetween(21, 80)));
            skierService.save(skier.get(0));
        }

        SkiEvent skiEvent = new SkiEvent(skier.get(0), resort.get(0), skiEventPOJO.getLiftId(), skiEventPOJO.getSeasonId(), skiEventPOJO.getDayId(), skiEventPOJO.getTime());
        return skiEventRepository.save(skiEvent);
    }
}
