/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador.Cliente;

import datos.ClientesDAO;
import domain.Clientes;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
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
public class clienteServlet extends HttpServlet {

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

//        List<Clientes> clientes = new ClientesDAO().seleccionar();
//        System.out.println("Listado de clientes = " + clientes);
//        request.setAttribute("clientes", clientes);
//        request.getRequestDispatcher("Cliente/clienteHome.jsp").forward(request, response);
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "editar":
                    this.obtenerCliente(request, response);
                    break;
                case "eliminar":
                    this.eliminarCliente(request, response);
                    break;
                default:
                    this.listarClientes(request, response);
                    break;
            }
        } else {
            this.listarClientes(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "insertar":
                    this.insertarCliente(request, response);
                    break;
                case "modificar":
                    this.modificarCliente(request, response);
                    break;
                default:
                    this.listarClientes(request, response);
                    break;
            }
        } else {
            this.listarClientes(request, response);
        }
    }

    protected void listarClientes(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Clientes> clientes = new ClientesDAO().seleccionar();
        System.out.println("Listado de clientes = " + clientes);
        HttpSession sesion = request.getSession();
        sesion.setAttribute("clientes", clientes);
        response.sendRedirect("Cliente/clienteHome.jsp");
    }

    protected void obtenerCliente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Clientes cliente = new Clientes(parseInt(request.getParameter("id_Cliente")));
        cliente = new ClientesDAO().buscar(cliente);

        System.out.println("****************************************");
        System.out.println("Cliente encontrado por id = " + cliente);
        System.out.println("****************************************");

        request.setAttribute("cliente", cliente);
        String jspEditar = "/Cliente/editarCliente.jsp";
        request.getRequestDispatcher(jspEditar).forward(request, response);

        //response.sendRedirect("Cliente/editarCliente.jsp");
        //response.sendRedirect("Cliente/clienteHome.jsp");
    }

    protected void insertarCliente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nombre = request.getParameter("nombre");
        String fecha_afiliacion = request.getParameter("fecha_afiliacion");
        String telefono = request.getParameter("telefono");

        Clientes cliente = new Clientes(nombre, fecha_afiliacion, telefono);
        int registrosInsertado = new ClientesDAO().insertar(cliente);

        this.listarClientes(request, response);
    }

    protected void modificarCliente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id_Cliente = parseInt(request.getParameter("id_Cliente"));
        String nombre = request.getParameter("nombre");
        String fecha_afiliacion = request.getParameter("fecha_afiliacion");
        String telefono = request.getParameter("telefono");

        Clientes cliente = new Clientes(id_Cliente, nombre, fecha_afiliacion, telefono);
        int registrosInsertado = new ClientesDAO().actualizar(cliente);

        this.listarClientes(request, response);
    }

    protected void eliminarCliente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Clientes cliente = new Clientes(parseInt(request.getParameter("id_Cliente")));
        int registrosEliminado = new ClientesDAO().eliminar(cliente);

        System.out.println("Cliente eliminado exitosamente = " + registrosEliminado);

        this.listarClientes(request, response);
    }

//    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        try ( PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet clienteServlet</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet clienteServlet at " + request.getContextPath() + "</h1>");
//            out.println("<h1>Hola Mundo desde el servlet!!</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        }
//        
//    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
//    @Override
//    public String getServletInfo() {
//        return "Short description";
//    }// </editor-fold>
}
