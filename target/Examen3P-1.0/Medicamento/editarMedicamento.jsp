<%-- 
    Document   : editarMedicamento
    Created on : 7 dic. 2022, 00:08:23
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
        <title>Editar Medicamento</title>
    </head>
    <body>
        <form action="${pageContext.request.contextPath}/medicamentoServlet?accion=modificar&id_medicamento=${medicamento.id_medicamento}"
              method="POST" class="was-validated">
            <section id="details"> 
                <div class="container">
                    <div class="row">
                        <div class="col">
                            <div class="card mt-4">
                                <div class="card-header">
                                    <h4>Editar Medicamento</h4>
                                </div>
                                <div class="card-body">

                                    <div class="form-group">
                                        <label for="nombre_medicamento">Nombre</label>
                                        <input type="text" class="form-control" name="nombre_medicamento" required value="${medicamento.nombre_medicamento}">
                                    </div>
                                    <div class="form-group">
                                        <label for="laboratorio">Laboratorio</label>
                                        <input type="text" class="form-control" name="laboratorio" required value="${medicamento.laboratorio}">
                                    </div>
                                    <div class="form-group">
                                        <label for="existencias">existencias</label>
                                        <input type="number" class="form-control" name="existencias" required value="${medicamento.existencias}">
                                    </div>
                                    <div class="form-group">
                                        <label for="tipo_medicamento">Tipo de medicamento</label>
                                        <input type="text" class="form-control" name="tipo_medicamento" required value="${medicamento.tipo_medicamento}">
                                    </div>
                                    <div class="form-group">
                                        <label for="caducidad">caducidad</label>
                                        <input type="text" class="form-control" name="caducidad" required value="${medicamento.caducidad}">
                                    </div>
                                    <div class="form-group">
                                        <label for="requiere_receta">Requiere receta</label>
                                        <input type="text" class="form-control" name="requiere_receta" required value="${medicamento.requiere_receta}">
                                    </div>
                                    <div class="form-group">
                                        <button class="btn-primary mt-4" type="submit">Modificar Cliente</button>
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
