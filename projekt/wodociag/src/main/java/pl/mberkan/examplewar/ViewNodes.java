package pl.mberkan.examplewar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/viewNodes")
public class ViewNodes extends HttpServlet {
    NetworkGraf networkGraf;
    Node prevNode;
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int index = 0;
        int pathIndex = 0;
        String markerColor;
        DB db = new DB();
        networkGraf = db.getNetwork();
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter writer = response.getWriter();
        writer.println("<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "   <LINK rel=\"StyleSheet\" href=\"/Gradle___wodociag___wodociag_1_0_SNAPSHOT_war__exploded_/CSS/style.css\" type=\"text/css\">\n"+
                "    <meta name=\"viewport\" content=\"initial-scale=1.0, user-scalable=no\">\n" +
                "    <meta charset=\"utf-8\">\n" +
                "    <title>Simple Markers</title>\n" +
                "    <style>\n" +
                "       #all{\n"+
                "            height: 100%;\n" +
                "            margin: auto;\n" +
                "            background-color: burlywood;\n"+
                "            width: 90%;\n"+
                "            padding: 0px 10px;"+
                "    </style>\n" +
                "</head>\n" +
                "<body>\n" +
                "<div id=\"all\">"+
                    "<div id=\"menu\">"+
                    "<form class=\"menu\" action=\"addNode\" method=\"POST\">\n" +
                    "        <input type=\"submit\" value=\"Dodaj wezel\" />\n" +
                    "</form>\n"+
                    "</div>"+
                    "<div id=\"content\">"+
                        "<div id=\"map\"></div>\n" +
                        "<script>\n" +
                                "    // Initialize and add the map\n" +
                                "    function initMap() {        \n");
                if(!networkGraf.nodes.isEmpty()){
                                writer.println(
                                "        var position"+index+" = {lat: "+networkGraf.nodes.get(0).getPositionX()+", lng: "+networkGraf.nodes.get(0).getPositionY()+"};\n" +
                                "        var map = new google.maps.Map(\n" +
                                "            document.getElementById('map'), {zoom: 10, center: position"+index+"});\n" );
                                for (Node n : networkGraf.getNodes()) {
                                    index++;
                                    if(db.getWater(n.getID())){ markerColor = "graphics/redMarker.png";}
                                    else if(Double.parseDouble(db.getWaterIn(n.getID()))<n.getPredefinedWaterUsage()){ markerColor = "graphics/orangeMarker.png";}
                                    else {markerColor = "graphics/blueMarker.png";}
                                    writer.println(
                                            "        var position"+index+" = {lat: "+n.getPositionX()+", lng: "+n.getPositionY()+"};\n" +
                                            "        var marker = new google.maps.Marker({position: position" + index + ", map: map, icon: '"+markerColor+"'});\n" +
                                            "        marker.addListener('click', function () {\n" +
                                            "               window.location.replace(\"node?id="+n.getID()+"\");\n" +
                                            "        });"+
                                            "       var infowindow"+index+" =  new google.maps.InfoWindow({\n" +
                                            "                        content: \""+n.getID()+" "+n.getAdres()+"\",\n" +
                                            "                        map: map,\n" +
                                            "                    });"+
                                            "        marker.addListener('mouseover', function() {\n" +
                                            "                        infowindow"+index+".open(map, this);\n" +
                                            "        });"+
                                            "        marker.addListener('mouseout', function() {\n" +
                                            "                        infowindow"+index+".close();\n" +
                                            "        });"
                                    );
                                }ArrayList<Node> nodes = networkGraf.getNodes();
                                 for (int i = 0; i < nodes.size(); i++) {
                                     if(!nodes.get(i).getPrevID().equals("0")) {
                                         prevNode = db.getPrevNode(nodes.get(i).getID());
                                         writer.println(
                                                 "            var linesPath" + pathIndex + " = [\n" +
                                                         "                 {lat: " + nodes.get(i).getPositionX() + ", lng: " + nodes.get(i).getPositionY() + "},\n" +
                                                         "                 {lat: " + prevNode.getPositionX() + ", lng: " + prevNode.getPositionY() + "},\n" +
                                                         "           ];\n" +
                                                         "        var lines" + pathIndex + " = new google.maps.Polyline({\n" +
                                                         "          path: linesPath" + pathIndex + ",\n" +
                                                         "          geodesic: true,\n" +
                                                         "          strokeColor: '#0000FF',\n" +
                                                         "          strokeOpacity: 1.0,\n" +
                                                         "          strokeWeight: 2\n" +
                                                         "        });\n" +
                                                         "        lines" + pathIndex + ".setMap(map);");
                                         pathIndex++;
                                     }
                                }
                }
                writer.println(

                        "    }\n" +
                        "</script>"+
                        "<script async defer\n" +
                        "        src=\"https://maps.googleapis.com/maps/api/js?key=AIzaSyBRkSbVMlxhxONz9HpxnsUm5_3qdTs8Pi4&callback=initMap\">\n" +
                        "</script>\n" +
                    "</div>"+
                "</div>"+
                "</body>\n" +
                "</html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}
