package com.mycompany.dbooks;

import java.io.IOException;
import java.net.URL;
import javafx.fxml.FXML;
import static javafx.print.Paper.C;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;


public class PrimaryController {
    
//    public void start(Stage stage) {
//         // load the image
//         Image image = new Image("C:/Users/9977q/Downloads/booklogo.png");
// 
//         // simple displays ImageView the image as is
//         ImageView booklogo = new ImageView();
//         booklogo.setImage(image);
//    }
    
    @FXML
    private void switchToSecondary() throws IOException {
        Node n1 = App.getRoot().lookup("#usernameTextField");
        TextField usernameField = (TextField) n1;
        
        Node n2 = App.getRoot().lookup("#passwordTextField");
        TextField passwordField = (TextField) n2;
        
        System.out.println("Username: " + usernameField.getText());
        System.out.println("Password: " + passwordField.getText());

        String username = usernameField.getText();
        String password = passwordField.getText();
        
        Label access = (Label) App.getRoot().lookup("#access");


         if ((usernameField.getText().equals("")) 
                 && (passwordField.getText().equals(""))) {
             
                access.setText("");
                
                App.setRoot("secondary");
            } else {
                access.setText("ACCESS DENIED");
                System.out.println("ACCESS DENIED");
            }
        }
    } 
