import java.io.*;
import java.net.*;


public class PatternStore {
    public static final int MAX_NUMBER_PATTERNS = 1000;
    private Pattern[] patterns = new Pattern[MAX_NUMBER_PATTERNS];
    private int numberUsed = 0;

    public PatternStore(String source) throws Exception {
    if (source.startsWith("http://") || source.startsWith("https://")) {
        loadFromURL(source);
    }
    else {
        loadFromDisk(source);
    }

    }
    public PatternStore(Reader source) throws Exception {
        load(source);
    }

    private void load(Reader r) throws Exception {
        BufferedReader b = new BufferedReader(r);
        String line;
        while ( (line = b.readLine()) != null) {
            if(new Pattern(line) != null){
                patterns[numberUsed] = new Pattern(line);
                numberUsed++;
            }
        }
        b.close();
    }

    private void loadFromURL(String url) throws Exception {
        URL destination = new URL(url);
        URLConnection conn = destination.openConnection();
        Reader r = new InputStreamReader(conn.getInputStream());
        load(r);
    }

    private void loadFromDisk(String filename) throws Exception {
        Reader r = new FileReader(filename);
        load(r);
    }
    public Pattern[] getPatterns() {
        Pattern[] patternsIm = new Pattern[numberUsed];
        for(int i =0; i<patternsIm.length; i++){
            patternsIm[i] = patterns[i];
        }
        return patternsIm;
    }
    public String[] getPatternAuthors() {
        String[] authors = new String[numberUsed];
        for(int i =0; i<authors.length; i++){
            authors[i] = patterns[i].getAuthor();
        }
        return authors;
    }
    public String[] getPatternNames() {
        String[] names = new String[numberUsed];
        for(int i =0; i<names.length; i++){
            names[i] = patterns[i].getName();
        }
        return names;
    }

}