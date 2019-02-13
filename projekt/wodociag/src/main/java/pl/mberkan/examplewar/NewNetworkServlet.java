package pl.mberkan.examplewar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/newNetwork")
public class NewNetworkServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        request.getRequestDispatcher("header.jsp").include(request, response);
        request.getRequestDispatcher("addNetworkForm.jsp").include(request, response);
        request.getRequestDispatcher("footer.jsp").include(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher view = request.getRequestDispatcher("addBuildingForm.jsp");
        view.forward(request, response);

        DB db = new DB();
        db.delete();
        String ID = "Start";
        double altitude = Double.parseDouble(request.getParameter("altitude"));
        double positionX = Double.parseDouble(request.getParameter("positionX"));
        double positionY = Double.parseDouble(request.getParameter("positionY"));
        double water = 0;
        String adres = request.getParameter("adres");
        String prevID = "0";
        Node newNode = new Node(ID, altitude, positionX, positionY, water, adres, prevID);
        db.addNode(newNode);


    }
}
