package org.example.project;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

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
    private LocalTime startTime;  // Startzeit des Termins (nur TIME)

    @Column(nullable = false)
    private LocalTime endTime;  // Endzeit des Termins (nur TIME)

    @Column(nullable = false)
    private LocalDate datum;  // Datum des Termins (nur DATE)

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

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }
}
