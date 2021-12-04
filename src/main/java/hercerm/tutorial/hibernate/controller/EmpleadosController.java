package hercerm.tutorial.hibernate.controller;

import hercerm.tutorial.hibernate.daos.EmpleadoDao;
import hercerm.tutorial.hibernate.entities.Empleado;
import hercerm.tutorial.hibernate.orm.EntityManagerProvider;
import java.util.List;
import java.util.regex.Pattern;
import javax.persistence.EntityManager;

/**
 *
 * @author
 */
public class EmpleadosController {

    private static final EmpleadoDao empleadoDao;

    static {
        EntityManager defaultEntityManager = EntityManagerProvider
                .open(EntityManagerProvider.DEFAULT_PERSISTENCE_UNIT);
        empleadoDao = new EmpleadoDao(defaultEntityManager);
    }

    public void agregarNuevoEmpleado(Empleado empleado) throws Exception {
        if (this.validateEmpleado(empleado)) {
            empleadoDao.create(empleado);
        }
    }

    public Empleado buscarEmpleado(int id) {
        return empleadoDao.findById(id);
    }

    public void actualizarEmpleado(Empleado empleado) {
        empleadoDao.update(empleado);
    }

    public void borrarEmpleado(Empleado empleado) {
        empleadoDao.delete(empleado);
    }

    public List<Empleado> listarEmpleados() {
        return empleadoDao.findAll();
    }

    public boolean validateEmpleado(Empleado empleado) throws Exception {
        if (!Pattern.matches("[a-zA-Z ]+", empleado.getNombre())) {
            throw (new Exception("Cadena <nombre> invalido"));
        } else if (!Pattern.matches("[a-zA-Z ]+", empleado.getApellido())) {
            throw (new Exception("Cadena <apellido> invalido"));
        } else if (!Pattern.matches("^[a-zA-Z0-9_.+-]+@(yahoo|gmail|outlook)\\.[a-zA-Z0-9-.]+$", empleado.getEmail())) {
            throw (new Exception("Cadena <correo> invalido"));
        }
        return true;
    }
}
