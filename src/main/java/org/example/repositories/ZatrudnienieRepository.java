package org.example.repositories;

import org.example.Zatrudnienie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZatrudnienieRepository extends JpaRepository<Zatrudnienie, Integer> {

}
