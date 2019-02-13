package pl.mberkan.examplewar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/addNode")
public class AddNode extends HttpServlet {
    NetworkGraf networkGraf = new NetworkGraf();
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//        request.setAttribute("networkGraf", networkGraf); // add to request
//        request.getSession().setAttribute("networkGraf", networkGraf); // add to session
//        this.getServletConfig().getServletContext().setAttribute("sharedId", networkGraf); // add to application context
        request.getRequestDispatcher("/viewNodes").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher view = request.getRequestDispatcher("addBuildingForm.jsp");
        view.forward(request, response);
        if (request.getParameter("ID") != null) {
            DB db = new DB();
            String ID = request.getParameter("ID");
            double altitude = Double.parseDouble(request.getParameter("altitude"));
            double positionX = Double.parseDouble(request.getParameter("positionX"));
            double positionY = Double.parseDouble(request.getParameter("positionY"));
            double water = Double.parseDouble(request.getParameter("water"));
            String adres = request.getParameter("adres");
            String prevID = request.getParameter("prevID");
            Node newNode = new Node(ID, altitude, positionX, positionY, water, adres, prevID);
            db.addNode(newNode);
        }




    }



}
