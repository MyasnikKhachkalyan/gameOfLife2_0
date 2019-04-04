

public class PatternFormatException extends Exception{
		
    public PatternFormatException(){
            
    super("please specify the pattern!");
            
    }
            
    public PatternFormatException(String message){
            
    super(message);
            
    }
    public PatternFormatException(String err, String errorName){
        if(errorName.equals("Malformed pattern")){
            System.out.println("Invalid pattern format: Malformed pattern "+err+".");
        }
        System.out.println("Invalid pattern format: Could not interpret the "+errorName+" field as a number (`"+ err +" `given).");
    }
    public PatternFormatException(int num){
        System.out.println("Invalid pattern format: Incorrect number of fields in pattern(found " + num +").");
    }
}