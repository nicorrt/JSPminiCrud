package com.anramirez.productos;

import java.util.Objects;

public class Productos {

	private String codigoArticulo;
	private String seccion;
	private String nombreArticulo;
	private double precio;
	private String importado;
	private String pOrigen;

	public Productos(String codigoArticulo, String seccion, String nombreArticulo, double precio, String importado,
			String pOrigen) {
		super();
		this.codigoArticulo = codigoArticulo;
		this.seccion = seccion;
		this.nombreArticulo = nombreArticulo;
		this.precio = precio;
		this.importado = importado;
		this.pOrigen = pOrigen;
	}

	public Productos(String seccion, String nombreArticulo, double precio, String importado, String pOrigen) {
		super();
		this.seccion = seccion;
		this.nombreArticulo = nombreArticulo;
		this.precio = precio;
		this.importado = importado;
		this.pOrigen = pOrigen;
	}

	public Productos() {
		super();
	}

	public String getCodigoArticulo() {
		return codigoArticulo;
	}

	public void setCodigoArticulo(String codigoArticulo) {
		this.codigoArticulo = codigoArticulo;
	}

	public String getSeccion() {
		return seccion;
	}

	public void setSeccion(String seccion) {
		this.seccion = seccion;
	}

	public String getNombreArticulo() {
		return nombreArticulo;
	}

	public void setNombreArticulo(String nombreArticulo) {
		this.nombreArticulo = nombreArticulo;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getImportado() {
		return importado;
	}

	public void setImportado(String importado) {
		this.importado = importado;
	}

	public String getpOrigen() {
		return pOrigen;
	}

	public void setpOrigen(String pOrigen) {
		this.pOrigen = pOrigen;
	}

	@Override
	public String toString() {
		return "Productos [codigoArticulo=" + codigoArticulo + ", seccion=" + seccion + ", nombreArticulo="
				+ nombreArticulo + ", precio=" + precio + ", importado=" + importado + ", pOrigen=" + pOrigen + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigoArticulo, importado, nombreArticulo, pOrigen, precio, seccion);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Productos other = (Productos) obj;
		return Objects.equals(codigoArticulo, other.codigoArticulo) && Objects.equals(importado, other.importado)
				&& Objects.equals(nombreArticulo, other.nombreArticulo) && Objects.equals(pOrigen, other.pOrigen)
				&& Double.doubleToLongBits(precio) == Double.doubleToLongBits(other.precio)
				&& Objects.equals(seccion, other.seccion);
	}

}
