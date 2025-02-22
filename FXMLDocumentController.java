
package sample;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Objects;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class FXMLDocumentController implements Initializable {
    
    private Label label;
    @FXML
    private TextField txtuser;
    @FXML
    private PasswordField txtpass;
    @FXML
    private Button btnlogin;
    @FXML
    private Hyperlink btnpass;
    @FXML
    private Hyperlink btnacc;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void btnClicked(ActionEvent event) throws ClassNotFoundException, SQLException, IOException
    {
        Stage stage = new Stage();
        
        String user = txtuser.getText();
        String pass = txtpass.getText();
        
       
        
       if (user.trim().isEmpty() || pass.trim().isEmpty()) {
    
           Alert alert = new Alert(Alert.AlertType.WARNING);
           alert.setTitle("Input Error");
           alert.setHeaderText(null);
           alert.setContentText("Please enter both username and password.");
           alert.show();
    return;
}
        LoginDao dao = new LoginDao();
        
         if (dao.isValidUser(user, pass)) {
             
                 navigateToMainPage();  
        } 
         else {
        
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Login Failed");
                alert.setHeaderText(null);
                alert.setContentText("Incorrect username or password.");
                alert.show();
    }


    }
     private void navigateToMainPage() throws IOException
    {
        FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("/sample/MainScreen/MainScreen.fxml"));
        Parent mainscreenRoot = fxmlloader.load();
        Stage stage = (Stage)btnlogin.getScene().getWindow();
        stage.setScene(new Scene(mainscreenRoot));
        stage.getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/sample/elearning_749080.png"))));
        stage.setTitle("MainScreen");
        stage.show();
    }

    @FXML
    private void forgetpassonClicked(ActionEvent event) throws IOException 
    {
        FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("/sample/ForgetPassword/ForgetPassword.fxml"));
        Parent adduserRoot = fxmlloader.load();
        Stage stage = (Stage)btnpass.getScene().getWindow();
        stage.setScene(new Scene(adduserRoot));
        stage.getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/sample/password_1990616.png"))));
        stage.setTitle("ForgetPassword");
        stage.show();
    }

    @FXML
    private void acconClicked(ActionEvent event) throws IOException 
    {
        FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("/sample/adduser/adduser.fxml"));
        Parent adduserRoot = fxmlloader.load();
        Stage stage = (Stage)btnacc.getScene().getWindow();
        stage.setScene(new Scene(adduserRoot));
        stage.getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/sample/social_16043427.png"))));
        stage.setTitle("AddUser");
        stage.show();
    }
    
}
