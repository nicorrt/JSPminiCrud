package com.anramirez.productos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class ProductosDTO {

	private DataSource origenDatos;

	public ProductosDTO(DataSource origenDatos) {
		super();
		this.origenDatos = origenDatos;
	}

	public List<Productos> getProductos() throws Exception {

		List<Productos> productos = new ArrayList<>();
		Connection miConexion = null;
		Statement miStatement = null;
		ResultSet miResultSet = null;
		try {
			miConexion = origenDatos.getConnection();
			String miSql = "SELECT * FROM PRODUCTOS";
			miStatement = miConexion.createStatement();
			miResultSet = miStatement.executeQuery(miSql);

			while (miResultSet.next()) {

				String codigoArticulo = miResultSet.getString("CodigoArticulo");
				String seccion = miResultSet.getString("Seccion");
				String nombreArticulo = miResultSet.getString("NombreArticulo");
				double precio = miResultSet.getDouble("Precio");
				String importado = miResultSet.getString("importado");
				String pOrigen = miResultSet.getString("PaisOrigen");

				Productos tempProducto = new Productos(codigoArticulo, seccion, nombreArticulo, precio, importado,
						pOrigen);
				productos.add(tempProducto);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			miStatement.close();
			miConexion.close();
		}
		return productos;

	}

	public void agregarElNuevoProducto(Productos nuevoProducto) throws SQLException {

		Connection miConexion = null;
		PreparedStatement miStatement = null;

		try {
			// Obtener la conexion
			miConexion = origenDatos.getConnection();
			// Crear la instruccion sql que inserte el producto
			String sql = "INSERT INTO productos (CodigoArticulo,Seccion,NombreArticulo,Precio,Importado,PaisOrigen)"
					+ "VALUES(?,?,?,?,?,?)";
			miStatement = miConexion.prepareStatement(sql);
			// establecer parametros para el producto
			miStatement.setString(1, nuevoProducto.getCodigoArticulo());
			miStatement.setString(2, nuevoProducto.getSeccion());
			miStatement.setString(3, nuevoProducto.getNombreArticulo());
			miStatement.setDouble(4, nuevoProducto.getPrecio());
			miStatement.setString(5, nuevoProducto.getImportado());
			miStatement.setString(6, nuevoProducto.getpOrigen());
			// Ejecutar la instruccion

			miStatement.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			miStatement.close();
			miConexion.close();
		}
	}

	public Productos getProducto(String codigoArticuloActualizar) throws Exception {
		Productos producto = new Productos();
		Connection miConexion = null;
		PreparedStatement miStatement = null;
		ResultSet miResultSet = null;

		try {
			miConexion = origenDatos.getConnection();
			String miSql = "SELECT * FROM PRODUCTOS WHERE CodigoArticulo = ?";
			miStatement = miConexion.prepareStatement(miSql);
			miStatement.setString(1, codigoArticuloActualizar);
			miResultSet = miStatement.executeQuery();

			if (miResultSet.next()) {
				String codigoArticulo = miResultSet.getString("CodigoArticulo");
				String seccion = miResultSet.getString("Seccion");
				String nombreArticulo = miResultSet.getString("NombreArticulo");
				double precio = miResultSet.getDouble("Precio");
				String importado = miResultSet.getString("importado");
				String pOrigen = miResultSet.getString("PaisOrigen");

				producto = new Productos(codigoArticulo, seccion, nombreArticulo, precio, importado, pOrigen);
				System.out.println(producto);
			} else {
				throw new Exception("No se encuentra el producto " + codigoArticuloActualizar);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			miStatement.close();
			miConexion.close();
		}

		return producto;

	}

	public void actualizarProducto(Productos productoActualizado) throws SQLException {
		Connection miConexion = null;
		PreparedStatement miStatement = null;
		try {
			miConexion = origenDatos.getConnection();

			String sql = "UPDATE productos SET Seccion=?, NombreArticulo=?, Precio=?, Importado=?, PaisOrigen=? WHERE CodigoArticulo=?";

			miStatement = miConexion.prepareStatement(sql);
			// establecer parametros para el producto
			miStatement.setString(6, productoActualizado.getCodigoArticulo());
			miStatement.setString(1, productoActualizado.getSeccion());
			miStatement.setString(2, productoActualizado.getNombreArticulo());
			miStatement.setDouble(3, productoActualizado.getPrecio());
			miStatement.setString(4, productoActualizado.getImportado());
			miStatement.setString(5, productoActualizado.getpOrigen());
			// Ejecutar la instruccion

			miStatement.execute();
		} finally {
			miStatement.close();
			miConexion.close();
		}

	}

	public void eliminarProducto(String codigoArticulo) throws SQLException {
		Connection miConexion = null;
		PreparedStatement miStatement = null;
		try {

			miConexion = origenDatos.getConnection();

			String sql = "DELETE FROM productos WHERE CodigoArticulo=?";

			miStatement = miConexion.prepareStatement(sql);

			miStatement.setString(1, codigoArticulo);
			miStatement.execute();
		} finally {
			miStatement.close();
			miConexion.close();
		}

	}

}
