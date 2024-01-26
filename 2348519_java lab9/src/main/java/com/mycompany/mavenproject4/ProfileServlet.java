//import java.io.IOException;
//import java.io.InputStream;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//import java.util.Base64;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.MultipartConfig;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import javax.servlet.http.Part;
//
//@WebServlet("/UploadProfilePictureServlet")
//@MultipartConfig
//public class ProfileServlet extends HttpServlet {
//
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//
//        HttpSession session = request.getSession(false);
//
//        // Check if the user is logged in
//        if (session != null && session.getAttribute("username") != null) {
//            String username = (String) session.getAttribute("username");
//
//            // Get the file part from the request
//            Part filePart = request.getPart("file");
//
//            // Get input stream of the file
//            InputStream inputStream = filePart.getInputStream();
//
//            // Database connection parameters
//            String jdbcUrl = "jdbc:mysql://localhost:3306/login";
//            String dbUser = "root";
//            String dbPassword = "";
//
//            try {
//                // Load JDBC driver
//                Class.forName("com.mysql.cj.jdbc.Driver");
//
//                // Establish database connection
//                try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword)) {
//                    // Insert the image into the database
//                    String sql = "UPDATE log SET profile_picture = ? WHERE username = ?";
//                    try (PreparedStatement statement = connection.prepareStatement(sql)) {
//                        statement.setBlob(1, inputStream);
//                        statement.setString(2, username);
//                        statement.executeUpdate();
//                    }
//                }
//            } catch (ClassNotFoundException | SQLException e) {
//                e.printStackTrace(); // Handle exceptions appropriately
//            } finally {
//                // Close the input stream
//                inputStream.close();
//            }
//
//            // Redirect back to the Welcome page after successful upload
//            response.sendRedirect("Welcome.jsp");
//        } else {
//            // Redirect to the login page if the user is not logged in
//            response.sendRedirect("index.html"); // Change to the appropriate page
//        }
//    }
//}
//
