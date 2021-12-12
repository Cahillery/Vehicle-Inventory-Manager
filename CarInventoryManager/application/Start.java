package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.regex.Pattern;

import com.opencsv.exceptions.CsvException;
import java.util.regex.Matcher; 
import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Start extends Application  {
    private StackPane root = new StackPane();
    private Stage stage;
    int x = 1;
    
    @Override
    public void init() throws FileNotFoundException {
		FileInputStream inputstream = new FileInputStream("application\\Car logo.png");
		Image image = new Image(inputstream); 
		ImageView imageView = new ImageView(image);
		imageView.setFitHeight(120);
		imageView.setFitWidth(220);
        VBox vBox = new VBox();
        vBox.setSpacing(8);
        vBox.setPadding(new Insets(10,10,10,10));
        vBox.setAlignment(Pos.CENTER);
        Label label = new Label("Vehicle Inventory Manager");
        label.setFont(Font.font("Cambria",32));
        Label username = new Label("Your Username");
        TextField usertext = new TextField();
        usertext.setMaxWidth(250);
        Label password = new Label("Your Password");
        PasswordField passf = new PasswordField(); 
        passf.setMaxWidth(250);
        Button login = new Button("Login");
        Label checkPassword = new Label(null);
        vBox.getChildren().addAll(label,imageView, username, usertext, password, passf,login, checkPassword);
        root.getChildren().addAll(vBox);

        login.setOnAction(actionEvent-> {
            if(stage!=null){
            	String userName = usertext.getText();
            	String Password = passf.getText();
            	if(userCheck.usercheck(userName, Password) == true){
            		Stage stage = (Stage) login.getScene().getWindow();
            		stage.close();
            		show(stage);
            		
            		
            	}
            	if(userCheck.usercheck(userName, Password) == false) {
            		checkPassword.setText("Incorrect Username / Password");
            		checkPassword.setTextFill(Color.RED);
            		usertext.setText("");
            		passf.setText("");
            	}
                stage.requestFocus();
                return;
            }
            
        
            stage = new Stage();
            StackPane stackPane = new StackPane();
            stage.setScene(new Scene(stackPane, 200,200));

    	});
    }

    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(root,500,500);
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setTitle("Login");
        primaryStage.setAlwaysOnTop(true);
    }


    public static void main(String[] args) {
        launch(args);
    }
    public void show(Stage stage) {
    	String[][] list = readCar.readlist();
    	int length = lengthOf.getLength(); 
    	System.out.println(length);
    	TableView<Car> table = new TableView<Car>();
    	final ObservableList<Car> data = FXCollections.observableArrayList();
    			while (x < length) {
    			data.add(new Car(list[x][0], list[x][1], list[x][2], list[x][3], list[x][4], list[x][5]));
    			x++
    			;}

		FileInputStream inputstream = null;
		try {
			inputstream = new FileInputStream("application\\Car logo.png");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Image image = new Image(inputstream); 
		ImageView imageView = new ImageView(image);
		imageView.setFitHeight(120);
		imageView.setFitWidth(220);
        VBox vBox = new VBox();
        Scene scene = new Scene(new Group());
        stage.setTitle("Vehicle Inventory Manager");
        stage.setWidth(700);
        stage.setHeight(550);
        table.setEditable(true);
        TableColumn Col1 = new TableColumn("Id");
        Col1.setMinWidth(100);
        Col1.setCellValueFactory(
                new PropertyValueFactory<Car, String>("id"));
 
        TableColumn Col2 = new TableColumn("Make");
        Col2.setMinWidth(100);
        Col2.setCellValueFactory(
                new PropertyValueFactory<Car, String>("make"));
 
        TableColumn Col3 = new TableColumn("Model");
        Col3.setMinWidth(100);
        Col3.setCellValueFactory(
                new PropertyValueFactory<Car, String>("model"));
        TableColumn Col4 = new TableColumn("Year");
        Col4.setMinWidth(100);
        Col4.setCellValueFactory(
                new PropertyValueFactory<Car, String>("year"));
        TableColumn Col5 = new TableColumn("Miles");
        Col5.setMinWidth(100);
        Col5.setCellValueFactory(
                new PropertyValueFactory<Car, String>("miles"));
        TableColumn Col6 = new TableColumn("Color");
        Col6.setMinWidth(100);
        Col6.setCellValueFactory(
                new PropertyValueFactory<Car, String>("color"));
         
        table.setItems(data);
        table.getColumns().addAll(Col1,Col2,Col3,Col4,Col5,Col6);
 
        final VBox vbox = new VBox();
        final VBox vboxtop = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(60, 40, 35, 40));
        Button login = new Button("Add Login");
        Button add = new Button("Add Vehicle");
        Button next = new Button("Next Page");
        Button back = new Button("Previous Page");
        next.setLayoutX(600);
        next.setLayoutY(470);
        back.setLayoutX(100);
        back.setLayoutY(470);
        next.setOnAction(actionEvent-> {
            if(stage!=null){
            		Stage stagenew = (Stage) add.getScene().getWindow();
            		stagenew.close();
            		x+=10;
            		show(stage);
            		
            		
            	}
            
        });
        back.setOnAction(actionEvent-> {
            if(stage!=null){
            		Stage stagenew = (Stage) add.getScene().getWindow();
            		stagenew.close();
            		x = 1;
            		show(stage);
            		
            		
            	}
            
        });
        add.setOnAction(actionEvent-> {
            if(stage!=null){
            		Stage stagenew = (Stage) add.getScene().getWindow();
            		addCar();
            		stagenew.close();
            		
            		
            	}
            
        });
        login.setOnAction(actionEvent-> {
            if(stage!=null){
            		Stage stagenew = (Stage) login.getScene().getWindow();
            		addLogin();
            		stagenew.close();
            		
            		
            	}
            
        });
        add.setLayoutX(120);
        add.setLayoutY(10);
        Button remove = new Button("Remove Vehicle");
        remove.setLayoutX(210);
        remove.setLayoutY(10);
        remove.setOnAction(actionEvent-> {
            if(stage!=null){
            		Stage stagenew = (Stage) remove.getScene().getWindow();
            		removeCar();
            		stagenew.close();
            		
            		
            	}
        });
        vboxtop.setAlignment(Pos.TOP_LEFT);
        vboxtop.setSpacing(5);
        vboxtop.setPadding(new Insets(10,0,0,40));
        vboxtop.getChildren().addAll(login);
        vbox.getChildren().addAll(table);
 
        ((Group) scene.getRoot()).getChildren().addAll(vbox,vboxtop,add,remove,next,back);
 
        stage.setScene(scene);
        stage.show();
    }
    public void addCar() {
        VBox vBox = new VBox();
        vBox.setSpacing(12);
        vBox.setPadding(new Insets(20,20,20,20));
        vBox.setAlignment(Pos.CENTER);
        Label label = new Label("Add Vehicle");
        label.setFont(Font.font("Cambria",24));
        Label make = new Label("MAKE");
        TextField makef = new TextField(); 
        makef.setMaxWidth(400);
        Label model = new Label("MODEL");
        TextField modelf = new TextField(); 
        modelf.setMaxWidth(400);
        Label year = new Label("YEAR");
        TextField yearf = new TextField(); 
        yearf.setMaxWidth(400);
        Label mileage = new Label("MILEAGE");
        TextField mileagef = new TextField(); 
        mileagef.setMaxWidth(400);
        Label color = new Label("COLOR");
        TextField colorf = new TextField(); 
        colorf.setMaxWidth(400);
        Button send = new Button("Add Car");
        Label tryagain = new Label(null);
        
        vBox.getChildren().addAll(label,make,makef,model,modelf,year,yearf,mileage,mileagef,color,colorf,send,tryagain);

        send.setOnAction(actionEvent-> {
            if(stage!=null){
            	String makes = makef.getText();
            	String models = modelf.getText();
            	String years = yearf.getText();
            	String mileages = mileagef.getText();
            	String colors = colorf.getText();
            	if (isStringOnlyAlphabet(makes) && isStringOnlyAlphabet(models) && isStringOnlyAlphabet(years) && isStringOnlyAlphabet(mileages) && isStringOnlyAlphabet(colors)) {
                	try {
                		addCar.main(makes,models,years,mileages,colors);
                		Stage stagenew = (Stage) send.getScene().getWindow();
                		stagenew.close();
                		x=1;
                		show(stage);
    				} catch (IOException e) {
    					e.printStackTrace();
    				}
            	} else {
            		tryagain.setText("Input cannot contain commas or any other special character");
            		tryagain.setTextFill(Color.RED);
            	}
            	
            	

  
                stage.requestFocus();
                return;
            }
        });
        final Stage stagec = stage;
        Scene scene = new Scene(vBox,500,500);
        stagec.setScene(scene);
        stagec.setTitle("Add Car");
        stagec.setAlwaysOnTop(true);
        stagec.show();

    }
    public void addLogin() {
            VBox vBox = new VBox();
            vBox.setSpacing(8);
            vBox.setPadding(new Insets(10,10,10,10));
            vBox.setAlignment(Pos.CENTER);
            Label label = new Label("Add User");
            label.setFont(Font.font("Cambria",24));
            Label username = new Label("New Username");
            TextField usertext = new TextField();
            usertext.setMaxWidth(250);
            Label password = new Label("New Password");
            PasswordField passf = new PasswordField(); 
            passf.setMaxWidth(250);
            Button login = new Button("Ok");
            Label tryagain = new Label(null);
            vBox.getChildren().addAll(label, username, usertext, password, passf,login,tryagain);

            login.setOnAction(actionEvent-> {
                if(stage!=null){
                	String userName = usertext.getText();
                	String Password = passf.getText();
                	if (isStringOnlyAlphabet(userName) && isStringOnlyAlphabet(Password)) {
                    	try {
        					addUser.main(userName, Password);
                    		Stage stagenew = (Stage) login.getScene().getWindow();
                    		stagenew.close();
                    		x=1;
                    		show(stage);
        				} catch (IOException e) {
        					e.printStackTrace();
        				}
                	} else {
                		tryagain.setText("Input cannot contain commas or any other special character");
                		tryagain.setTextFill(Color.RED);
                	}
                	
                	

      
                    stage.requestFocus();
                    return;
                }
            });
        

        	final Stage stageb = stage;
        	Scene scene = new Scene(vBox,500,500);
            stageb.setScene(scene);
            stageb.show();
            stageb.setTitle("Login");
            stageb.setAlwaysOnTop(true);
        }
    public void removeCar() {
        VBox vBox = new VBox();
        vBox.setSpacing(8);
        vBox.setPadding(new Insets(10,10,10,10));
        vBox.setAlignment(Pos.CENTER);
        Label label = new Label("Enter Id to remove");
        label.setFont(Font.font("Cambria",24));
        Label Id = new Label("Id");
        TextField usertext = new TextField();
        usertext.setMaxWidth(250);
        Button remove = new Button("Remove");
        vBox.getChildren().addAll(label,usertext,remove);

        remove.setOnAction(actionEvent-> {
            if(stage!=null){
            	int Ide = Integer.parseInt(usertext.getText());
            	
            	try {
					removeUser.removeuser(Ide);
            		Stage stagenew = (Stage) remove.getScene().getWindow();
            		stagenew.close();
            		x=1;
            		show(stage);
				} catch (IOException | CsvException e) {
					e.printStackTrace();
				}
            	

  
                stage.requestFocus();
                return;
            }
        });
    

    	final Stage stageb = stage;
        Scene scene = new Scene(vBox,500,500);
        stageb.setScene(scene);
        stageb.show();
        stageb.setTitle("Login");
        stageb.setAlwaysOnTop(true);
    }
    
    public static class Car {
    	 
        private final SimpleStringProperty Id;
        private final SimpleStringProperty Make;
    	private final SimpleStringProperty Model;
        private final SimpleStringProperty Year;
        private final SimpleStringProperty Miles;
        private final SimpleStringProperty Color;
 
        private Car(String id, String make, String model, String year, String miles, String color) {
            this.Id = new SimpleStringProperty(id);
            this.Make = new SimpleStringProperty(make);
            this.Model = new SimpleStringProperty(model);
            this.Year = new SimpleStringProperty(year);
            this.Miles = new SimpleStringProperty(miles);
            this.Color = new SimpleStringProperty(color);
        }
        public String getId() {
            return Id.get();
        }
 
        public void setId(String id) {
            Id.set(id);
        }
 
        public String getMake() {
            return Make.get();
        }
 
        public void setMake(String make) {
            Make.set(make);
        }
 
        public String getModel() {
            return Model.get();
        }
 
        public void setModel(String model) {
            Model.set(model);
        }
        public String getYear() {
            return Year.get();
        }
 
        public void setYear(String year) {
            Model.set(year);
        }
        public String getMiles() {
            return Miles.get();
        }
 
        public void setMiles(String miles) {
            Miles.set(miles);
        }
        public String getColor() {
            return Color.get();
        }
 
        public void setColor(String color) {
            Color.set(color);
        }
    }
    public static boolean isStringOnlyAlphabet(String str){
        Pattern pattern = Pattern.compile("[^a-zA-Z0-9]");
        Matcher matcher = pattern.matcher(str);
        boolean isStringContainsSpecialCharacter = matcher.find();
        if(isStringContainsSpecialCharacter) {
        	return false;
        	 
        }
        else {
        	return true;
        	
            
    }
}

}