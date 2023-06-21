package frgp.utn.edu.ar.dominio;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CLIENTES")
public class Cliente extends Persona implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;
    
    @Column(name = "DIRECCION", nullable = false)
    private String direccion;
    
    @Column(name = "NACIONALIDAD", nullable = false)
    private String nacionalidad;
    
    @Column(name = "CODPOSTAL", nullable = false)
    private String codpostal;
    
    @ManyToOne(cascade = { CascadeType.ALL })
    @JoinColumn(name = "ID_LOCALIDAD", nullable = false)
    private Localidad localidad;
    
    @ManyToOne(cascade = { CascadeType.ALL })
    @JoinColumn(name = "ID_ESTADOCLI", nullable = false)
    private Estado_Cli estado;
    
    public Cliente() {
    	super();
    }
	public Cliente(String direccion, String nacionalidad, String codpostal, Localidad localidad, Estado_Cli estado) 
	{
		this.direccion=direccion;
		this.nacionalidad=nacionalidad;
		this.codpostal=codpostal;
		this.localidad=localidad;
		this.estado=estado;
	}
	@Override
	public String toString() {
		return "Cliente [ID=" + ID + ", direccion=" + direccion + ", nacionalidad="
				+ nacionalidad + ", codpostal=" + codpostal + ", localidad=" + localidad + ", estado=" + estado + super.toString();
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getNacionalidad() {
		return nacionalidad;
	}
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	public String getCodpostal() {
		return codpostal;
	}
	public void setCodpostal(String codpostal) {
		this.codpostal = codpostal;
	}
	public Localidad getLocalidad() {
		return localidad;
	}
	public void setLocalidad(Localidad localidad) {
		this.localidad = localidad;
	}
	public Estado_Cli getEstado() {
		return estado;
	}
	public void setEstado(Estado_Cli estado) {
		this.estado = estado;
	}
	
}
