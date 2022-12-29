<%-- 
    Document   : editarTrabajador
    Created on : 7 dic. 2022, 03:38:30
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
        <title>Editar Trabajador</title>
    </head>
    <body>

        <form action="${pageContext.request.contextPath}/trabajadorServlet?accion=modificar&id_trabajador=${trabajador.id_trabajador}"
              method="POST" class="was-validated">
            <section id="details"> 
                <div class="container">
                    <div class="row">
                        <div class="col">
                            <div class="card mt-4">
                                <div class="card-header">
                                    <h4>Editar Trabajador</h4>
                                </div>
                                <div class="card-body">

                                    <div class="form-group">
                                        <label for="nombre">Nombre</label>
                                        <input type="text" class="form-control" name="nombre" required value="${trabajador.nombre}">
                                    </div>
                                    <div class="form-group">
                                        <label for="id_sucursal">Id de la sucursal en que trabaja</label>
                                        <input type="number" class="form-control" name="id_sucursal" required value="${trabajador.id_sucursal}">
                                    </div><!-- comment -->
                                    <div class="form-group">
                                        <label for="telefono">Telefono</label>
                                        <input type="tel" class="form-control" name="telefono" required value="${trabajador.telefono}">
                                    </div>
                                    <div class="form-group">
                                        <label for="n_afiliacion_imss">Numero de afiliacion al IMMS</label>
                                        <input type="text" class="form-control" name="n_afiliacion_imss" required value="${trabajador.n_afiliacion_imss}">
                                    </div>
                                    <div class="form-group">
                                        <button class="btn-primary mt-4" type="submit">Modificar Trabajador</button>
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
