package org.example.project;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Termin") // Verknüpfung mit der Tabelle "Termin"
public class Termin {

    @Id
    private int termin_id;

    @ManyToOne  // Viele Termine gehören zu einem Benutzer
    @JoinColumn(name = "user_id", nullable = false)  // Verknüpfung mit der "user_id"-Spalte in der User-Tabelle
    private User user;

    @Column
    private String beschreibung;

    @Column(nullable = false)
    private LocalDate datum;

    // Getter und Setter
    public int getTermin_id() {
        return termin_id;
    }

    public void setTermin_id(int termin_id) {
        this.termin_id = termin_id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }
}
