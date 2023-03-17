package com.example.examen_practic;

import com.example.examen_practic.domain.Utilizator;
import com.example.examen_practic.repository.FlightRepo;
import com.example.examen_practic.repository.TicketRepo;
import com.example.examen_practic.repository.UserRepo;
import com.example.examen_practic.service.Service;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LoginController {
    UserRepo repo1 = new UserRepo();
    FlightRepo repo2 = new FlightRepo();

    TicketRepo repo3 = new TicketRepo();


    Service service = Service.getInstance(repo1, repo2, repo3);

    @FXML
    private TextField tf;


    public void logheaza(ActionEvent actionEvent) throws IOException {
        Stage stage=new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("user-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Zboruri disponibile!");
        stage.setScene(scene);
        stage.show();

        ZboruriController controller = fxmlLoader.getController();
        List<Utilizator> useri = repo1.findAll();
        Utilizator conectat = new Utilizator(1, "a", "b");
        for(Utilizator user: useri) {
            if(user.getUsername() == tf.getText()){
                conectat = user;
                break;
            }
        }
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Conectare");
        alert.setHeaderText("S-a conectat utilizatorul:");
        alert.setContentText(tf.getText());
        alert.show();
    }
}
