package frgp.utn.edu.ar.dominio;

import java.io.Serializable;
import java.sql.Date;

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
@Table(name = "PRESTAMOS")
public class Prestamo implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="NUM_PRESTAMO")
	private int numPrestamo;
	
	@ManyToOne(cascade= {CascadeType.ALL})
	@JoinColumn(name="ID",nullable = false)
	private Cliente cliente;
	
	@Column(name="MONTO", nullable = false)
	private float monto;
	
	@Column(name="COUTAS", nullable = false)
	private int coutas;
	
	@Column(name="FECHA", nullable = false)
	private Date fecha;
	
	public Prestamo() {}
	
	public Prestamo(Cliente cliente, float monto, int coutas, Date fecha) {
		this.cliente = cliente;
		this.monto = monto;
		this.coutas = coutas;
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "Prestamo [numPrestamo=" + numPrestamo + ", cliente=" + cliente + ", monto=" + monto + ", coutas="
				+ coutas + ", fecha=" + fecha + "]";
	}

	public int getNumPrestamo() {
		return numPrestamo;
	}

	public void setNumPrestamo(int numPrestamo) {
		this.numPrestamo = numPrestamo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public float getMonto() {
		return monto;
	}

	public void setMonto(float monto) {
		this.monto = monto;
	}

	public int getCoutas() {
		return coutas;
	}

	public void setCoutas(int coutas) {
		this.coutas = coutas;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
}
