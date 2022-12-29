<div class="modal fade" id="agregarClienteModal">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">

            <div class="modal-header bg-info text-white">
                <h5 class="modal-title">Agregar Cliente</h5>
                <button class="clse" data-dismiss="modal">
                    <span>&times;</span>
                </button>
            </div>

            <form action="${pageContext.request.contextPath}/clienteServlet?accion=insertar"
                  method="POST" class="was-validated">
                <div class="modal-body">
                    <div class="form-group">
                        <label for="nombre">Nombre</label>
                        <input type="text" class="form-control" name="nombre" required>
                    </div>
                    <div class="form-group">
                        <label for="fecha_afiliacion">Fecha de afiliacion</label>
                        <input type="text" class="form-control" name="fecha_afiliacion" required>
                    </div><!-- comment -->
                    <div class="form-group">
                        <label for="telefono">Telefono</label>
                        <input type="tel" class="form-control" name="telefono" required>
                    </div>                 
                </div>
                <div class="modal-footer">
                    <button class="btn-primary" type="submit">Guardar Cliente</button>
                </div>

            </form> 

        </div>
    </div>
</div>