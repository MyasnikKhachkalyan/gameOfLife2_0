import java.io.*;


public class GameOfLife{
    private World world;
    private PatternStore store;

    public GameOfLife(PatternStore s){
        store = s;
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
        String response = "";
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please select a pattern to play (l to list):");
        while (!response.equals("q")) {
            response = in.readLine();
            System.out.println(response);
            if (response.equals("f")) {
                if (world == null) {
                        System.out.println("Please select a pattern to play (l to list):");
                }
                else {
                    world.nextGeneration();
                    print();
                }
            }
            else if (response.equals("l")) {
                Pattern[] names = store.getPatterns();
                int i = 0;
                for (Pattern p : names) {
                    System.out.println(i + " " + p.getName() + " (" + p.getAuthor() + ")");
                    i++;
                }
            }
            else if (response.startsWith("p")) {
                Pattern[] names = store.getPatterns();
                int index = Integer.parseInt(response.split(" ")[1]);
                Pattern pat = names[index];
                if(pat.getHeight()<= 8 && pat.getWidth()<=8){
                    world = new PackedWorld(pat);
                }
                else{
                    world = new ArrayWorld(pat);
                }
                print();
            }
        }
    }
    public static void main(String args[]) throws IOException {
        if (args.length != 1) {
            System.out.println("Usage: java GameOfLife <path/url to store>");
            return;
        }
        try {
            PatternStore ps = new PatternStore(args[0]);
            GameOfLife gol = new GameOfLife(ps);
            gol.play();
        }
        catch (IOException ioe) {
            System.out.println("Failed to load pattern store");
        }
    }
}