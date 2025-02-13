<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="de">
<head>
    <meta charset="UTF-8">
    <title>Kalender</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<header>
    <h1>Kalender für Januar 2025</h1>
</header>

<h2>Deine Termine:</h2>

<!-- Formular zum Erstellen eines neuen Termins -->
<h3>Neuen Termin erstellen:</h3>
<form action="TerminServlet" method="post">
    <label for="beschreibung">Beschreibung:</label>
    <input type="text" id="beschreibung" name="beschreibung" required><br>

    <label for="datum">Datum:</label>
    <input type="date" id="datum" name="datum" required><br>

    <label for="start_time">Startzeit:</label>
    <input type="time" id="start_time" name="start_time" required><br>

    <label for="end_time">Endzeit:</label>
    <input type="time" id="end_time" name="end_time" required><br>

    <button type="submit">Termin hinzufügen</button>
</form>

</body>
</html>
