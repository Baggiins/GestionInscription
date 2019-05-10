package com.baggins.GestionServer;

import com.baggins.GestionServer.dao.DiplomeRepository;
import com.baggins.GestionServer.dao.InscriptionRepository;
import com.baggins.GestionServer.dao.TypeDiplomeRepository;
import com.baggins.GestionServer.dao.UniteEnseignementRepository;
import com.baggins.GestionServer.modele.DiplomeEntity;
import com.baggins.GestionServer.modele.InscriptionEntity;
import com.baggins.GestionServer.modele.TypeDiplomeEntity;
import com.baggins.GestionServer.modele.UniteEnseignementEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Classe Controller de mon application rest
 * L'anotation @CrossOrigin permet d'effectuer des requete depuis le client,
 * qui se lance sur un autre port (8082)
 * @author baggins
 */
@RestController
public class Controller {

    @Autowired
    private DiplomeRepository diplomeR;
    @Autowired
    private InscriptionRepository inscriptionR;
    @Autowired
    private TypeDiplomeRepository typeDiplomeR;
    @Autowired
    private UniteEnseignementRepository uniteEnseignementR;

    /**
     * Construction des typeDiplome de base
     */
    @PostConstruct
    private void init(){
        TypeDiplomeEntity typediplomeEntity1 = new TypeDiplomeEntity(1, "Science");
        TypeDiplomeEntity typediplomeEntity2 = new TypeDiplomeEntity(2, "Droit");
        TypeDiplomeEntity typediplomeEntity3 = new TypeDiplomeEntity(3, "Lettre");
        typeDiplomeR.save(typediplomeEntity1);
        typeDiplomeR.save(typediplomeEntity2);
        typeDiplomeR.save(typediplomeEntity3);
    }

    /**
     * Liste des Get all
     */
    @CrossOrigin
    @GetMapping("/allDiplome")
    public List<DiplomeEntity> getAllDiplome(){
        return diplomeR.findAllBy();
    }
    @CrossOrigin
    @GetMapping("/allInscription")
    public List<InscriptionEntity> getAllinscription(){
        return inscriptionR.findAllBy();
    }
    @CrossOrigin
    @GetMapping("/allTypeDiplome")
    public List<TypeDiplomeEntity> getAllTypeDiplome(){
        return typeDiplomeR.findAllBy();
    }
    @CrossOrigin
    @GetMapping("/allUniteEnseignement")
    public List<UniteEnseignementEntity> getAllUniteEnseignement(){
        return uniteEnseignementR.findAllBy();
    }
    /*@GetMapping("/allUniteEnseignement")
    public List<UniteEnseignementEntity> getAllUniteEnseignementOfDiplome(@RequestBody DiplomeEntity diplome){
        return diplome.diplomeUnites.uniteEnseignement;
    }*/

    /**
     * Liste des Post de création
     */
    @CrossOrigin
    @PostMapping("/addDiplome")
    public void addDiplome(@RequestBody DiplomeEntity diplome){
        diplomeR.save(diplome);
    }
    @CrossOrigin
    @PostMapping("/addInscription")
    public void addInscription(@RequestBody InscriptionEntity inscription){
        inscriptionR.save(inscription);
    }
    @CrossOrigin
    @PostMapping("/addTypeDiplome")
    public void addDiplome(@RequestBody TypeDiplomeEntity typeDiplome){
        typeDiplomeR.save(typeDiplome);
    }
    @CrossOrigin
    @PostMapping("/addUniteEnseignement")
    public void addDiplome(@RequestBody UniteEnseignementEntity uniteEnseignement){
        uniteEnseignementR.save(uniteEnseignement);
    }

}
