/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

/**
 *
 * @author poiu0
 */
public class Medicamentos {

    private int id_medicamento;
    private String nombre_medicamento;
    private String laboratorio;
    private int existencias;
    private String tipo_medicamento;
    private String caducidad;
    private Boolean requiere_receta;

    public Medicamentos(int id_medicamento, String nombre_medicamento, String laboratorio, int existencias, String tipo_medicamento, String caducidad, Boolean requiere_receta) {
        this.id_medicamento = id_medicamento;
        this.nombre_medicamento = nombre_medicamento;
        this.laboratorio = laboratorio;
        this.existencias = existencias;
        this.tipo_medicamento = tipo_medicamento;
        this.caducidad = caducidad;
        this.requiere_receta = requiere_receta;
    }
    
    public Medicamentos(String nombre_medicamento, String laboratorio, int existencias, String tipo_medicamento, String caducidad, Boolean requiere_receta) {
        this.nombre_medicamento = nombre_medicamento;
        this.laboratorio = laboratorio;
        this.existencias = existencias;
        this.tipo_medicamento = tipo_medicamento;
        this.caducidad = caducidad;
        this.requiere_receta = requiere_receta;
    }
    
    public Medicamentos(int id_medicamento) {
        this.id_medicamento = id_medicamento;
    }

    public int getId_medicamento() {
        return id_medicamento;
    }

    public void setId_medicamento(int id_medicamento) {
        this.id_medicamento = id_medicamento;
    }

    public String getNombre_medicamento() {
        return nombre_medicamento;
    }

    public void setNombre_medicamento(String nombre_medicamento) {
        this.nombre_medicamento = nombre_medicamento;
    }

    public String getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(String laboratorio) {
        this.laboratorio = laboratorio;
    }

    public int getExistencias() {
        return existencias;
    }

    public void setExistencias(int existencias) {
        this.existencias = existencias;
    }

    public String getTipo_medicamento() {
        return tipo_medicamento;
    }

    public void setTipo_medicamento(String tipo_medicamento) {
        this.tipo_medicamento = tipo_medicamento;
    }

    public String getcaducidad() {
        return caducidad;
    }

    public void setcaducidad(String caducidad) {
        this.caducidad = caducidad;
    }

    public Boolean getRequiere_receta() {
        return requiere_receta;
    }

    public void setRequiere_receta(Boolean requiere_receta) {
        this.requiere_receta = requiere_receta;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Medicamentos{");
        sb.append("id_medicamento=").append(id_medicamento);
        sb.append(", nombre_medicamento=").append(nombre_medicamento);
        sb.append(", laboratorio=").append(laboratorio);
        sb.append(", existencias=").append(existencias);
        sb.append(", tipo_medicamento=").append(tipo_medicamento);
        sb.append(", caducidad=").append(caducidad);
        sb.append(", require_receta=").append(requiere_receta);
        sb.append('}');
        return sb.toString();
    }

}
