<div class="modal fade" id="agregarSucursalModal">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">

            <div class="modal-header bg-info text-white">
                <h5 class="modal-title">Agregar Sucursal</h5>
                <button class="clse" data-dismiss="modal">
                    <span>&times;</span>
                </button>
            </div>

            <form action="${pageContext.request.contextPath}/sucursalServlet?accion=insertar"
                  method="POST" class="was-validated">
                <div class="modal-body">
                    <div class="form-group">
                        <label for="nombre_sucursal">Nombre de la sucursal</label>
                        <input type="text" class="form-control" name="nombre_sucursal" required>
                    </div>
                    <div class="form-group">
                        <label for="ubicacion">Ubicacion</label>
                        <input type="text" class="form-control" name="ubicacion" required>
                    </div><!-- comment -->
                    <div class="form-group">
                        <label for="id_trabajador_encargado">Id del gerente</label>
                        <input type="number" class="form-control" name="id_trabajador_encargado" required>
                    </div>
                    <div class="form-group">
                        <label for="cantidad_empleados">Total de empleados</label>
                        <input type="number" class="form-control" name="cantidad_empleados" required>
                    </div>      
                </div>
                <div class="modal-footer">
                    <button class="btn-primary" type="submit">Guardar Sucursal</button>
                </div>

            </form> 

        </div>
    </div>
</div>
