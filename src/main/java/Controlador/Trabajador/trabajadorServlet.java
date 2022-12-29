/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador.Trabajador;

import datos.TrabajadoresDAO;
import domain.Trabajadores;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Integer.parseInt;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author luisz
 */
public class trabajadorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

//        List<Clientes> clientes = new ClientesDAO().seleccionar();
//        System.out.println("Listado de clientes = " + clientes);
//        request.setAttribute("clientes", clientes);
//        request.getRequestDispatcher("Cliente/clienteHome.jsp").forward(request, response);
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "editar":
                    this.obtenerTrabajador(request, response);
                    break;
                case "eliminar":
                    this.eliminarTrabajador(request, response);
                    break;
                default:
                    this.listarTrabajadores(request, response);
                    break;
            }
        } else {
            this.listarTrabajadores(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "insertar":
                    this.insertarTrabajador(request, response);
                    break;
                case "modificar":
                    this.modificarTrabajador(request, response);
                    break;
                default:
                    this.listarTrabajadores(request, response);
                    break;
            }
        } else {
            this.listarTrabajadores(request, response);
        }
    }

    protected void listarTrabajadores(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Trabajadores> trabajadores = new TrabajadoresDAO().seleccionar();
        System.out.println("Listado de trabajadores = " + trabajadores);
        HttpSession sesion = request.getSession();
        sesion.setAttribute("trabajadores", trabajadores);
        response.sendRedirect("Trabajador/trabajadorHome.jsp");
    }

    protected void obtenerTrabajador(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Trabajadores trabajador = new Trabajadores(parseInt(request.getParameter("id_trabajador")));
        trabajador = new TrabajadoresDAO().buscar(trabajador);

        request.setAttribute("trabajador", trabajador);
        String jspEditar = "/Trabajador/editarTrabajador.jsp";
        request.getRequestDispatcher(jspEditar).forward(request, response);

        //response.sendRedirect("Cliente/editarCliente.jsp");
        //response.sendRedirect("Cliente/clienteHome.jsp");
    }

    protected void insertarTrabajador(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nombre = request.getParameter("nombre");
        String id_sucursalString = request.getParameter("id_sucursal");
        String telefono = request.getParameter("telefono");
        String n_afiliacion_imss = request.getParameter("n_afiliacion_imss");
        
        int id_sucursal = parseInt(id_sucursalString);

        Trabajadores trabajador = new Trabajadores(nombre, id_sucursal, telefono, n_afiliacion_imss);
        int registrosInsertado = new TrabajadoresDAO().insertar(trabajador);

        this.listarTrabajadores(request, response);
    }

    protected void modificarTrabajador(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id_trabajador = parseInt(request.getParameter("id_trabajador"));
        String nombre = request.getParameter("nombre");
        String id_sucursalString = request.getParameter("id_sucursal");
        String telefono = request.getParameter("telefono");
        String n_afiliacion_imss = request.getParameter("n_afiliacion_imss");
        
        int id_sucursal = parseInt(id_sucursalString);

        Trabajadores trabajador = new Trabajadores(id_trabajador, nombre, id_sucursal, telefono, n_afiliacion_imss);
        int registrosInsertado = new TrabajadoresDAO().insertar(trabajador);

        this.listarTrabajadores(request, response);
    }

    protected void eliminarTrabajador(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Trabajadores trabajador = new Trabajadores(parseInt(request.getParameter("id_trabajador")));
        int registrosEliminado = new TrabajadoresDAO().eliminar(trabajador);

        System.out.println("Trabajador eliminado exitosamente = " + registrosEliminado);

        this.listarTrabajadores(request, response);
    }

}
