package frgp.utn.edu.ar.dominio;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PROVINCIAS")
public class Provincia implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_PROVINCIA")	
	private int ID;
	
	@Column(name="NOMBRE", nullable = false)
	private String nombre;
	
	public Provincia(){}
	public Provincia(String nombre)
	{
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Provincia [ID=" + ID + ", nombre=" + nombre + "]";
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
