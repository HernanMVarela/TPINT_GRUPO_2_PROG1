package frgp.utn.edu.ar.dominio;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "PERSONAS")
public class Persona implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="DNI")
	private String DNI;
	
	@Column(name="NOMBRE", nullable = false)
	private String nombre;
	@Column(name="APELLIDO", nullable = false)
	private String apellido;
	@Column(name="FECHA_NACIMIENTO", nullable = false)
	private Date fecha_nac;
	@Column(name="CORREO", nullable = false)
	private String correo;
	@Column(name="TELEFONO", nullable = false)
	private String telefono;
	
	public Persona(){}

	@Override
	public String toString() {
		return "Cliente [DNI=" + DNI + ", nombre=" + nombre + ", apellido=" + apellido + ", fecha_nac=" + fecha_nac + ", correo=" + correo + ", telefono=" + telefono + "]";
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Date getFecha_nac() {
		return fecha_nac;
	}

	public void setFecha_nac(Date fecha_nac) {
		this.fecha_nac = fecha_nac;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
}
