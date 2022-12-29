<div class="modal fade" id="agregarTrabajadorModal">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">

            <div class="modal-header bg-info text-white">
                <h5 class="modal-title">Agregar Trabajador</h5>
                <button class="clse" data-dismiss="modal">
                    <span>&times;</span>
                </button>
            </div>

            <form action="${pageContext.request.contextPath}/trabajadorServlet?accion=insertar"
                  method="POST" class="was-validated">
                <div class="modal-body">
                    
                    <div class="form-group">
                        <label for="nombre">Nombre</label>
                        <input type="text" class="form-control" name="nombre" required>
                    </div>
                    <div class="form-group">
                        <label for="id_sucursal">Id de la sucursal en que trabaja</label>
                        <input type="number" class="form-control" name="id_sucursal" required>
                    </div><!-- comment -->
                    <div class="form-group">
                        <label for="telefono">Telefono</label>
                        <input type="tel" class="form-control" name="telefono" required>
                    </div>
                    <div class="form-group">
                        <label for="n_afiliacion_imss">Numero de afiliacion al IMMS</label>
                        <input type="text" class="form-control" name="n_afiliacion_imss" required>
                    </div>
                </div>
                <div class="modal-footer">
                    <button class="btn-primary" type="submit">Guardar Trabajador</button>
                </div>

            </form> 

        </div>
    </div>
</div>