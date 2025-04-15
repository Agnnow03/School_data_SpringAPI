package org.example.repositories;

import org.example.Wychowawca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WychowawcaRepository extends JpaRepository<Wychowawca, Integer> {
}
