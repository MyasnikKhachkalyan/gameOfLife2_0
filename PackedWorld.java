public class PackedWorld extends World {
    private long world;
    
    public PackedWorld(String serial) {
    super(serial);
    if(getPattern().getHeight()>8 || getPattern().getWidth()>8){
        throw new Exception("given height or width cannot be used when constracting world using type long!!!");
    }
    getPattern().initialise(this);
    }
    public boolean getCell(int col, int row) {
        if (row < 0 || row >= height) {
            return false;
        }
        if (col < 0 || col >= width) {
            return false;
        }
        if (((world >>> (row * width + col)) & 1) == 1)
            return true;
        else
            return false;
    }
    public void setCell(int col, int row, boolean value){
        if (row < 0 || row >= height) {
            return;
        }
        if (col < 0 || col >= width) {
            return;
        }
        if(value){
                world = world | (1L << row*width+col);
        }
        else{
            if(getCell(col, row)){
                world =  world ^ (1L << row*width+col);
            }
        }
    }
    protected void nextGenerationImpl(){
        long worldCopy = 0L;
        for(int i=0; i<height; i++){
            for(int j=0; j<width; j++){
                if(computeCell(j,i)){
                    worldCopy = worldCopy | (1L << i*width+j);
                }
            }
        }   
        world = worldCopy;
    }
    // public static void main(String args[]) throws Exception {
    //     ArrayWorld pl = new ArrayWorld(args[0]);
    //     pl.play();
    //     }
}