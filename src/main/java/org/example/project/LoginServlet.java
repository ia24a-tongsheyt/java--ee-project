package org.example.project;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import jakarta.persistence.*;
import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("kalenderPU");

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        EntityManager em = emf.createEntityManager();
        try {
            long count = em.createQuery("SELECT COUNT(u) FROM User u WHERE u.username = :username AND u.password = :password", Long.class)
                    .setParameter("username", username)
                    .setParameter("password", password)
                    .getSingleResult();

            if (count > 0) {
                request.getSession().setAttribute("username", username);
                response.sendRedirect("calender.jsp");
            } else {
                response.sendRedirect("index.jsp?error=1");
            }
        } finally {
            em.close();
        }
    }

    @Override
    public void destroy() {
        emf.close();
    }
}
