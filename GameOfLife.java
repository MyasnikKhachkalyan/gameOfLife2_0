import java.util.Scanner;
public class GameOfLife{
    private World world;

    public GameOfLife(){

    } 
    public void print(){
        for(int i=0; i<height; i++){
            for(int j=0; j<width; j++){
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
    public void play(){
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
             throw new Error("U inputed more than one character");
        }
        else{
             throw new Error("U inputed wrong character");
        }
    }
    public static void main(String[] args){

    }
}