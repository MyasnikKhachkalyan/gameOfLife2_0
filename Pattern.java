public class Pattern{
    private String name;
    private String author;
    private int width;
    private int height;
    private int startUpperCol;
    private int startUpperRow;
    private String cells;

    public Pattern(String initialiser){
        String[] arr = initialiser.split(":");
        name = arr[0];
        author = arr[1];
        width = Integer.parseInt(arr[2]);
        height = Integer.parseInt(arr[3]);
        startUpperCol = Integer.parseInt(arr[4]);
        startUpperRow = Integer.parseInt(arr[5]);
        cells = arr[6];
    }

    public void initialise(World world){
        String[] helparr = cells.split(" ");


        for(int i=0; i<helparr.length; i++){
            for(int j=0; j<helparr[i].length(); j++){
                if(Character.getNumericValue(helparr[i].charAt(j)) == 1){
                            if(j<0 || j>=width){
                                return;
                            }
                            if(i<0 || i>=height){
                                return;
                            }
                            world.setCell(j+startUpperCol, i+startUpperRow, true);
                }
            }
        } 
    }
    
    public String getName(){
        return name;
    }

    public String getAuthor(){
        return author;
    }

    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }

    public int getStartCol(){
        return startUpperCol;
    }

    public int getStartRow(){
        return startUpperRow;
    }

    public String getCells(){
        return pattern;
    }
}