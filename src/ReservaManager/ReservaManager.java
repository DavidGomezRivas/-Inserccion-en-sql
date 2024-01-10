package ReservaManager;

import java.sql.*;
import java.io.FileReader;
import java.io.File;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import java.io.IOException;
import org.xml.sax.SAXException;

public class ReservaManager {

    // Método para conectarse a la base de datos
    private Connection connect() {
        String url = "jdbc:mysql://localhost:3306/tu_base_de_datos";
        String user = "tu_usuario";
        String password = "tu_contraseña";

        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    // Método para añadir una reserva a la base de datos
    public void addReserva(Reserva reserva) {
        String sql = "INSERT INTO reservas(nombre, telefono, fecha_evento, tipo_evento, n_personas, tipo_cocina, n_jornadas, n_habitaciones, tipo_mesa, n_comensales) VALUES(?,?,?,?,?,?,?,?,?,?)";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, reserva.getNombre());
            // Setear el resto de los campos
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void processJSONFile(String filePath) {
        try {
            JSONObject obj = new JSONObject(new JSONTokener(new FileReader(filePath)));
            Reserva reserva = new Reserva(
                obj.getString("nombre"),
                obj.getString("telefono"),
                obj.getString("fecha_evento"),
                obj.getString("tipo_evento"),
                obj.getString("n_personas"),
                obj.getString("tipo_cocina"),
                obj.getString("n_jornadas"),
                obj.getString("n_habitaciones"),
                obj.getString("tipo_mesa"),
                obj.getString("n_comensales")
            );
            addReserva(reserva);
        } catch (JSONException | IOException e) {
            e.printStackTrace();
        }
    }

    // Método para procesar un archivo XML
    public void processXMLFile(String filePath) {
        try {
            File xmlFile = new File(filePath);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("reserva");
            for (int i = 0; i < nList.getLength(); i++) {
                Node nNode = nList.item(i);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    Reserva reserva = new Reserva(
                        eElement.getElementsByTagName("nombre").item(0).getTextContent(),
                        eElement.getElementsByTagName("telefono").item(0).getTextContent(),
                        eElement.getElementsByTagName("fecha_evento").item(0).getTextContent(),
                        eElement.getElementsByTagName("tipo_evento").item(0).getTextContent(),
                        eElement.getElementsByTagName("n_personas").item(0).getTextContent(),
                        eElement.getElementsByTagName("tipo_cocina").item(0).getTextContent(),
                        eElement.getElementsByTagName("n_jornadas").item(0).getTextContent(),
                        eElement.getElementsByTagName("n_habitaciones").item(0).getTextContent(),
                        eElement.getElementsByTagName("tipo_mesa").item(0).getTextContent(),
                        eElement.getElementsByTagName("n_comensales").item(0).getTextContent()
                    );
                    addReserva(reserva);
                }
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}
