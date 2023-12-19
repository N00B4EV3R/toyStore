package com.toyStore.service;

import com.toyStore.entity.Toy;
import com.toyStore.repository.ToyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToyService {
    @Autowired
    private ToyRepository tRepo;


    public void save(Toy toy) {
        tRepo.save(toy);
    }

    public List<Toy> getAllToys() {
        return tRepo.findAll();
    }

    public void deleteById(Long id) {
        tRepo.deleteById(id);
    }

    public Toy getToyById(Long id) {
        return tRepo.findById(id).get();
    }

    public List<Toy> findByPretGreaterThanEqual(double pret) {
        return tRepo.findByPretGreaterThanEqual(pret);
    }

    public List<Toy> filterToys(String tara, double pret) {
        return tRepo.filterToys(tara, pret);
    }
}
