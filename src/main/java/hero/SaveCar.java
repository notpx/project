package hero;
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



public class SaveCar extends HttpServlet
{
    private static final long serialVersionUID = 1L;
    protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType ("text/html");
        PrintWriter out = response.getWriter ();
        String slot = request.getParameter ("slot");
        String owner = request.getParameter ("owner");
        Car e = new Car ();
        e.setSlot (slot);
        e.setOwner(owner);

        int status = DBHandler.save (e);
        if (status > 0)
        {
         out.print ("<p>Record saved successfully!</p>");
         request.getRequestDispatcher ("index.html").include (request, response);
        }
        else
        {
         out.println ("You might have tried parking in a spot that is already occupied");
        }
        out.close ();
    }
}