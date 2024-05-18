package hero;
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DeleteCar extends HttpServlet
{
    private static final long serialVersionUID = 1L;
    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType ("text/html");
        PrintWriter out = response.getWriter ();
        String sid = request.getParameter ("id");
        int id = Integer.parseInt (sid);
        DBHandler.delete (id);

        int status = DBHandler.delete (id);
        if (status > 0)
        {
         out.print ("<p>Record deleted successfully!</p>");
         response.sendRedirect ("ViewCar");
        }
        else
        {
         out.println ("Sorry! unable to delete record");
        }
        response.sendRedirect ("ViewCar");
    }
}