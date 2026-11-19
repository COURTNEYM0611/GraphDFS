//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        int maxVertex = -1;

        // First find the largest vertex number
        try (BufferedReader reader =
                     new BufferedReader(new FileReader("src/edges.txt"))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] values = line.trim().split("\\s+");

                if (values.length < 2) {
                    continue;
                }

                try {

                    int source = Integer.parseInt(values[0]);
                    int target = Integer.parseInt(values[1]);

                    maxVertex = Math.max(maxVertex,
                            Math.max(source, target));

                } catch (NumberFormatException e) {

                    // Skip the Source Target header
                }
            }

        } catch (IOException e) {

            System.out.println("Error reading file: " + e.getMessage());
            return;
        }


        if (maxVertex < 0) {
            System.out.println("No graph edges found.");
            return;
        }


        // Create graph based on the largest vertex number
        int vertices = maxVertex + 1;

        Graph graph = new Graph(vertices);


        // Read the file again and add edges
        try (BufferedReader reader =
                     new BufferedReader(new FileReader("src/edges.txt"))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] values = line.trim().split("\\s+");

                if (values.length < 2) {
                    continue;
                }

                try {

                    int source = Integer.parseInt(values[0]);
                    int target = Integer.parseInt(values[1]);

                    graph.add_edges(source, target);

                } catch (NumberFormatException e) {

                    // Skip the header
                }
            }

        } catch (IOException e) {

            System.out.println("Error reading file: " + e.getMessage());
            return;
        }


        // Run DFS using both representations
        graph.DFS_List(0);

        graph.DFS_Matrix(0);
    }
}
