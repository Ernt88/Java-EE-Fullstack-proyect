package test;
import datos.ClientesDAO;
import domain.Clientes;

public class medica {
    public static void main(String[] args){
        ClientesDAO clientedao = new ClientesDAO();
        
        Clientes clienteNu = new Clientes(2,"PEDRO","2/2/1", "678248562");
        clientedao.insertar(clienteNu); 
        System.out.println("-------------------------------------------------");
        System.out.println("Listado de clientes " + clientedao.seleccionar());
        System.out.println("-------------------------------------------------");
    }
}
    
