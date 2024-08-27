package de.supercode.java_boot.services;
import de.supercode.java_boot.Boot;
import de.supercode.java_boot.reository.BootRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class BootService {

    BootRepository bootRepository;

    public BootService(BootRepository bootRepository) {
        this.bootRepository = bootRepository;
    }

    public void addBoot(Boot boot) {
        bootRepository.save(boot);
    }

    public ArrayList<Boot> getAllBoots() {
        return (ArrayList<Boot>) bootRepository.findAll();
    }

    public Optional<Boot> getABoot(long id) {
        return bootRepository.findById(id);
    }

    public Boot updateBoot(Boot boot) {
        Optional<Boot> existingBoot = bootRepository.findById(boot.getId());
        if (existingBoot.isPresent()) {
            return bootRepository.save(boot);
        } else {
            throw new EntityNotFoundException("Boot with ID " + boot.getId() + " not found.");
        }
    }

    public void deleteBootbyId(long id) {
        bootRepository.deleteById(id);
    }

}