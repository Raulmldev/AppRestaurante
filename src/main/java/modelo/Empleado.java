package modelo;

import controlador.Procesos;

/**
 * Clase que representa a un empleado en el sistema.
 * 
 * @author Raul
 */

public class Empleado {
	
	/**
	 * Identificador del empleado.
	 */
	private String idEmpleado;
	
	/**
	 * Nombre del empleado.
	 */
	private String nombreEmpleado;
	
	/**
	 * DNI del empleado.
	 */
	private String empleadoDNI;
	
	/**
	 * Dirección del empleado.
	 */
	private String direccionEmpleado;
	
	/**
	 * Número de teléfono del empleado.
	 */
	private String telefonoEmpleado;
	
	/**
	 * Correo electrónico del empleado.
	 */
	private String emailEmpleado;
	
	/**
	 * Rol del empleado.
	 */
	private String rolEmpleado;
	
	/**
	 * Salario del empleado.
	 */
	private double salarioEmpleado;
	
    /**
     * Constructor por defecto de la clase Empleado.
     */
    public Empleado() {
    }
    
    /**
     * Constructor con todos los parámetros de la clase Empleado.
     *
     * @param idEmpleado       Identificador del empleado.
     * @param nombreEmpleado   Nombre del empleado.
     * @param empleadoDNI      DNI del empleado.
     * @param direccionEmpleado Dirección del empleado.
     * @param telefonoEmpleado Número de teléfono del empleado.
     * @param emailEmpleado    Correo electrónico del empleado.
     * @param rolEmpleado      Rol del empleado.
     * @param salarioEmpleado  Salario del empleado.
     */
    public Empleado(String idEmpleado, String nombreEmpleado, String empleadoDNI, String direccionEmpleado, String telefonoEmpleado, 
    		String emailEmpleado, String rolEmpleado, double salarioEmpleado) {
    	this.idEmpleado = idEmpleado;
    	this.nombreEmpleado = nombreEmpleado;
    	this.empleadoDNI = empleadoDNI;
    	this.direccionEmpleado = direccionEmpleado;
    	this.telefonoEmpleado = telefonoEmpleado;
    	this.emailEmpleado = emailEmpleado;
    	this.rolEmpleado = rolEmpleado;
    	this.salarioEmpleado = salarioEmpleado;
    }
	
    //Metodos getter y setter
    
    /**
     * Obtiene el identificador del empleado.
     *
     * @return el identificador del empleado.
     */
	public String getIdEmpleado() {
		return idEmpleado;
	}
	
	/**
     * Establece el identificador del empleado.
     *
     * @param idEmpleado el nuevo identificador del empleado.
     */
	public void setIdEmpleado(String idEmpleado) {
		this.idEmpleado = idEmpleado;
	}
	
	/**
     * Obtiene el nombre del empleado.
     *
     * @return el nombre del empleado.
     */
	public String getNombreEmpleado() {
		return nombreEmpleado;
	}

	/**
     * Establece el nombre del empleado.
     *
     * @param nombreEmpleado el nuevo nombre del empleado.
     */
	public void setNombreEmpleado(String nombreEmpleado) {
		this.nombreEmpleado = nombreEmpleado;
	}

	/**
     * Obtiene el DNI del empleado.
     *
     * @return el DNI del empleado.
     */
	public String getEmpleadoDNI() {
		return empleadoDNI;
	}

	/**
     * Establece el DNI del empleado, validando su formato.
     *
     * @param empleadoDNI el nuevo DNI del empleado.
     */
	public void setEmpleadoDNI(String empleadoDNI) {
		if (Procesos.validarDNI(empleadoDNI)) {
            this.empleadoDNI = empleadoDNI;
        } else {
        	System.out.println("El DNI no es válido");
        }
	}

	/**
     * Obtiene la dirección del empleado.
     *
     * @return la dirección del empleado.
     */
	public String getDireccionEmpleado() {
		return direccionEmpleado;
	}

	/**
     * Establece la dirección del empleado.
     *
     * @param direccionEmpleado la nueva dirección del empleado.
     */
	public void setDireccionEmpleado(String direccionEmpleado) {
		this.direccionEmpleado = direccionEmpleado;
	}

	/**
     * Obtiene el número de teléfono del empleado.
     *
     * @return el número de teléfono del empleado.
     */
	public String getTelefonoEmpleado() {
		return telefonoEmpleado;
	}

	/**
     * Establece el número de teléfono del empleado, validando su formato.
     *
     * @param telefonoEmpleado el nuevo número de teléfono del empleado.
     */
	public void setTelefonoEmpleado(String telefonoEmpleado) {
		if (Procesos.validarTelefono(telefonoEmpleado)) {
            this.telefonoEmpleado = telefonoEmpleado;
        } else {
        	System.out.println("El número de teléfono no es válido");
        }
	}

	/**
     * Obtiene el correo electrónico del empleado.
     *
     * @return el correo electrónico del empleado.
     */
	public String getEmailEmpleado() {
		return emailEmpleado;
	}

	/**
     * Establece el correo electrónico del empleado, validando su formato.
     *
     * @param emailEmpleado el nuevo correo electrónico del empleado.
     */
	public void setEmailEmpleado(String emailEmpleado) {
		if (Procesos.validarEmail(emailEmpleado)) {
            this.emailEmpleado = emailEmpleado;
        } else {
        	System.out.println("La dirección de correo electrónico no es válida");
        }
	}

	/**
     * Obtiene el rol del empleado.
     *
     * @return el rol del empleado.
     */
	public String getRolEmpleado() {
		return rolEmpleado;
	}

	/**
     * Establece el rol del empleado.
     *
     * @param rolEmpleado el nuevo rol del empleado.
     */
	public void setRolEmpleado(String rolEmpleado) {
		this.rolEmpleado = rolEmpleado;
	}

	/**
     * Obtiene el salario del empleado.
     *
     * @return el salario del empleado.
     */
	public double getSalarioEmpleado() {
		return salarioEmpleado;
	}

	/**
     * Establece el salario del empleado.
     *
     * @param salarioEmpleado el nuevo salario del empleado.
     */
	public void setSalarioEmpleado(double salarioEmpleado) {
		this.salarioEmpleado = salarioEmpleado;
	}
}
