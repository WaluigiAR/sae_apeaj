package com.webapp.ytb.webappytp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.webapp.ytb.webappytp.modele.FicheIntervention;
import com.webapp.ytb.webappytp.repository.FicheRepository;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class FicheServiceImpl implements FicheService {

    private final FicheRepository ficheRepository; 

    @Override
    public FicheIntervention creer(FicheIntervention fiche) {
        return ficheRepository.save(fiche);
    }

    @Override
    public List<FicheIntervention> lireTout() {
        return ficheRepository.findAll();
    }

    @Override
    public FicheIntervention lire(Long numero) {
        return ficheRepository.findByNumero(numero)
            .orElseThrow(() -> new RuntimeException("Fiche non trouvée"));
    }

    @Override
    public FicheIntervention modifier(Long id, FicheIntervention fiche) {
        return ficheRepository.findById(id)
            .map(existingFiche -> {
                existingFiche.setNumero(fiche.getNumero());
                existingFiche.setNomDemandeur(fiche.getNomDemandeur());
                existingFiche.setDateDemande(fiche.getDateDemande());
                existingFiche.setDateIntervention(fiche.getDateIntervention());
                existingFiche.setDateCreation(fiche.getDateCreation());
                existingFiche.setDureeIntervention(fiche.getDureeIntervention());
                existingFiche.setLocalisation(fiche.getLocalisation());
                existingFiche.setDescriptionDemande(fiche.getDescriptionDemande());
                existingFiche.setDegreUrgence(fiche.getDegreUrgence());
                existingFiche.setTypeIntervention(fiche.getTypeIntervention());
                existingFiche.setNatureIntervention(fiche.getNatureIntervention());
                existingFiche.setEtatFiche(fiche.getEtatFiche());
                existingFiche.setTravauxRealises(fiche.getTravauxRealises());
                existingFiche.setTravauxNonRealises(fiche.getTravauxNonRealises());;
    
                return ficheRepository.save(existingFiche);
            })
            .orElseThrow(() -> new RuntimeException("Fiche non trouvée"));
    }
    

    @Override
    public String supprimer(Long id) {
        ficheRepository.deleteById(id);
        return "Fiche supprimée";
    }
}
