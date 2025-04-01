package com.example.blocservice.service;


import com.example.blocservice.entity.Bloc;
import com.example.blocservice.repository.BlocRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j  // Simple Loggining Façade For Java
public class BlocServiceImpl  implements IBlocService {

    @Autowired
    BlocRepository blocRepository;

    @Scheduled(fixedRate = 30000) // millisecondes // cron fixedRate
    //@Scheduled(cron="0/15 * * * * *")
    public List<Bloc> retrieveAllBlocs() {

        return blocRepository.findAll();
    }

    // Exemple sans Keywords :
    @Transactional
    public List<Bloc> retrieveBlocsSelonCapacite(long c) {

        List<Bloc> listB = blocRepository.findAll();
        List<Bloc> listBselonC = new ArrayList<>();

        for (Bloc b: listB) {
            if (b.getCapaciteBloc()>=c)
                listBselonC.add(b);
        }

        return listBselonC;
    }

    @Transactional
    public Bloc retrieveBloc(Long blocId) {

        return blocRepository.findById(blocId).get();
    }


    public Bloc addBloc(Bloc c) {

        return blocRepository.save(c);
    }

    public Bloc modifyBloc(Bloc bloc) {
        return blocRepository.save(bloc);
    }

    public void removeBloc(Long blocId) {
        blocRepository.deleteById(blocId);
    }



    public List<Bloc> trouverBlocsSansFoyer() {
//        return blocRepository.findAllByFoyerIsNull();
        return blocRepository.findAll();

    }

    public List<Bloc> trouverBlocsParNomEtCap(String nb, long c) {
        return blocRepository.findAllByNomBlocAndCapaciteBloc(nb,  c);
    }

}
