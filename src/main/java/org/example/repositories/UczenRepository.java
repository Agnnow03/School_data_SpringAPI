package org.example.repositories;

import org.example.Uczen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UczenRepository extends JpaRepository<Uczen, Integer>, PagingAndSortingRepository<Uczen,Integer> {

}
