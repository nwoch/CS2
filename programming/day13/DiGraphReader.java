import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;

/**
 * Class that is capable of reading in a graph file from disk.
 * Graph files are line based. Node names have type String and edge weights have
 * type Double. Fields on the line are separated by ':' and there is no extra white space.
 */
public class DiGraphReader implements IGraphReader {
    // Fields needed for the Graph Reader should be added here

    /**
     * Creates a new graph reader instance
     */
    public DiGraphReader() {
        // Configure the graph reader here
    }

    /**
     * Reads in a file and instantiates the graph
     * @param filename the file to read
     * @return the instantiated graph
     */
    public IGraph<String,Double> read(String filename) throws FileNotFoundException, IOException {
        IGraph<String, Double> r = new Graph<String, Double>();
        int value_1 = 0;
        int value_2 = 0;

        // Open the file
        File graph = new File(filename);
        Scanner scanner = new Scanner(graph).useDelimiter(":|\\n");
        Scanner scanner2 = new Scanner(graph).useDelimiter(":|\\n");

        // Parse the lines. If a line does not have exactly 3 fields, ignore the line.
        // For each line, add the nodes and edge
        while (scanner.hasNextLine()) {
          if (scanner.findInLine("(\\w+):(\\w+):") instanceof String) {
            scanner.nextLine();
            String value1 = scanner2.next();
            String value2 = scanner2.next();
            INode<String> source = new Node<String>(null);
            INode<String> destination = new Node<String>(null);
            for (int i = 0; i < r.getNodeSet().length; i++) {
              if (r.getNodeSet()[i] != null) {
                if (r.getNodeSet()[i].getValue().equals(value1)) {
                  source = r.getNodeSet()[i];
                  value_1++;
                }
                if (r.getNodeSet()[i].getValue().equals(value2)) {
                  destination = r.getNodeSet()[i];
                  value_2++;
                }
              }
            }
            if (value_1 == 0) {
              source = r.addNode(value1);
            }
            if (value_2 == 0) {
              destination = r.addNode(value2);
            }
            value_1 = 0;
            value_2 = 0;
            r.addEdge(source, destination, Double.parseDouble(scanner2.next()));
          }
          else {
            scanner2.nextLine();
          }
        }

        // Return the graph instance
        return r;
    }

    /**
     * Simple main method to open and process a file
     */
    public static void main(String[] argv) throws Exception {
        // This code should work without modification once your reader code is working
        IGraphReader r = new DiGraphReader();
        IGraph<String,Double> g = r.read("graphfile.cs2");
        IEdge<String,Double>[] edges = g.getEdgeSet();
        for(int i=0; i<edges.length; i++) {
            System.out.println(edges[i].getSource().getValue()+" -> "+edges[i].getDestination().getValue()+"  w: "+edges[i].getWeight());
        }
    }
}
