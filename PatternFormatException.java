import java.io.*;


public class PatternFormatException extends IOException{
		
    public PatternFormatException(){
            
    super("please specify the pattern!");
            
    }
            
    public PatternFormatException(String message){
            
    super(message);
            
    }
}