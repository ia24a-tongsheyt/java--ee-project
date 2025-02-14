package org.example.project;

import java.sql.*;
import java.time.LocalDateTime;

public class TerminDAO {
    private Connection connection;

    public TerminDAO(Connection connection) {
        this.connection = connection;
    }

    public void addTermin(Termin termin) throws SQLException {
        String query = "INSERT INTO Termin (datum, startTime, endTime, beschreibung, user_id) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setDate(1, Date.valueOf(termin.getDatum()));  // Nur das Datum setzen (LocalDate -> Date)
            statement.setTime(2, Time.valueOf(termin.getStartTime()));  // Startzeit setzen (LocalTime -> Time)
            statement.setTime(3, Time.valueOf(termin.getEndTime()));  // Endzeit setzen (LocalTime -> Time)
            statement.setString(4, termin.getBeschreibung());  // Beschreibung setzen
            statement.setInt(5, termin.getUser().getUser_id());  // user_id verknüpfen
            statement.executeUpdate();
            System.out.println("Termin erfolgreich erstellt.");
        }
    }

}
