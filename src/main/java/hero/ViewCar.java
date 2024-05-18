package hero;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



public class ViewCar extends HttpServlet
{
    private static final long serialVersionUID = 1L;
    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType ("text/html");
        PrintWriter out = response.getWriter ();
        out.println ("<a href='index.html'>Add Employee</a>");
        out.println ("<h1>Employees List</h1>");
        List <Car> list = DBHandler.getAllEmployees();

        out.print ("<table border='1' width='100%' ");
        out.print("<tr><th>Id</th><th>Slot</th><th>Owner</th><th>Update</th><th>Delete</th></tr>");
        
        for (Car e:list)
        {
         out.print ("<tr><td>" + e.getId () + "</td><td>" + e.getSlot () +
      "</td><td>" + e.getOwner() +
      "</td><td><a href='UpdateCar?id=" + e.getId () +
      "'>update</a></td>  <td><a href='DeleteCar?id=" +
      e.getId () + "'>delete</a></td></tr>");
        }
        out.print ("</table>");
        out.close ();
    }
}