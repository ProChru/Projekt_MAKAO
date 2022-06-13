package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;
import java.util.Objects;

public class DBUtils {

    public static void changeScene(ActionEvent event, String fxnlFile, String title, String username) {

        Parent root = null;

        if (username != null) {
            try{
                FXMLLoader loader = new FXMLLoader(DBUtils.class.getResource(fxnlFile));
                root =loader.load();
                LoggedInController loggedInController = loader.getController();
                loggedInController.setUserInformation(username);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            try{
                root = FXMLLoader.load(Objects.requireNonNull(DBUtils.class.getResource(fxnlFile)));
            } catch (IOException e) {
                System.out.println("wywala  blad");
                e.printStackTrace();
            }
        }
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle(title);
        stage.setScene(new Scene(root));
        stage.show();
    }


    public static void signUpUser(ActionEvent event, String username, String password){
        Connection connection = null;
        PreparedStatement psInsert = null;
        PreparedStatement psCheckUserExists = null;
        ResultSet resultSet = null;

        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/makaogra","root","admin");
            psCheckUserExists = connection.prepareStatement("SELECT * FROM users WHERE username = ?");
            psCheckUserExists.setString(1,username);
            resultSet = psCheckUserExists.executeQuery();

            if(resultSet.isBeforeFirst()){
                System.out.println("Użytkownik już istnieje!");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Nie możesz użyć tej nazwy użytkownika.");
                alert.show();
            }else{
                psInsert = connection.prepareStatement("INSERT INTO users (username, password) VALUES (?,?)");
                psInsert.setString(1, username);
                psInsert.setString(2, password);
                psInsert.executeUpdate();

                changeScene(event,"logged-in.fxml", "Witaj", username);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (psCheckUserExists != null) {
                try {
                    psCheckUserExists.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (psInsert != null) {
                try {
                    psInsert.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static void logInUser(ActionEvent event, String username, String password) {
        Connection connection = null;
        PreparedStatement prepareStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/makaogra", "root", "admin");
            prepareStatement = connection.prepareStatement("SELECT password FROM users WHERE username = ?");
            prepareStatement.setString(1, username);
            resultSet = prepareStatement.executeQuery();

            if (!resultSet.isBeforeFirst()) {
                System.out.println("Nie znaleziono użytkownika w bazie danych");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Dane są niekompletne!");
                alert.show();
            } else {
                while (resultSet.next()) {
                    String retrievedPassword = resultSet.getString("password");

                    if(retrievedPassword.equals(password)){
                       changeScene(event,"logged-in.fxml","Witaj!",username);
                    }else{
                        System.out.println("Hasło jest złe!");
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setContentText("Złe hasło!");
                        alert.show();
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (prepareStatement != null) {
                try {
                    prepareStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
