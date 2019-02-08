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
        int index = 0;
        networkGraf = (NetworkGraf) request.getSession().getAttribute("networkGraf");
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter writer = response.getWriter();
        writer.println("<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "    <meta name=\"viewport\" content=\"initial-scale=1.0, user-scalable=no\">\n" +
                "    <meta charset=\"utf-8\">\n" +
                "    <title>Simple Markers</title>\n" +
                "    <style>\n" +
                "        /* Always set the map height explicitly to define the size of the div\n" +
                "         * element that contains the map. */\n" +
                "        #map {\n" +
                "            height: 100%;\n" +
                "        }\n" +
                "        /* Optional: Makes the sample page fill the window. */\n" +
                "        html, body {\n" +
                "            height: 100%;\n" +
                "            margin: 0;\n" +
                "            padding: 0;\n" +
                "        }\n" +
                "    </style>\n" +
                "</head>\n" +
                "<body>\n" +
                "<div id=\"map\"></div>\n" +
                "<script>\n" +
                        "    // Initialize and add the map\n" +
                        "    function initMap() {        \n"+
                        "        var position"+index+" = {lat: "+networkGraf.nodes.get(0).getPositionX()+", lng: "+networkGraf.nodes.get(0).getPositionY()+"};\n" +
                        "        var map = new google.maps.Map(\n" +
                        "            document.getElementById('map'), {zoom: 4, center: position"+index+"});\n"+
                        "        var marker = new google.maps.Marker({position: position" + index + ", map: map});\n"  );
                        for (Node n : networkGraf.getNodes()) {
                            index++;
                            writer.println(
                                    "        var position"+index+" = {lat: "+n.getPositionX()+", lng: "+n.getPositionY()+"};\n" +
                                    "        var marker = new google.maps.Marker({position: position" + index + ", map: map});\n"
                            );
                        }
        writer.println(
                        "    }\n" +
                "</script>"+
                "<script async defer\n" +
                "        src=\"https://maps.googleapis.com/maps/api/js?key=AIzaSyBHrs8loLJHTSomw3Cj3XecWBeAB5qvdpU&callback=initMap\">\n" +
                "</script>\n" +
                "</body>\n" +
                "</html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}
