
package library;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import mini_project.Database1;
import mini_project.book;


public class Book extends Application {

    @Override
    public void start(Stage primaryStage) {
        Label lBookName = new Label("Book Name:");
        Label lIsbnNo = new Label("ISBN No.:");
        Label lPublisherName = new Label("Publisher Name:");
        Label lAuthorName = new Label("Author Name:");
        TextField tfBookName = new TextField();
        TextField tfIsbnNo = new TextField();
        TextField tfPublisherName = new TextField();
        TextField tfAuthorName = new TextField();
        
        Button button = new Button("Submit");
        GridPane gp = new GridPane();
        gp.setHgap(5);
        gp.setVgap(8);
        
       button.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                String Name = tfBookName.getText();
                String isbn = tfIsbnNo.getText();
                String publisherName = tfPublisherName.getText();
                String authorName = tfAuthorName.getText();
                
                String uri = "jdbc:mysql://localhost:3306/miniproject";
                Database1 db = new Database1(uri,"root","root");
                try {     
                    Connection con = db.openConnection();
                    book.insertBook(Name,isbn,publisherName,authorName, con);
                } catch (Exception ex) {
                    Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
                }               
    }          
        });
        gp.add(lBookName,0,0);
        gp.add(tfBookName,1, 0);
        gp.add(lIsbnNo,0,1);
        gp.add(tfIsbnNo,1, 1);
        gp.add(lPublisherName,0,2);
        gp.add(tfPublisherName,1, 2);
        gp.add(lAuthorName,0,3);
        gp.add(tfAuthorName,1, 3);
        gp.add(button,1,4);
        
        Scene scene = new Scene(gp);
        primaryStage.setTitle("Book");
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
