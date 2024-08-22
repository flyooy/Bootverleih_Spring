package de.supercode.java_boot.controller;

import de.supercode.java_boot.Boot;
import de.supercode.java_boot.services.BootService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/boots")
public class BootController {
    BootService bootService;

    public BootController(BootService bootService) {
        this.bootService = bootService;
    }

    @GetMapping
    public ArrayList<Boot> getAllBooks(@RequestParam(required = false) Long bootid){
        if(bootid == null)
            return bootService.getAllBoots();
        else
            return bootService.getABoot(bootid);
    }

    @PostMapping
    public void addBook(@RequestBody Boot boot){
        bootService.addBoot(boot);
    }

    @PutMapping("/{id}")
    public Boot updateBoot(@PathVariable long id, @RequestBody Boot boot) {
        return  bootService.updateBoot(id, boot);
    }

    @DeleteMapping("/{id}")
    public void deleteBoot(@PathVariable long id) {
        bootService.deleteBoot(id);
    }

    @GetMapping("/count")
    public long getCount() {
        return  bootService.countBoots();
    }

    @GetMapping("/search")
    public Boot findbyBootName(@RequestParam String name){
        return bootService.findbyBootName(name);
    }
}
