<%-- 
    Document   : editarSucursal
    Created on : 7 dic. 2022, 02:37:31
    Author     : luisz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" 
              integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" 
              crossorigin="anonymous"> 

        <script src="https://kit.fontawesome.com/3556f97ea7.js" crossorigin="anonymous"></script>
        <title>Editar Sucursal</title>
    </head>
    <body>

        <form action="${pageContext.request.contextPath}/sucursalServlet?accion=modificar&id_sucursal=${sucursal.id_sucursal}"
              method="POST" class="was-validated">
            <section id="details"> 
                <div class="container">
                    <div class="row">
                        <div class="col">
                            <div class="card mt-4">
                                <div class="card-header">
                                    <h4>Editar Sucursal</h4>
                                </div>
                                <div class="card-body">

                                    <div class="form-group">
                                        <label for="nombre_sucursal">Nombre de la sucursal</label>
                                        <input type="text" class="form-control" name="nombre_sucursal" required value="${sucursal.nombre_sucursal}">
                                    </div>
                                    <div class="form-group">
                                        <label for="ubicacion">Ubicacion</label>
                                        <input type="text" class="form-control" name="ubicacion" required value="${sucursal.ubicacion}">
                                    </div><!-- comment -->
                                    <div class="form-group">
                                        <label for="id_trabajador_encargado">Id del gerente</label>
                                        <input type="number" class="form-control" name="id_trabajador_encargado" required value="${sucursal.id_trabajador_encargado}">
                                    </div>
                                    <div class="form-group">
                                        <label for="cantidad_empleados">Total de empleados</label>
                                        <input type="number" class="form-control" name="cantidad_empleados" required value="${sucursal.cantidad_empleados}">
                                    </div>      
                                </div>
                                <div class="form-group">
                                    <button class="btn-primary mt-4" type="submit">Guardar Sucursal</button>
                                </div>

                            </div>
                        </div>
                    </div>
                </div>
                </div>
            </section>
        </form>

    </body>
</html>
