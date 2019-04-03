public class PackedWorld extends World {
    private long world;
    
    public PackedWorld (Pattern serial) throws Exception{
    super(serial);
    world = 0l;
    if(getPattern().getHeight()>8 || getPattern().getWidth()>8){
        throw new Exception("given height or width cannot be used when constracting world using type long!!!");
    }
    getPattern().initialise(this);
    }
    public boolean getCell(int col, int row) {
        if (row < 0 || row >= getPattern().getHeight()) {
            return false;
        }
        if (col < 0 || col >= getPattern().getWidth()) {
            return false;
        }
        if (((world >>> (row * getPattern().getWidth() + col)) & 1) == 1)
            return true;
        else
            return false;
    }
    public void setCell(int col, int row, boolean value){
        if (row < 0 || row >= getPattern().getHeight()) {
            return;
        }
        if (col < 0 || col >= getPattern().getWidth()) {
            return;
        }
        if(value){
                world = world | (1L << row*getPattern().getWidth()+col);
        }
        else{
            if(getCell(col, row)){
                world =  world ^ (1L << row*getPattern().getWidth()+col);
            }
        }
    }
    protected void nextGenerationImpl(){
        long worldCopy = 0L;
        for(int i=0; i<getPattern().getHeight(); i++){
            for(int j=0; j<getPattern().getWidth(); j++){
                if(computeCell(j,i)){
                    worldCopy = worldCopy | (1L << i*getPattern().getWidth()+j);
                }
            }
        }   
        world = worldCopy;
    }

}