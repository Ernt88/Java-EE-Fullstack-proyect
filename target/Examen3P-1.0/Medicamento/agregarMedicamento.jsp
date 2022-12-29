<div class="modal fade" id="agregarMedicamentoModal">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">

            <div class="modal-header bg-info text-white">
                <h5 class="modal-title">Agregar medicamento</h5>
                <button class="clse" data-dismiss="modal">
                    <span>&times;</span>
                </button>
            </div>

            <form action="${pageContext.request.contextPath}/medicamentoServlet?accion=insertar"
                  method="POST" class="was-validated">
                <div class="modal-body">
                    <div class="form-group">
                        <label for="nombre_medicamento">Nombre del medicamento</label>
                        <input type="text" class="form-control" name="nombre_medicamento" required>
                    </div>
                    <div class="form-group">
                        <label for="laboratorio">Laboratorio</label>
                        <input type="text" class="form-control" name="laboratorio" required>
                    </div>
                    <div class="form-group">
                        <label for="existencias">existencias</label>
                        <input type="number" class="form-control" name="existencias" required>
                    </div>
                    <div class="form-group">
                        <label for="tipo_medicamento">tipo_medicamento</label>
                        <input type="text" class="form-control" name="tipo_medicamento" required>
                    </div>
                    <div class="form-group">
                        <label for="caducidad">caducidad</label>
                        <input type="text" class="form-control" name="caducidad" required>
                    </div>
                    <div class="form-group">
                        <label for="requiere_receta">requiere_receta</label>
                        <input type="number" class="form-control" name="requiere_receta" required>
                    </div>
                </div>
                <div class="modal-footer">
                    <button class="btn-primary" type="submit">Guardar medicamento</button>
                </div>

            </form> 

        </div>
    </div>

</div>