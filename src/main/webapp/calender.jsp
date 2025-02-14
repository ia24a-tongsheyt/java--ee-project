<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="org.example.project.Termin" %>
<%@ page import="jakarta.persistence.*" %>
<%@ page import="java.time.LocalDate" %>
<!DOCTYPE html>
<html lang="de">
<head>
    <meta charset="UTF-8">
    <title>Kalender</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<img src="css/images/logo.png" class="logo">
<header>
    <h1>Kalender für 2025</h1>
</header>

<h2>Deine Termine:</h2>
<table border="1">
    <thead>
    <tr>
        <th>Montag</th>
        <th>Dienstag</th>
        <th>Mittwoch</th>
        <th>Donnerstag</th>
        <th>Freitag</th>
        <th>Samstag</th>
        <th>Sonntag</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <%
            // Formatieren des Datums, um sicherzustellen, dass der Tag immer zwei Stellen hat
            String[] januar = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
            for (int i = 0; i < januar.length; i++) {
                // Formatieren des Tags, um sicherzustellen, dass der Tag immer zwei Stellen hat
                String tag = januar[i].length() == 1 ? "0" + januar[i] : januar[i];  // Führende Null hinzufügen
                String datumString = "2025-01-" + tag;  // Datum im richtigen Format erstellen

                // Datum als LocalDate erstellen
                LocalDate datum = LocalDate.parse(datumString);

                // Query mit LocalDate statt String
                EntityManagerFactory emf = Persistence.createEntityManagerFactory("kalenderPU");
                EntityManager em = emf.createEntityManager();
                List<Termin> termine = em.createQuery("SELECT t FROM Termin t WHERE t.datum = :datum", Termin.class)
                        .setParameter("datum", datum) // Verwende LocalDate hier
                        .getResultList();
                em.close();

                for (Termin termin : termine) {
        %>
        <li><%= termin.getBeschreibung() %> (von <%= termin.getStartTime() %> bis <%= termin.getEndTime() %>)</li>
        <%
                }
            }
        %>
    </tr>
    </tbody>
</table>
<form action="termin.jsp" method="get">
    <button type="submit"> Termin erstellen</button>

</form>
</body>
</html>
