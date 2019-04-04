import java.io.*;

public class ArrayWorld extends World {
    private boolean[][] world;
    
    public ArrayWorld(Pattern serial) throws IOException {
    super(serial);
    world = new boolean[getPattern().getHeight()][getPattern().getWidth()];
    getPattern().initialise(this);
    }
    public boolean getCell(int col, int row){
        if(col<0 || col>=getPattern().getWidth()){
            return false;
        }
        if(row<0 || row>=getPattern().getHeight()){
            return false;
        }
        return world[row][col];
        
    }
    public void setCell(int col, int row, boolean value){
        if(col<0 || col>=getPattern().getWidth()){
            return;
        }
        if(row<0 || row>=getPattern().getHeight()){
            return;
        }
        world[row][col] = value;
    }
    protected void nextGenerationImpl(){
        boolean[][] worldCopy = new boolean[getPattern().getWidth()][getPattern().getHeight()];
        for(int i=0; i<getPattern().getHeight(); i++){
            for(int j=0; j<getPattern().getWidth(); j++){
                if(computeCell(j,i)){
                    worldCopy[i][j] = true;
                }
            }
        }   
        for(int i=0; i<getPattern().getHeight(); i++){
            for(int j=0; j<getPattern().getWidth(); j++){
                 world[i][j] = worldCopy[i][j] ;
            }
        }
    }

}