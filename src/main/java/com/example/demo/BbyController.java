package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BbyController {

    @Autowired
    private BbyRepository rep;

    @PostMapping("/lagre")
    public void visResultat(Biletter inputFilm) {
        rep.lagreBilett(inputFilm);

    }

    @GetMapping("/biletter")
    public List<Biletter> hentAlle() {
        return rep.hentAlleBiletter();
    }

    @GetMapping("/slett")
    public void slettBilett() {
        rep.slettAlleBiletter();
    }

}
