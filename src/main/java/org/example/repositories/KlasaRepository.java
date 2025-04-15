package org.example.repositories;

import org.example.Klasa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface KlasaRepository extends JpaRepository<Klasa, Integer> {

}
