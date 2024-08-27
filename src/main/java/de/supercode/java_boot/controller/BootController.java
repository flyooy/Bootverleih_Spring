package de.supercode.java_boot.controller;

import de.supercode.java_boot.Boot;
import de.supercode.java_boot.services.BootService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/boots")
public class BootController {
    BootService bootService;

    public BootController(BootService bootService) {
        this.bootService = bootService;
    }

    @GetMapping("/{id}")
    public Optional<Boot> getABoot(@PathVariable long id){
        return bootService.getABoot(id);
    }
    @GetMapping
    public ArrayList<Boot> getAllBoots(){
        return bootService.getAllBoots();
    }

    @PostMapping
    public void addBook(@RequestBody Boot boot){
        bootService.addBoot(boot);
    }

    @PutMapping
    public Boot updateBoot(@RequestBody Boot boot) {
        return  bootService.updateBoot(boot);
    }
    @DeleteMapping("/{id}")
    public void deleteBootbyId(@PathVariable long id) {
        bootService.deleteBootbyId(id);
    }


}
