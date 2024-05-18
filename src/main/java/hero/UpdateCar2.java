package hero;
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UpdateCar2 extends HttpServlet
{
    private static final long serialVersionUID = 1L;
    protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType ("text/html");
        PrintWriter out = response.getWriter ();
        String sid = request.getParameter ("id");
        int id = Integer.parseInt (sid);
        String name = request.getParameter ("name");
        String dept = request.getParameter ("dept");
        Car e = new Car();
        e.setId (id);
        e.setSlot (name);
        e.setOwner(dept);

        int status = DBHandler.update (e);
        if (status > 0)
        {
         out.println ("Record updated succesfully...");
         response.sendRedirect ("ViewCar");
        }
        else
        {
         out.println ("Sorry! unable to update record");
        }
        out.close ();
    }
}