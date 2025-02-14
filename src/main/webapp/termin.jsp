<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="de">
<head>
    <meta charset="UTF-8">
    <title>Kalender</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<a href="calender.jsp">
<img src="css/images/logo.png" class="logo">
</a>
<header>
    <h1>Deine Termine</h1>
</header>

<div class="termin-container">
<!-- Formular zum Erstellen eines neuen Termins -->
<h3>Neuen Termin erstellen:</h3>
<form action="TerminServlet" method="post">
    <label for="beschreibung">Beschreibung:</label>
    <input type="text" id="beschreibung" name="beschreibung" required><br><br>

    <label for="datum">Datum:</label>
    <input type="date" id="datum" name="datum" required><br><br>

    <label for="start_time">Startzeit:</label>
    <input type="time" id="start_time" name="start_time" required><br><br>

    <label for="end_time">Endzeit:</label>
    <input type="time" id="end_time" name="end_time" required><br>
    <br><button type="submit">Termin hinzufügen</button>
</form>
</div>
</body>
</html>
