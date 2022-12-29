/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador.Proveedor;

import datos.ProvedoresDAO;
import domain.Provedores;
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
public class proveedorServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "editar":
                    this.obtenerProveedor(request, response);
                    break;
                case "eliminar":
                    this.eliminarProveedor(request, response);
                    break;
                default:
                    this.listarProveedores(request, response);
                    break;
            }
        } else {
            this.listarProveedores(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "insertar":
                    this.insertarProveedor(request, response);
                    break;
                case "modificar":
                    this.modificarProveedor(request, response);
                    break;
                default:
                    this.listarProveedores(request, response);
                    break;
            }
        } else {
            this.listarProveedores(request, response);
        }
    }

    protected void listarProveedores(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Provedores> proveedores = new ProvedoresDAO().seleccionar();
        System.out.println("Listado de proveedores = " + proveedores);
        HttpSession sesion = request.getSession();
        sesion.setAttribute("proveedores", proveedores);
        response.sendRedirect("Proveedor/proveedorHome.jsp");
    }

    protected void obtenerProveedor(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Provedores proveedor = new Provedores(parseInt(request.getParameter("id_proveedor")));
        proveedor = new ProvedoresDAO().buscar(proveedor);

        request.setAttribute("proveedor", proveedor);
        String jspEditar = "/Proveedor/editarProveedor.jsp";
        request.getRequestDispatcher(jspEditar).forward(request, response);

        //response.sendRedirect("medicamento/editarmedicamento.jsp");
        //response.sendRedirect("medicamento/medicamentoHome.jsp");
    }

    protected void insertarProveedor(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nombre = request.getParameter("nombre");
        String telefono = request.getParameter("telefono");
        String firma_farmaceutica = request.getParameter("firma_farmaceutica");
        String correo = request.getParameter("correo");
        
       
        Provedores proveedor = new Provedores(nombre, telefono, firma_farmaceutica, correo);
        int registrosInsertado = new ProvedoresDAO().insertar(proveedor);

        this.listarProveedores(request, response);
    }

    protected void modificarProveedor(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id_proveedor = parseInt(request.getParameter("id_proveedor"));
        String nombre = request.getParameter("nombre");
        String telefono = request.getParameter("telefono");
        String firma_farmaceutica = request.getParameter("firma_farmaceutica");
        String correo = request.getParameter("correo");
        
       
        Provedores proveedor = new Provedores(nombre, telefono, firma_farmaceutica, correo);
        int registrosInsertado = new ProvedoresDAO().insertar(proveedor);

        this.listarProveedores(request, response);
    }

    protected void eliminarProveedor(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Provedores proveedor = new Provedores(parseInt(request.getParameter("id_proveedor")));
        int registrosEliminado = new ProvedoresDAO().eliminar(proveedor);

        System.out.println("Proveedor eliminado exitosamente = " + registrosEliminado);

        this.listarProveedores(request, response);
    }

}
