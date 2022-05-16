package com.anramirez.productos;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class ControladorProductos
 */
@WebServlet("/ControladorProductos")
public class ControladorProductos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ProductosDTO modeloProductos;

	@Resource(name = "jdbc/Productos")
	private DataSource miPool;

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		try {
			modeloProductos = new ProductosDTO(miPool);
		} catch (Exception e) {
			throw new ServletException(e);
		}

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String elComando = request.getParameter("instruccion");

		if (elComando == null)
			elComando = "listar";

		switch (elComando) {
		case "listar":
			obtenerProductos(request, response);
			break;
		case "insertarBBDD":
			try {
				agregarProductos(request, response);
			} catch (ServletException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case "cargar":
			try {
				cargarProductos(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		case "actualizarBBDD":
			try {
				actualizaProductos(request, response);
			} catch (ServletException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "eliminar":
			try {
				eliminarProducto(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}
	}
	/**
	 * Metodo para eliminar un producto a través de su codigo de articulo
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	protected void eliminarProducto(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// Capturar el Código Artículo
		String codigoArticulo = request.getParameter("CArticulo");
		//Borrar el producto de la bbdd
		
		modeloProductos.eliminarProducto(codigoArticulo);
		
		//Volvemos a la lista de productos
		
		obtenerProductos(request, response);

	}
	/**
	 * Método que actualiza un producto
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws SQLException
	 */
	protected void actualizaProductos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, SQLException {
		double precio = 0;
		String codArticulo = request.getParameter("CArt");
		String seccion = request.getParameter("seccion");
		String nomArticulo = request.getParameter("NArt");
		if(request.getParameter("precio")!=null) {
			precio = Double.parseDouble(request.getParameter("precio"));
		}
		String importado = request.getParameter("importado");
		String paisOrigen = request.getParameter("POri");
		// Crear objeto Producto

		Productos productoActualizado = new Productos(codArticulo, seccion, nomArticulo, precio, importado, paisOrigen);
		// Enviar objeto al modelo y despues insertar en la base de datos

		modeloProductos.actualizarProducto(productoActualizado);

		// Volver a listar la tabla de prodcutos y comprobar

		obtenerProductos(request, response);
	}
	/**
	 * Método que carga un producto para actualizarlo
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	protected void cargarProductos(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// leer el codigo articulo que viene del listado
		String codigoArticulo = request.getParameter("CArticulo");
		// enviar el codigo articulo a modelo
		Productos actualizarProducto = modeloProductos.getProducto(codigoArticulo);
		// Colocar el atributo correspondiente al codigo articulo
		request.setAttribute("ProductoActualizar", actualizarProducto);
		// enviar producto al formulario de actualizar
		RequestDispatcher miDispatcher = request.getRequestDispatcher("/actualizarProducto.jsp");
		miDispatcher.forward(request, response);

	}
	/**
	 * Método para agregar un nuevo producto
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws SQLException
	 */
	protected void agregarProductos(HttpServletRequest request, HttpServletResponse response) throws ServletException, SQLException {
		// leer la informacion del producto que viene del formulario

		String codArticulo = request.getParameter("CArt");
		String seccion = request.getParameter("seccion");
		String nomArticulo = request.getParameter("NArt");
		double precio = Double.parseDouble(request.getParameter("precio"));
		String importado = request.getParameter("importado");
		String paisOrigen = request.getParameter("POri");
		// Crear objeto Producto

		Productos nuevoProducto = new Productos(codArticulo, seccion, nomArticulo, precio, importado, paisOrigen);
		// Enviar objeto al modelo y despues insertar en la base de datos

		modeloProductos.agregarElNuevoProducto(nuevoProducto);

		// Volver a listar la tabla de prodcutos y comprobar

		obtenerProductos(request, response);

	}
/**
 * Método que devuelve a todos los productos
 * @param request
 * @param response
 * @throws ServletException
 */
	protected void obtenerProductos(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		List<Productos> productos;
		try {
			productos = modeloProductos.getProductos();
			// agregar lista de productos al request
			request.setAttribute("LISTAPRODUCTOS", productos);
			// enviar request a pagina JSP
			RequestDispatcher miDispatcher = request.getRequestDispatcher("/ListaProductos.jsp");
			miDispatcher.forward(request, response);

		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

}
