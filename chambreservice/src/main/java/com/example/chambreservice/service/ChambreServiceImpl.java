package com.example.chambreservice.service;


import com.example.chambreservice.entity.Chambre;
import com.example.chambreservice.entity.TypeChambre;
import com.example.chambreservice.repository.ChambreRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class ChambreServiceImpl implements IChambreService {
   @Autowired
   ChambreRepository chambreRepository;

    public List<Chambre> retrieveAllChambres() {
        System.out.println("In Methodo retrieveAllChambres : ");
        List<Chambre> listC = chambreRepository.findAll();
        System.out.println("Out of retrieveAllChambres : ");

        return listC;
    }

    public Chambre retrieveChambre(Long chambreId) {
        Chambre c = chambreRepository.findById(chambreId).get();
        return c;
    }

    public Chambre addChambre(Chambre c) {
        Chambre chambre = chambreRepository.save(c);
        return chambre;
    }

    public Chambre modifyChambre(Chambre c) {
        Chambre chambre = chambreRepository.save(c);
        return c;
    }

    public void removeChambre(Long chambreId) {
        chambreRepository.deleteById(chambreId);
    }







    public List<Chambre> recupererChambresSelonTyp(TypeChambre tc)
    {
        return chambreRepository.findAllByTypeC(tc);
    }






















//    public Chambre trouverchambreSelonEtudiant(long cin) {
//       //
//
//        return chambreRepository.trouverChselonEt(cin);
//    }
}
