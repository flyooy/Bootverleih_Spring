package de.supercode.java_boot.reository;

import de.supercode.java_boot.Boot;

import java.util.List;
import java.util.stream.IntStream;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public interface BootRepository extends CrudRepository<Boot, Long> {


}
