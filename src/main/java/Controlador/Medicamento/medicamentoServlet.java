/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador.Medicamento;

import datos.MedicamentosDAO;
import domain.Medicamentos;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Boolean.parseBoolean;
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
public class medicamentoServlet extends HttpServlet {

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
                    this.obtenerMedicamento(request, response);
                    break;
                case "eliminar":
                    this.eliminarMedicamento(request, response);
                    break;
                default:
                    this.listarMedicamentos(request, response);
                    break;
            }
        } else {
            this.listarMedicamentos(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "insertar":
                    this.insertarMedicamento(request, response);
                    break;
                case "modificar":
                    this.modificarMedicamento(request, response);
                    break;
                default:
                    this.listarMedicamentos(request, response);
                    break;
            }
        } else {
            this.listarMedicamentos(request, response);
        }
    }

    protected void listarMedicamentos(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Medicamentos> medicamentos = new MedicamentosDAO().seleccionar();
        System.out.println("Listado de medicamentos = " + medicamentos);
        HttpSession sesion = request.getSession();
        sesion.setAttribute("medicamentos", medicamentos);
        response.sendRedirect("Medicamento/medicamentoHome.jsp");
    }

    protected void obtenerMedicamento(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Medicamentos medicamento = new Medicamentos(parseInt(request.getParameter("id_medicamento")));
        medicamento = new MedicamentosDAO().buscar(medicamento);

        request.setAttribute("medicamento", medicamento);
        String jspEditar = "/Medicamento/editarMedicamento.jsp";
        request.getRequestDispatcher(jspEditar).forward(request, response);

        //response.sendRedirect("medicamento/editarmedicamento.jsp");
        //response.sendRedirect("medicamento/medicamentoHome.jsp");
    }

    protected void insertarMedicamento(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nombre_medicamento = request.getParameter("nombre_medicamento");
        String laboratorio = request.getParameter("laboratorio");
        String caducidad = request.getParameter("caducidad");
        String existenciasString = request.getParameter("existencias");
        String tipo_medicamento = request.getParameter("tipo_medicamento");
        String requiere_recetaString = request.getParameter("requiere_receta");
        
        int existencias = parseInt(existenciasString);
        Boolean requiere_receta = parseBoolean(requiere_recetaString);
        
        System.out.println("REQUIERE RECETA ------------------------::::::::::: " + requiere_receta);

        Medicamentos medicamento = new Medicamentos(nombre_medicamento, laboratorio, existencias, tipo_medicamento, caducidad, requiere_receta);
        int registrosInsertado = new MedicamentosDAO().insertar(medicamento);

        this.listarMedicamentos(request, response);
    }

    protected void modificarMedicamento(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id_medicamento = parseInt(request.getParameter("id_medicamento"));
        String nombre_medicamento = request.getParameter("nombre_medicamento");
        String laboratorio = request.getParameter("laboratorio");
        String caducidad = request.getParameter("caducidad");
        String existenciasString = request.getParameter("existencias");
        String tipo_medicamento = request.getParameter("tipo_medicamento");
        String requiere_recetaString = request.getParameter("requiere_receta");
        
        int existencias = parseInt(existenciasString);
        Boolean requiere_receta = parseBoolean(requiere_recetaString);

        Medicamentos medicamento = new Medicamentos(id_medicamento, nombre_medicamento, laboratorio, existencias, tipo_medicamento, caducidad, requiere_receta);
        int registrosInsertado = new MedicamentosDAO().actualizar(medicamento);

        this.listarMedicamentos(request, response);
    }

    protected void eliminarMedicamento(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Medicamentos medicamento = new Medicamentos(parseInt(request.getParameter("id_medicamento")));
        int registrosEliminado = new MedicamentosDAO().eliminar(medicamento);

        System.out.println("medicamento eliminado exitosamente = " + registrosEliminado);

        this.listarMedicamentos(request, response);
    }
    
    
    
    
//    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        try ( PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet medicamentoServlet</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet medicamentoServlet at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        }
//    }

}
