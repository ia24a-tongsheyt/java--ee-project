package org.example.project;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import jakarta.persistence.*;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/TerminServlet")  // Servlet-URL ist "/TerminServlet"
public class TerminServlet extends HttpServlet {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("kalenderPU");

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Parameter aus dem Formular holen
        String datum = request.getParameter("datum");
        String beschreibung = request.getParameter("beschreibung");
        String username = (String) request.getSession().getAttribute("username");  // Username aus der Session holen

        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            // Neuen Termin erstellen und speichern
            Termin termin = new Termin();
            termin.setDatum(LocalDate.parse(datum));  // Datum konvertieren
            termin.setBeschreibung(beschreibung);

            // Benutzer (User) zur Verbindung hinzufügen
            User user = em.createQuery("SELECT u FROM User u WHERE u.username = :username", User.class)
                    .setParameter("username", username)
                    .getSingleResult();
            termin.setUser(user);

            em.persist(termin);  // Termin in der Datenbank speichern
            em.getTransaction().commit();

            response.sendRedirect("calender.jsp");  // Zurück zur Kalenderseite
        } finally {
            em.close();
        }
    }

    @Override
    public void destroy() {
        emf.close();  // Ressourcen freigeben
    }
}
