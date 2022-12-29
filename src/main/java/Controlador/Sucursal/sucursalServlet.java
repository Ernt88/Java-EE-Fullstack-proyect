/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador.Sucursal;

import datos.SucursalesDAO;
import domain.Sucursales;
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
public class sucursalServlet extends HttpServlet {

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
                    this.obtenerSucursal(request, response);
                    break;
                case "eliminar":
                    this.eliminarSucursal(request, response);
                    break;
                default:
                    this.listarSucursales(request, response);
                    break;
            }
        } else {
            this.listarSucursales(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "insertar":
                    this.insertarSucursal(request, response);
                    break;
                case "modificar":
                    this.modificarSucursal(request, response);
                    break;
                default:
                    this.listarSucursales(request, response);
                    break;
            }
        } else {
            this.listarSucursales(request, response);
        }
    }

    protected void listarSucursales(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Sucursales> sucursales = new SucursalesDAO().seleccionar();
        System.out.println("Listado de sucursales = " + sucursales);
        HttpSession sesion = request.getSession();
        sesion.setAttribute("sucursales", sucursales);
        response.sendRedirect("Sucursal/sucursalHome.jsp");
    }

    protected void obtenerSucursal(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Sucursales sucursal = new Sucursales(parseInt(request.getParameter("id_sucursal")));
        sucursal = new SucursalesDAO().buscar(sucursal);

        request.setAttribute("sucursal", sucursal);
        String jspEditar = "/Sucursal/editarSucursal.jsp";
        request.getRequestDispatcher(jspEditar).forward(request, response);

        //response.sendRedirect("Cliente/editarCliente.jsp");
        //response.sendRedirect("Cliente/clienteHome.jsp");
    }

    protected void insertarSucursal(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nombre_sucursal = request.getParameter("nombre_sucursal");
        String ubicacion = request.getParameter("ubicacion");
        String id_trabajador_encargadoString = request.getParameter("id_trabajador_encargado");
        String cantidad_empleadosString = request.getParameter("cantidad_empleados");
        
        int id_trabajador_encargado = parseInt(id_trabajador_encargadoString);
        int cantidad_empleados = parseInt(cantidad_empleadosString);
        
        Sucursales sucursal = new Sucursales(nombre_sucursal, ubicacion, id_trabajador_encargado, cantidad_empleados);
        int registrosInsertado = new SucursalesDAO().insertar(sucursal);

        this.listarSucursales(request, response);
    }

    protected void modificarSucursal(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id_sucursal = parseInt(request.getParameter("id_sucursal"));
        String nombre_sucursal = request.getParameter("nombre_sucursal");
        String ubicacion = request.getParameter("ubicacion");
        String id_trabajador_encargadoString = request.getParameter("id_trabajador_encargado");
        String cantidad_empleadosString = request.getParameter("cantidad_empleados");
        
        int id_trabajador_encargado = parseInt(id_trabajador_encargadoString);
        int cantidad_empleados = parseInt(cantidad_empleadosString);
        
        Sucursales sucursal = new Sucursales(id_sucursal, nombre_sucursal, ubicacion, id_trabajador_encargado, cantidad_empleados);
        int registrosInsertado = new SucursalesDAO().actualizar(sucursal);

        this.listarSucursales(request, response);
    }

    protected void eliminarSucursal(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Sucursales sucursal = new Sucursales(parseInt(request.getParameter("id_sucursal")));
        int registrosEliminado = new SucursalesDAO().eliminar(sucursal);

        System.out.println("Sucursal eliminada exitosamente = " + registrosEliminado);

        this.listarSucursales(request, response);
    }

}
