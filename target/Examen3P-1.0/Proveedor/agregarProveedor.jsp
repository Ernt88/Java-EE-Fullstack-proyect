<div class="modal fade" id="agregarProveedorModal">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">

            <div class="modal-header bg-info text-white">
                <h5 class="modal-title">Agregar Proveedor</h5>
                <button class="clse" data-dismiss="modal">
                    <span>&times;</span>
                </button>
            </div>

            <form action="${pageContext.request.contextPath}/proveedorServlet?accion=insertar"
                  method="POST" class="was-validated">
                <div class="modal-body">
                    <div class="form-group">
                        <label for="nombre">Nombre</label>
                        <input type="text" class="form-control" name="nombre" required>
                    </div>
                    <div class="form-group">
                        <label for="telefono">Telefono</label>
                        <input type="tel" class="form-control" name="telefono" required>
                    </div> 
                    <div class="form-group">
                        <label for="firma_farmaceutica">Firma farmaceutica</label>
                        <input type="text" class="form-control" name="firma_farmaceutica" required>
                    </div><!-- comment -->                   
                    <div class="form-group">
                        <label for="correo">Correo</label>
                        <input type="text" class="form-control" name="correo" required>
                    </div>   
                </div>
                <div class="modal-footer">
                    <button class="btn-primary" type="submit">Guardar Proveedor</button>
                </div>

            </form> 

        </div>
    </div>
</div>