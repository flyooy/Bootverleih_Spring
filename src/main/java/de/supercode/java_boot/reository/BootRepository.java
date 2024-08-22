package de.supercode.java_boot.reository;

import de.supercode.java_boot.Boot;

import java.util.List;
import java.util.stream.IntStream;

import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class BootRepository {
public static long actualid = 0;
public ArrayList<Boot> boots = new ArrayList<>();

public BootRepository() {
    this.boots = new ArrayList<>();
}


    public void addBoot(Boot boot){
        boot.setId(actualid++);
        this.boots.add(boot);
    }
    //read
    public Boot getBoot(long id){
        return this.boots.stream().filter(boot->boot.getId()==id).findFirst().orElseThrow();
    }

    public ArrayList<Boot> getAllBoots(){
        return this.boots;
    }
    //update
    public Boot updateBook(long id,Boot newBootData){
       int bootIndex = IntStream.range(0,boots.size())
               .filter(index->boots.get(index).getId()==id).findFirst().orElse(-1);
        if (bootIndex != -1) {
            boots.set(bootIndex, newBootData);
            return newBootData;
        }
        return null;
    }

    //delete
    public void deleteBook(long id){
    Boot boot = getBoot(id);
    if(boot != null){
        boots.remove(boot);
    }
    }

    public int countBoots() {
        return boots.size();
    }

    public Boot findbyBootName(String bootName){
    return boots.stream().filter(boot->boot.getName().equals(bootName)).findFirst().orElse(null);
    }
}
