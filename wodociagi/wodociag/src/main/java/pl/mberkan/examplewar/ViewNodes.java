package pl.mberkan.examplewar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/viewNodes")
public class ViewNodes extends HttpServlet {
    NetworkGraf networkGraf;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        networkGraf = (NetworkGraf) request.getSession().getAttribute("networkGraf");
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter writer = response.getWriter();
        for (Node n : networkGraf.getNodes()) {
            writer.println(n.getID());
            writer.println(n.getAltitude());
            writer.println(n.getPositionX());
            writer.println(n.getPositionY());
            writer.println(n.getPredefinedWaterUsage());
            writer.println(n.getAdres());

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}
