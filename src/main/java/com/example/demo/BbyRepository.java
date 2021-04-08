package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BbyRepository {

    @Autowired
    private JdbcTemplate db;

    public void lagreBilett(Biletter bilett) {
        String sql = "INSERT INTO Biletter(film, antall, fornavn, etternavn, telefon, epost) VALUES(?,?,?,?,?,?)";
        db.update(sql, bilett.getFilm(), bilett.getAntall(), bilett.getFornavn(), bilett.getEtternavn(),
                bilett.getTelefon(), bilett.getEpost());
    }

    public List<Biletter> hentAlleBiletter() {
        String sql = "SELECT * FROM Biletter ORDER BY etternavn";
        List<Biletter> hentAlle = db.query(sql, new BeanPropertyRowMapper(Biletter.class));
        return hentAlle;
    }

    public void slettAlleBiletter() {
        String sql = "DELETE FROM Biletter";
        db.update(sql);

    }
}
