<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="de">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="css/style.css"> <!-- Externe CSS-Datei einbinden -->
</head>
<body>

<img src="css/images/logo.png" class="logo">





<div class="login-container">
    <h1>Bitte loggen Sie sich ein</h1>

    <form action="LoginServlet" method="post">
        <label for="username">Benutzername:</label>
        <input type="text" name="username" id="username" required><br><br>

        <label for="password">Passwort:</label>
        <input type="password" name="password" id="password" required><br>

        <button type="submit">Anmelden</button>
    </form>

    <% if (request.getParameter("error") != null) { %>
    <p class="error">Login fehlgeschlagen. Bitte versuchen Sie es erneut.</p>
    <% } %>
</div>

</body>
</html>