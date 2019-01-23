package com.Team23.backend.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.Team23.backend.Entity.Drug;

@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:4200")
public interface DrugRepository extends JpaRepository<Drug, Long> {
    Drug findById(long drugId);
    Drug findByDrugName(String drugName);
    void deleteById(Long drugId);
}