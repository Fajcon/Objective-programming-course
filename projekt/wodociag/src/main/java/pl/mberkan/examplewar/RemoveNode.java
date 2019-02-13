package pl.mberkan.examplewar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/removeNode")
public class RemoveNode extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    DB db = new DB();
    String id = request.getParameter("id");
    db.removeNode(id);
    request.getRequestDispatcher("/viewNodes").forward(request, response);
    }
}
