<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="org.example.project.Termin" %>
<%@ page import="jakarta.persistence.*" %>
<html lang="de">
<head>
    <meta charset="UTF-8">
    <title>Kalender</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<header>
    <h1>Willkommen im Kalender!</h1>
</header>

<div id="calendar">
    <h2>Deine Termine:</h2>
    <ul>
        <%
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("kalenderPU");
            EntityManager em = emf.createEntityManager();
            String username = (String) session.getAttribute("username");
            List<Termin> termine = em.createQuery("SELECT t FROM Termin t WHERE t.user.username = :username", Termin.class)
                    .setParameter("username", username)
                    .getResultList();
            em.close();

            for (Termin termin : termine) {
        %>
        <li><%= termin.getDatum() %> - <%= termin.getBeschreibung() %></li>
        <% } %>
    </ul>
</div>

<h2>Neuen Termin hinzufügen</h2>
<form action="TerminServlet" method="post">
    <label for="datum">Datum:</label>
    <input type="date" name="datum" id="datum" required><br>

    <label for="beschreibung">Beschreibung:</label>
    <input type="text" name="beschreibung" id="beschreibung" required><br>

    <button type="submit">Hinzufügen</button>
</form>

</body>
</html>
