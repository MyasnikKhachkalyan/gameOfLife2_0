public class ArrayWorld extends World {
    private boolean[][] world;
    
    public ArrayWorld(String serial) {
    super(serial);
    // TODO: initialise world
    getPattern().initialise(this);
    }
    public boolean getCell(int col, int row){
        if(col<0 || col>=width){
            return false;
        }
        if(row<0 || row>=height){
            return false;
        }
        return world[row][col];
        
    }
    public void setCell(int col, int row, boolean value){
        if(col<0 || col>=width){
            return;
        }
        if(row<0 || row>=height){
            return;
        }
        world[row][col] = value;
    }
    protected void nextGenerationImpl(){
        boolean[][] worldCopy = new boolean[width][height];
        for(int i=0; i<height; i++){
            for(int j=0; j<width; j++){
                if(computeCell(j,i)){
                    worldCopy[i][j] = true;
                }
            }
        }   
        for(int i=0; i<height; i++){
            for(int j=0; j<width; j++){
                 world[i][j] = worldCopy[i][j] ;
            }
        }
    }
    // public static void main(String args[]) throws Exception {
    //     ArrayWorld pl = new ArrayWorld(args[0]);
    //     pl.play();
    //     }
}