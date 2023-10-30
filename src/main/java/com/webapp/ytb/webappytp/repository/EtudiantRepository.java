package com.webapp.ytb.webappytp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.webapp.ytb.webappytp.modele.Etudiant;

@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant, Long>{
    
    @Query("SELECT e FROM Etudiant e WHERE e.login = :login")
    Etudiant findUserByLogin(@Param("login") String login);

}
