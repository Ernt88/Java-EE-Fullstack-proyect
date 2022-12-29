/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import static datos.conexion.close;
import static datos.conexion.getConnection;
import domain.Provedores;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author poiu0
 */
public class ProvedoresDAO {

    private static final String SQL_SELECT = "SELECT id_proveedor, nombre, telefono, firma_farmaceutica, correo FROM proveedor";
    private static final String SQL_SELECT_BY_ID = "SELECT id_proveedor, nombre, telefono, firma_farmaceutica, correo FROM proveedor WHERE id_proveedor = ?";
    private static final String SQL_INSERT = "INSERT INTO proveedor (nombre, telefono, firma_farmaceutica, correo) VALUES (?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE proveedor SET nombre = ?, telefono = ?, firma_farmaceutica = ?, correo = ? WHERE id_proveedor = ?";
    private static final String SQL_DELETE = "DELETE FROM proveedor WHERE id_proveedor = ?";

    public List<Provedores> seleccionar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Provedores proveedor = null;
        List<Provedores> prov = new ArrayList<>();

        try {

            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();

            while (rs.next()) {

                int id_proveedor = rs.getInt("id_proveedor");
                String nombre = rs.getString("nombre");
                String telefono = rs.getString("telefono");
                String firma_farmaceutica = rs.getString("firma_farmaceutica");
                String correo = rs.getString("correo");

                proveedor = new Provedores(id_proveedor, nombre, telefono, firma_farmaceutica, correo);
                System.out.println(proveedor);

                prov.add(proveedor);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(rs);
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return prov;
    }

    public int insertar(Provedores proveedor) {
        Connection conn = null;
        PreparedStatement stmt = null;

        int registros = 0;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, proveedor.getNombre());
            stmt.setString(2, proveedor.getTelefono());
            stmt.setString(3, proveedor.getFirma_farmaceutica());
            stmt.setString(4, proveedor.getCorreo());

            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }

    public Provedores buscar(Provedores proveedor) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {

            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setInt(1, proveedor.getId_proveedor());
            rs = stmt.executeQuery();

            rs.next();
            int id_proveedor = rs.getInt("id_proveedor");
            String nombre = rs.getString("nombre");
            String telefono = rs.getString("telefono");
            String firma_farmaceutica = rs.getString("firma_farmaceutica");
            String correo = rs.getString("correo");

            proveedor.setId_proveedor(id_proveedor);
            proveedor.setNombre(nombre);
            proveedor.setTelefono(telefono);
            proveedor.setFirma_farmaceutica(firma_farmaceutica);
            proveedor.setCorreo(correo);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(rs);
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return proveedor;
    }

    public int actualizar(Provedores proveedor) {
        Connection conn = null;
        PreparedStatement stmt = null;

        int registros = 0;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, proveedor.getNombre());
            stmt.setString(2, proveedor.getTelefono());
            stmt.setString(3, proveedor.getFirma_farmaceutica());
            stmt.setString(4, proveedor.getCorreo());
            stmt.setInt(5, proveedor.getId_proveedor());

            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }

    public int eliminar(Provedores proveedor) {
        Connection conn = null;
        PreparedStatement stmt = null;

        int registros = 0;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, proveedor.getId_proveedor());

            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }
}
