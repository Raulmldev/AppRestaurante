package controlador;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import modelo.Coordinador;

public class Conexion {

    private Coordinador miCoordinador;
    private SessionFactory sessionFactory;

    /**
     * Establece la conexión con la base de datos.
     */
    public void conectar() {
    	 try {
    		 System.out.println("INICIANDO CONFIGURACION DE LA CONEXION. . . ");

    		 Configuration cfg = new Configuration().configure();
    		 sessionFactory = cfg.buildSessionFactory(new StandardServiceRegistryBuilder().configure().build());

    		 if (sessionFactory != null) {
    			 System.out.println(". . . CONFIGURACION DE LA CONEXION REALIZADA");
    		 } else {
    			 System.out.println(". . . ERROR: No se pudo configurar la conexión");
    		 }
    	 } catch (Exception e) {
    		 System.out.println(". . . ERROR: No se pudo configurar la conexión");
    		 e.printStackTrace();
    	 }
    }

    /**
     * Obtiene la sesión de Hibernate.
     *
     * @return La sesión de Hibernate.
     */
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    /**
     * Cierra la conexión con la base de datos.
     */
    public void desconectar() {
        if (sessionFactory != null && !sessionFactory.isClosed()) {
            sessionFactory.close();
            System.out.println("Desconectado del sessionFactory");
        }
    }

    public Coordinador getCoordinador() {
        return miCoordinador;
    }

    public void setCoordinador(Coordinador miCoordinador) {
        this.miCoordinador = miCoordinador;
    }
}