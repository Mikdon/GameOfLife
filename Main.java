package application;
	
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;


public class Main extends Application {
	
	int gen;
	
	
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,600,600);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			Game game = new Game(14,14);
			GridPane grid= new GridPane();
			grid.setPadding(new Insets(5,5,5,5));	    
			grid.setHgap(2);
			grid.setVgap(2);
			
			for (int row=0; row<14; row++) {
				
				for (int col=0; col<14; col++) {
					
					grid.add(game.getCells()[row][col].getButton(), col, row); //aggiungo
			
				}
				
			}
			
			Button nextGeneration = new Button(String.valueOf("Next generation"));
		    grid.add(nextGeneration, 20, 5);
		    
		   
		    gen=0;
		    Label label = new Label(String.valueOf("  Generation: "+gen));
		    grid.add(label, 20, 7);

		    
		    nextGeneration.setOnAction(actionEvent -> {
		    	
			    
		        game.nextGeneration();
		        gen++;
		        label.setText("  Generation: " +gen);
		        
		     
			  		
		    });
		    
		    Button restart = new Button(String.valueOf("Restart"));
		    grid.add(restart, 20, 3);
		    restart.setOnAction(actionEvent ->{
		    	
		    	
		    	start(primaryStage);
		    	
		    	
		    });
			
			primaryStage.setScene(new Scene(grid));
			primaryStage.show();
			primaryStage.setTitle("Game of Life di Michele Donati");
			
			


			        
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
                  
		launch(args);
		
	}
}
