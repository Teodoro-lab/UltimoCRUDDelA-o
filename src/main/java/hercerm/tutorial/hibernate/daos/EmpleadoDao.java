package hercerm.tutorial.hibernate.daos;

import java.util.List;

import hercerm.tutorial.hibernate.entities.Empleado;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class EmpleadoDao {

    private final EntityManager EM;

    public EmpleadoDao(EntityManager entityManager) {
        this.EM = entityManager;
    }

    public void create(Empleado empleado) {
        EntityTransaction transaction = EM.getTransaction();

        try {
            transaction.begin();
            EM.persist(empleado);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
    }

    public List<Empleado> findAll() {
        String queryFindAll = "select m FROM Empleado m";

        return EM.createQuery(queryFindAll, Empleado.class).getResultList();
    }
    
    public Empleado findById(int id) {
        String queryFindById = "select m FROM Empleado m where m.id = " + id;
        return EM.createQuery(queryFindById, Empleado.class).getSingleResult();
    }

    public void update(Empleado empleado) {
        EntityTransaction transaction = EM.getTransaction();

        try {
            transaction.begin();

            // If the entity is not managed in the current persistence context,
            // perform a merge to attach it and consider the changes provided.
            // This will allow transaction.commit() to propagate changes to the DB.
            if (!EM.contains(empleado)) {
                EM.merge(empleado);
            }

            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
    }

    public void delete(Empleado movie) {
        EntityTransaction transaction = EM.getTransaction();

        try {
            transaction.begin();
            EM.remove(movie);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
    }

    public void deleteAll() {
        findAll().stream().forEach(this::delete);
    }
}
