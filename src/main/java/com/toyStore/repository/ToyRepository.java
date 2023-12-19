package com.toyStore.repository;

import com.toyStore.entity.Toy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface ToyRepository extends JpaRepository<Toy, Long> {
    @Query("select t from Toy t where t.pret >= ?1 order by t.pret DESC")
    List<Toy> findByPretGreaterThanEqual(double pret);

    @Query("select t from Toy t where t.tara = ?1 and t.pret >= ?2")
    List<Toy> filterToys(String tara, double pret);


    @Transactional
    @Modifying
    @Query("update Toy t set t.pret = ?1 where t.tara = ?2")
    void updatePretByTara(int pret, String tara);

}
