package hero;
import java.io.IOException;  
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;  


public class UpdateCar extends HttpServlet { 
    private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        out.println("<h1>Update Employee</h1>");  
        String sid=request.getParameter("id");  
        int id=Integer.parseInt(sid);  
        
        Car e= DBHandler.getEmployeeById(id);  
          
        out.print("<form action='UpdateCar2' method='post'>");  
        out.print("<table>");  
        out.print("<tr><td></td><td><input type='hidden' name='id' value='"+e.getId()+"'/></td></tr>");  
        out.print("<tr><td>Owner</td><td><input type='text' name='name' value='"+e.getSlot()+"'/></td></tr>");  
        out.print("<tr><td>Slot</td><td><input type='text' name='dept' value='"+e.getOwner()+"'/> </td></tr>");  
        
        out.print("<tr><td colspan='2'><input type='submit' value='Update '/></td></tr>");  
        out.print("</table>");  
        out.print("</form>");  
          
        out.close();  
    }  
}  