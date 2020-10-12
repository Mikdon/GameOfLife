package application;

import javafx.scene.control.Button;

public class Cell { //richiamando la classe cell richiamo il bottone
	
	private boolean alive;
	private final Button button= new Button(); //incapsulato
	
	public Cell(boolean isAlive) {

		
		if (isAlive) {
			button.setStyle("-fx-color: white;");			
		}
		else button.setStyle("-fx-color: black;");
		
		this.alive=isAlive;
		
    	button.setPrefSize(25, 10);
    	
    	button.setOnAction(actionEvent -> toggleAlive());
    	
       		
	}
	
	
	public void toggleAlive() {  //cambia lo stato del bottone
		
		this.alive=!alive;
		
		if (alive) {
			button.setStyle("-fx-color: white;");			
		}
		else button.setStyle("-fx-color: black;");
		
		
	}
				
	
	
	public boolean isAlive() {
		
		return this.alive;
		
	}
	
	public Button getButton() {
		
		return button;
	}
	

}
