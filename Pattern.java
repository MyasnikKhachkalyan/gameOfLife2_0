
public class Pattern{
    private String name;
    private String author;
    private int width;
    private int height;
    private int startUpperCol;
    private int startUpperRow;
    private String cells;

    public Pattern(String initialiser) throws Exception{
        String[] arr = initialiser.split(":");
        if(arr.length!=7){
            throw new PatternFormatException(arr.length);
        }
        
        name = arr[0];
        author = arr[1];
        String err = "", errorName = "";
        try{
            err  = arr[2];
            errorName = "width";
            width = Integer.parseInt(arr[2]);
            err  = arr[3];
            errorName = "height";
            height = Integer.parseInt(arr[3]);
            err = arr[4];
            errorName = "StartX";
            startUpperCol = Integer.parseInt(arr[4]);
            err = arr[5];
            errorName = "StartY";
            startUpperRow = Integer.parseInt(arr[5]);
        }
        catch(Exception e){
            throw new PatternFormatException(err, errorName);

        }
        
        for(int i = 0; i<arr[6].length(); i++){
            if(arr[6].charAt(i)!= '0' && arr[6].charAt(i)!= '1' && arr[6].charAt(i)!= ' '){
                throw new PatternFormatException(arr[6], "Malformed pattern");
            }
        }
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
        return cells;
    }
}