<%-- 
    Document   : editarProveedor
    Created on : 7 dic. 2022, 01:29:06
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
        <title>Editar Proveedor</title>
    </head>
    <body>

        <form action="${pageContext.request.contextPath}/proveedorServlet?accion=modificar&id_proveedor=${proveedor.id_proveedor}"
              method="POST" class="was-validated">
            <section id="details"> 
                <div class="container">
                    <div class="row">
                        <div class="col">
                            <div class="card mt-4">
                                <div class="card-header">
                                    <h4>Editar Proveedor</h4>
                                </div>
                                <div class="card-body">

                                    <div class="form-group">
                                        <label for="nombre">Nombre</label>
                                        <input type="text" class="form-control" name="nombre" required value="${proveedor.nombre}">
                                    </div>
                                    <div class="form-group">
                                        <label for="telefono">Telefono</label>
                                        <input type="tel" class="form-control" name="telefono" required value="${proveedor.telefono}">
                                    </div> 
                                    <div class="form-group">
                                        <label for="firma_farmaceutica">Firma farmaceutica</label>
                                        <input type="text" class="form-control" name="firma_farmaceutica" required value="${proveedor.firma_farmaceutica}">
                                    </div><!-- comment -->                   
                                    <div class="form-group">
                                        <label for="correo">Correo</label>
                                        <input type="text" class="form-control" name="correo" required value="${proveedor.correo}">
                                    </div> 
                                    <div class="form-group">
                                        <button class="btn-primary mt-4" type="submit">Modificar Proveedor</button>
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
