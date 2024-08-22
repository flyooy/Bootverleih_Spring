package de.supercode.java_boot.services;
import de.supercode.java_boot.Boot;
import de.supercode.java_boot.reository.BootRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BootService {

    BootRepository bootRepository;

    public BootService(BootRepository bootRepository) {
        this.bootRepository = bootRepository;
    }

    public void addBoot(Boot boot) {
        bootRepository.addBoot(boot);
    }

    public ArrayList<Boot> getAllBoots() {
        return bootRepository.getAllBoots();
    }

    public ArrayList<Boot> getABoot(long id){
        return new ArrayList<Boot>(List.of(bootRepository.getBoot(id)));
    }

    public Boot updateBoot(long id, Boot boot) {
        return bootRepository.updateBook(id, boot);
    }

    public void deleteBoot(long id) {
        bootRepository.deleteBook(id);
    }

    public int countBoots() {
     return bootRepository.countBoots();
    }

    public Boot findbyBootName(String bootName){
        return bootRepository.findbyBootName(bootName);
    }
}
