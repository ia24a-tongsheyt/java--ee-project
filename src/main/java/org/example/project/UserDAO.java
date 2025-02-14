package org.example.project;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import java.util.List;

public class UserDAO {
    private EntityManager entityManager;

    public UserDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // Benutzer hinzufügen
    public void addUser(User user) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(user);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    // Benutzer nach ID suchen
    public User getUserById(int id) {
        return entityManager.find(User.class, id);
    }

    // Alle Benutzer abrufen
    public List<User> getAllUsers() {
        return entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
    }

    // Benutzer löschen
    public void deleteUser(User user) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.remove(entityManager.contains(user) ? user : entityManager.merge(user));
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
