import java.io.IOException;
import java.util.Scanner;
public class GameOfLife{
    private World world;

    public GameOfLife(World w){
        world = w;
    } 
    public void print(){
        System.out.println("- " + world.getGenerationCount());
        for(int i=0; i<world.getPattern().getHeight(); i++){
            for(int j=0; j<world.getPattern().getWidth(); j++){
                if(world.getCell(j, i)){
                    System.out.print("#");
                }
                else{
                    System.out.print("-");
                }
            }
            System.out.println();
        }
    }
    public void play() throws IOException {  
        Scanner myObj = new Scanner(System.in);   
        print();  
        String continueGame;   
        for(continueGame = myObj.next();!continueGame.equals("q") && continueGame.equals("s") && continueGame.length()==1;continueGame = myObj.next()){  
                world.nextGeneration();
                print();
        }
        if(continueGame.equals("q")){
            System.out.println("You succesfully quited the game");
        }
        else if(continueGame.length()!=1){
             throw new IOException("U inputed more than one character");
        }
        else{
             throw new IOException("U inputed wrong character");
        }
    }
    public static void main(String[] args)throws Exception{
        World w=null;
        if(args.length==0){
            throw new PatternFormatException();
        }
        else if(args.length==1){
            w = new ArrayWorld(args[0]);
        }
        else if(args[0].substring(2).equals("array")){
            w = new ArrayWorld(args[1]);
        }
        else if(args[0].substring(2).equals("packed")){
            w = new PackedWorld(args[1]);
        }
        
        GameOfLife gol = new GameOfLife(w);
        gol.play();
    }
}