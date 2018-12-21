package com.ipiecoles.java.java230.repository;

import com.ipiecoles.java.java230.model.Employe;
import org.dom4j.io.ElementModifier;
import org.joda.time.LocalDate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeRepository extends PagingAndSortingRepository<Employe,Long> {
    Employe findByMatricule(String matricule);

    List<Employe> findByNomAndPrenom(String nom, String prenom);

    List<Employe> findByNomIgnoreCase(String nom);
    Page<Employe> findByNomIgnoreCase(String nom, Pageable pageable);

    List<Employe> findByDateEmbaucheBefore(LocalDate dateEmbauche);

    List<Employe> findByDateEmbaucheAfter(LocalDate dateEmbauche);

    List<Employe> findBySalaireGreaterThanOrderBySalaireDesc(Double salaire);

    @Query("select v from Employe v where lower(v.prenom) = lower(:nomOuPrenom) or lower(v.nom) = lower(:nomOuPrenom)")
    List<Employe> findByNomORPrenomAllIgnoreCase(@Param("nomOuPrenom") String nomOuPrenom);

    /*@Query("select v from Employe v where (v.salaire) > (select avg(b.salaire) from Employe b)")*/
    @Query(value= "select * from Employe where salaire > ( select AVG(salaire) from Employe)", nativeQuery = true)
    List<Employe> findEMployePlusRiches();
}