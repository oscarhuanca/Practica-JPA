
package com.emergentes.controller;

import com.emergentes.bean.BeanEstudiante;
import com.emergentes.entidades.Estudiante;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "MainController", urlPatterns = {"/MainController"})
public class MainController extends HttpServlet {

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("ESTAMOS EN EL SERVLET");
        
      
        
        eliminar();
        mostrar();
    }
  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
}
    private  void nuevo(){
        BeanEstudiante dao = new BeanEstudiante();
        
        Estudiante e = new Estudiante();
        
        e.setNombre("Mary ");
        e.setApellidos("Aliaga");
        e.setEmail("maryaliaga@mail.com");
        e.setFechaNacimiento("23-09-1996");
                
        dao.insertar(e);
    

    }
    private void editar(){
        BeanEstudiante dao = new BeanEstudiante();
        
         Integer id = (7);
         
         Estudiante e = dao.buscar(id);
         e.setNombre("Joel");
         e.setEmail("joelflores@mail.com");
         
         dao.editar(e);
         
    }
    private void eliminar(){
        
        BeanEstudiante dao = new BeanEstudiante();
        
        Integer id = (7);
        
        dao.eliminar(id);
        
    }
    private void mostrar(){
         BeanEstudiante dao = new BeanEstudiante();
       
        dao.listarTodos();
        
        List<Estudiante> lista = dao.listarTodos();
        
        for(Estudiante item : lista){
            System.out.println(item.toString()); 
        }
    }
}
