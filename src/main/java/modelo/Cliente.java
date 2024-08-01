package modelo;

import controlador.Procesos;

/**
 * Clase que representa a un cliente en el sistema.
 * 
 * @author Raul
 */
public class Cliente {
	
	/**
	 * Identificador del cliente.
	 */

    private String idCliente;    
	
	/**
	 * Nombre del cliente.
	 */

    private String nombreCliente;
	
	/**
	 * DNI del cliente.
	 */

    private String clienteDNI;   
	
	/**
	 * Dirección del cliente.
	 */

    private String direccionCliente;
	
	/**
	 * Número de teléfono del cliente.
	 */

    private String telefonoCliente;
	
	/**
	 * Correo electrónico del cliente.
	 */

    private String emailCliente;
	
	/**
	 * Puntos del cliente.
	 */

    private int puntosCliente;

    /**
     * Constructor por defecto de la clase Cliente.
     */
    public Cliente() {
    }
    
    /**
     * Constructor con todos los parámetros de la clase Cliente.
     *
     * @param idCliente         Identificador del cliente.
     * @param nombreCliente     Nombre del cliente.
     * @param clienteDNI        DNI del cliente.
     * @param direccionCliente  Dirección del cliente.
     * @param telefonoCliente   Número de teléfono del cliente.
     * @param emailCliente      Correo electrónico del cliente.
     * @param puntosCliente     Puntos del cliente.
     */
    public Cliente(String idCliente, String nombreCliente, String clienteDNI, String direccionCliente, String telefonoCliente,
    		String emailCliente, int puntosCliente) {
    	this.idCliente = idCliente;
    	this.nombreCliente = nombreCliente;
    	this.clienteDNI = clienteDNI;
    	this.direccionCliente = direccionCliente;
    	this.telefonoCliente = telefonoCliente;
    	this.emailCliente = emailCliente;
    	this.puntosCliente = puntosCliente;
    	
    }
    
    // Metodos getters y setters
    
    /**
     * Obtiene el identificador del cliente.
     *
     * @return el identificador del cliente.
     */
    public String getIdCliente() {
        return idCliente;
    }
    
    /**
     * Establece el identificador del cliente.
     *
     * @param idCliente el nuevo identificador del cliente.
     */
    public void setIdCliente(String idCliente) {
    	if (idCliente!=null) {
    		 this.idCliente = idCliente;
    	}else {
    		this.idCliente = Procesos.generarClienteID(8);
    		System.out.println("se ha generado un idCliente nuevo");
    	}
    	
    }
   

    /**
     * Obtiene el nombre del cliente.
     *
     * @return el nombre del cliente.
     */
    public String getNombreCliente() {
        return nombreCliente;
    }

    /**
     * Establece el nombre del cliente.
     *
     * @param nombreCliente el nuevo nombre del cliente.
     */
    public void setNombreCliente(String nombreCliente) {
    	if (nombreCliente!=null) {
    		this.nombreCliente = nombreCliente;
   	
    	}
    }

    /**
     * Obtiene el DNI del cliente.
     *
     * @return el DNI del cliente.
     */
    public String getClienteDNI() {
        return clienteDNI;
    }

    /**
     * Establece el DNI del cliente, validando su formato.
     *
     * @param clienteDNI el nuevo DNI del cliente.
     */
    public void setClienteDNI(String clienteDNI) {
    	
    	if (clienteDNI != null) {
    		
    		if (Procesos.validarDNI(clienteDNI)) {
    			this.clienteDNI = clienteDNI;
    		} else {
    			System.out.println("El DNI no es válido");
            
    		}
    	}
    }

    /**
     * Obtiene la dirección del cliente.
     *
     * @return la dirección del cliente.
     */
    public String getDireccionCliente() {
        return direccionCliente;
    }

    /**
     * Establece la dirección del cliente.
     *
     * @param direccionCliente la nueva dirección del cliente.
     */
    public void setDireccionCliente(String direccionCliente) {
     	if (direccionCliente!=null) {
    		this.direccionCliente = direccionCliente;
   	
    	}
    
    }

    /**
     * Obtiene el número de teléfono del cliente.
     *
     * @return el número de teléfono del cliente.
     */
    public String getTelefonoCliente() {
        return telefonoCliente;
    }

    /**
     * Establece el número de teléfono del cliente, validando su formato.
     *
     * @param telefonoCliente el nuevo número de teléfono del cliente.
     */
    public void setTelefonoCliente(String telefonoCliente) {
    	if (telefonoCliente != null) {
    	if (Procesos.validarTelefono(telefonoCliente)) {
             this.telefonoCliente = telefonoCliente;
         } else {
             System.out.println("El número de teléfono no es válido");
             // Puedes elegir qué hacer en caso de que la validación falle,
             // como dejar el valor actual del campo o asignar un valor predeterminado.
         }
    	}
    }

    /**
     * Obtiene el correo electrónico del cliente.
     *
     * @return el correo electrónico del cliente.
     */
    public String getEmailCliente() {
        return emailCliente;
    }

    /**
     * Establece el correo electrónico del cliente, validando su formato.
     *
     * @param emailCliente el nuevo correo electrónico del cliente.
     */
    public void setEmailCliente(String emailCliente) {
    	 if (emailCliente != null) {
    	        if (Procesos.validarEmail(emailCliente)) {
    	            this.emailCliente = emailCliente;
    	        } else {
    	            // Manejar el caso en el que el correo electrónico no es válido
    	        }
    	    } else {
    	        // Manejar el caso en el que el correo electrónico es null
    	    }
    }

    /**
     * Obtiene los puntos del cliente.
     *
     * @return los puntos del cliente.
     */
    public int getPuntosCliente() {
        return puntosCliente;
    }

    /**
     * Establece los puntos del cliente.
     *
     * @param puntosCliente los nuevos puntos del cliente.
     */
    public void setPuntosCliente(int puntosCliente) {
        if (puntosCliente != -1) {
            
                this.puntosCliente = puntosCliente;
           
        } 
    }
    
    @Override
    public String toString() {
        return "Cliente{" +
                "id='" + idCliente + '\'' +
                ", nombre='" + nombreCliente + '\'' +
                ", dni='" + clienteDNI + '\'' +
                ", direccion='" + direccionCliente + '\'' +
                ", telefono='" + telefonoCliente + '\'' +
                ", email='" + emailCliente + '\'' +
                ", puntos=" + puntosCliente +
                '}';
    }
    
}