package pl.mberkan.examplewar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/node")
public class NodeServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String id = request.getParameter("id");
        DB db = new DB();
        Node node = db.getNode(id);
        String waterIN = db.getWaterIn(id);
        String waterOut = db.getWaterOut(id);
        Boolean water = db.getWater(id);
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        request.getRequestDispatcher("header.jsp").include(request, response);
        PrintWriter writer = response.getWriter();
        if(!node.getID().equals("Start")) {
            writer.println("Adres: " + node.getAdres() +
                    "<br/>ID: " + node.getID() +
                    "<br/>Woda wplywajaca: " + waterIN +
                    "<br/>Woda wyplywajaca: " + waterOut +
                    "<br/>Przewidywane zuzycie: " + node.getPredefinedWaterUsage()
            );
            if (water) {
                writer.println("<p class=\"warning\"> UWAGA!" +
                        "<br/>Woda wyplywajaca z poprzedniego wezla: " + db.getWaterOut(db.prevID(id)) +
                        "<br/>Woda wplywajaca do tego wezla: " + waterIN +
                        "</p>");
            }
            if (Double.parseDouble(waterIN) < node.getPredefinedWaterUsage()) {
                writer.println("<p class=\"alert\"> UWAGA!" +
                        "<br/>Mozliwy niedobor" +
                        "</p>");
            }
            writer.println(
                    "<form action=\"removeNode\" method=\"GET\">" +
                            "<input type=\"hidden\" name=\"id\" value=\"" + id + "\">" +
                            "       <input type=\"submit\" value=\"removeNode\" />" +
                            "</form>");
        }
        else{
            writer.println(
                    "Woda wplywajaca do sieci:" + db.getWaterOut(id)
            );
        }
        request.getRequestDispatcher("footer.jsp").include(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }



}
