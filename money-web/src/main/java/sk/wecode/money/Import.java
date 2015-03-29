package sk.wecode.money;



import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Import {

    private Map<String, String> keywords = new HashMap<String, String>();

    public Import() throws IOException {
        BufferedReader rules = new BufferedReader(new InputStreamReader(new FileInputStream(new File("d:\\work\\rules.txt"))));
        String line = null;
        while((line = rules.readLine())!=null) {
            String[] split = line.split(";");
            String[] keywords = split[0].split(",");
            for (int i = 0; i < keywords.length; i++) {
                this.keywords.put(keywords[i], split[1]);
            }
        }
        System.out.println(keywords);
    }

    private void process() throws IOException {
        BufferedReader data = new BufferedReader(new InputStreamReader(new FileInputStream(new File("d:\\work\\data.txt"))));
        String line = null;
        int all=0;
        int recognized=0;
        while((line = data.readLine())!=null) {
            all++;
            String currentCategory = null;
            for(String category : keywords.keySet()) {
                if (line.contains(category)) {
                    currentCategory = keywords.get(category);
                    recognized++;
                }
            }
            System.out.println(currentCategory + "\t\t"+line);
        }
    }

    public static void main(String[] args) throws IOException {
        new Import().process();
    }
}
