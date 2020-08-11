//import from java fx
import java.sql.*;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.Window;

//Implimentation of our hello interface 


public class Customers extends Application implements Hello{
   
    Connection con = null;
    PreparedStatement stm = null;
    ResultSet rs = null;
   
    @Override
    public void start(Stage stage) {
         Text textA=new Text("Register Here!");
         Text textB = new Text("Name");
         Text textC = new Text("Email");
         Text textD = new Text("Date of Birth");
         Text textE = new Text("Mobile No");
         Text textF = new Text("Password");
         
         Text text1=new Text("Welcome to our Registration Form!");
         
         DatePicker d=new DatePicker();
         GridPane gridPaneA = new GridPane();
         GridPane gridPane1 = new GridPane();
         Scene sceneA = new Scene(gridPaneA);
         Scene scene1 = new Scene(gridPane1);

       
         ComboBox comboBoxA=new ComboBox();
         ComboBox comboBoxB=new ComboBox();
         
        TextField textfieldA = new TextField();
        TextField textfieldB = new TextField();
        TextField textfieldC = new TextField();
        PasswordField passwordField = new PasswordField();
       
        Button buttonA = new Button("Register");
        Button button1 = new Button("Back");
        buttonA.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               
       //start insertion of data to Database
                con = Database.Database();
               
                String qry = "INSERT INTO users (user_name, user_email, user_dob, user_mobile, user_pass) VALUES (?, ?, ?, ?, ?)";
                try {
                    stm = con.prepareStatement(qry);
                    stm.setString(1, textfieldA.getText()); //bind username to prepared statement
                    stm.setString(2, textfieldB.getText()); //bind email to prepared statement
                    stm.setString(3, d.getValue().toString()); //bind dob to prepared statement
                    stm.setString(4, textfieldC.getText()); //bind mobile to prepared statement
                    stm.setString(5, passwordField.getText()); //bind password to prepared statement
                    stm.executeUpdate(); //execute statement
                   
                    System.out.println("User registered");
                    textfieldA.setText("");
                    textfieldB.setText("");
                    d.setValue(null);
                    textfieldC.setText("");
                    passwordField.setText("");
                           
           
                } catch(Exception ex) {
                    ex.printStackTrace();
               
                }

                stage.setScene(scene1);
            }
        });
        button1.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                stage.setScene(sceneA);
            }
        });
 
        gridPaneA.setMinSize(600,400);
        gridPaneA.setPadding(new Insets(15,15,15,15));
        gridPaneA.setVgap(10);
        gridPaneA.setHgap(10);
       
        gridPaneA.setAlignment(Pos.CENTER);
        gridPaneA.add(textA,1,0);
        gridPaneA.add(textB,0,2);
        gridPaneA.add(textfieldA,1,2);
        gridPaneA.add(textC,0,4);//column row
        gridPaneA.add(textfieldB,1,4);
        gridPaneA.add(textD,0,5);//column row
        gridPaneA.add(d,1,5);
        gridPaneA.add(textE,0,6);//column row
        gridPaneA.add(textfieldC,1,6);
        gridPaneA.add(textF,0,7);//column row
        gridPaneA.add(passwordField,1,7);
        gridPaneA.add(buttonA,1,8);
         
        gridPane1.setMinSize(600,400);
        gridPane1.setPadding(new Insets(15,15,15,15));
        gridPane1.setVgap(10);
        gridPane1.setHgap(10);
       
        gridPane1.setAlignment(Pos.CENTER);
        gridPane1.add(text1,1,0);
        gridPane1.add(button1,1,2);
           

        buttonA.setStyle("-fx-background-color: #6F4506, linear-gradient(#7ebcea, #2f4b8f), linear-gradient(#426ab7, #263e75), linear-gradient(#395cab, #223768); -fx-background-insets: 0,1,2,3; -fx-background-radius: 3,2,2,2; -fx-padding: 7 15 7 15; -fx-text-fill: white; -fx-font-size: 12px;");
        button1.setStyle("-fx-background-color: #6F4506, linear-gradient(#7ebcea, #2f4b8f), linear-gradient(#426ab7, #263e75), linear-gradient(#395cab, #223768); -fx-background-insets: 0,1,2,3; -fx-background-radius: 3,2,2,2; -fx-padding: 7 15 7 15; -fx-text-fill: white; -fx-font-size: 12px;");
     
        textA.setStyle(" -fx-font: normal bold 20px 'serif'");
        textB.setStyle(" -fx-font: normal bold 20px 'serif'");
        textC.setStyle(" -fx-font: normal bold 20px 'serif'");
        textD.setStyle(" -fx-font: normal bold 20px 'serif'");
        textE.setStyle(" -fx-font: normal bold 20px 'serif'");
        textF.setStyle(" -fx-font: normal bold 20px 'serif'");
      gridPaneA.setStyle("-fx-border-color: #000000;\n" +
                "    -fx-border-width: 2px;\n" +
                "    -fx-border-radius: 5px;\n" +
                "    -fx-border-insets: 5px;\n" +
                "    -fx-padding: 10px;\n" +
                "    -fx-spacing: 5px;\n" +
                "    -fx-background-image: url(\"780387.jpg\");\n"+
                "    -fx-background-insets: 5px;");  
     
      text1.setStyle(" -fx-font: normal bold 20px 'serif'");
      gridPane1.setStyle("-fx-border-color: #000000;\n" +
                "    -fx-border-width: 2px;\n" +
                "    -fx-border-radius: 5px;\n" +
                "    -fx-border-insets: 5px;\n" +
                "    -fx-padding: 10px;\n" +
                "    -fx-spacing: 5px;\n" +
                "    -fx-background-image: url(\"d.jpg\");\n"+
                "    -fx-background-insets: 5px;");  
       
       
        stage.setTitle("DistributedAPP");
       
        stage.setScene(sceneA);
       
        stage.show();
       
    }

    /**
     * @param args the command line arguments
     */
    public void animation() {
        launch();
    }
}