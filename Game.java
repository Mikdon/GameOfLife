package application;

public class Game {
	
    private final int width;
    private final int height;
    private Cell[][] cells;
    private int generation = 1;

    public Game(int width, int height) {
        this.width = width;
        this.height = height;
        this.cells = new Cell[height][width]; //Già tutti false
        
        for (int row=0; row<height; row++) {
        	
        	for (int col=0; col<width; col++) {
        		
        		cells[row][col]=new Cell(false);            		
        	}      	
        }    
    }

    public void nextGeneration() {
    	//copio la matrice inanzittutto
    	Cell[][] next = new Cell[height][width];
  
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
            	next[row][col]=cells[row][col];  //copio la matrice;
                int aliveNeighbours = 0;
                for (int adjacentRow = -1; adjacentRow < 2; adjacentRow++) { //ciclo righe adiacenti
                    for (int adjacentColumn = -1; adjacentColumn < 2; adjacentColumn++) { //ciclo colonne adiacenti (le 9 caselle)
                    	
                        if (!(adjacentRow == 0 && adjacentColumn == 0)  //qui escludo la 9 casella che è la centrale
                                && row + adjacentRow < height   //affinchè non vada fuori matrice verso il basso
                                && row + adjacentRow >= 0       //verso alto
                                && col + adjacentColumn < width  //affinchè non vada fuori matrice verso destra
                                && col + adjacentColumn >= 0  //qui verso sinistra
                                && cells[row + adjacentRow][col + adjacentColumn].isAlive()) {
                            aliveNeighbours++;
                        }
                    }
                }
                if (cells[row][col].isAlive() && (aliveNeighbours < 2 || aliveNeighbours > 3)
                		|| !cells[row][col].isAlive() && aliveNeighbours==3) {
                    next[row][col].toggleAlive();
                } 
                }
        }
        cells = next;
        generation++;
    }
    
    
    public Cell[][] getCells() {
    	
    	return cells;
    	
    }

  
}
