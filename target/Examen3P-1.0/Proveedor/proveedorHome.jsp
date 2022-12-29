<%-- 
    Document   : proveedorHome
    Created on : 1 dic. 2022, 20:38:24
    Author     : luisz
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Proveedor</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css" integrity="sha512-MV7K8+y+gLIBoVD59lQIYicR65iaqukzvf/nwasF0nqhPay5w/9lJmVM2hMDcnK1OnMGCdVK+iQrJ7lzPJQd1w==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
        <!--        <link href="./recursos/styles.css" rel="stylesheet" type="text/css"/>-->
        <link href="../recursos/pruebaJava.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        
        <jsp:include page="../arbolPrincipal/cabecera.jsp" />

        <div class="container Menu">
            <h1 class="mb-5 mt-5 transparente">Bienvenido</h1>
            <div class="row">
                <div class="col">

                    <div class="card">
                        <div class="card-body ">

                            <div class="row">
                                <div class="col-9">
                                    <h2>Bienvenido a la pagina de proveedor</h2>
                                </div>
                                <div class="col-3">
                                    <jsp:include page="agregarProveedor.jsp" />
                                    <a href="#" class="btn btn-primary btn-block" 
                                       data-toggle="modal" data-target="#agregarProveedorModal">
                                        <i class="fas fa-plus"></i> Agregar Proveedor
                                    </a>
                                </div>
                            </div>

                            <div class="row">
                                <div class="col-12 text-center">

                                    <div class="card m-1">
                                        <div class="card-body">
                                            
                                            <table class="table">
                                                <tr>
                                                    <th>#</th>
                                                    <th>Nombre</th>
                                                    <th>Telefono</th>
                                                    <th>Firma farmaceutica</th>
                                                    <th>Correo</th>
                                                </tr>

                                                <c:forEach var="proveedor" items="${proveedores}">
                                                    <tr> 
                                                        <td>${proveedor.id_proveedor}</td>
                                                        <td>${proveedor.nombre}</td>
                                                        <td>${proveedor.telefono}</td>
                                                        <td>${proveedor.firma_farmaceutica}</td>
                                                        <td>${proveedor.correo}</td>
                                                        
                                                        <td>
                                                            <a href="${pageContext.request.contextPath}/proveedorServlet?accion=editar&id_proveedor=${proveedor.id_proveedor}">
                                                                <i class="fa-regular fa-pen-to-square"></i>
                                                            </a>
                                                        </td>
                                                        <td>
                                                            <a href="${pageContext.request.contextPath}/proveedorServlet?accion=eliminar&id_proveedor=${proveedor.id_proveedor}">
                                                                <i class="fa-solid fa-trash"></i>
                                                            </a>
                                                        </td>
                                                    </tr>             
                                                </c:forEach>
                                            </table>
                                        </div>    
                                    </div>
                                    
                                </div>                                
                            </div>
                        </div>
                    </div>

                </div>
            </div>

        </div>






        <jsp:include page="../arbolPrincipal/footer.jsp" />



        <!-- JQuery Library -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

        <!-- Popper JS -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>

        <!-- JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <!-- JavaScript Bundle with Popper -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" 
                integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
        crossorigin="anonymous"></script>
        
    </body>
</html>
