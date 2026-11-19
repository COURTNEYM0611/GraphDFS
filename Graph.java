import java.util.ArrayList;

public class Graph {

    private int vertices_no;

    // Adjacency List
    private ArrayList<ArrayList<Integer>> adj_list;

    // Adjacency Matrix
    private int[][] adj_matrix;


    // Constructor
    public Graph(int vertices_no) {

        this.vertices_no = vertices_no;

        // Create adjacency list
        adj_list = new ArrayList<>();

        for (int i = 0; i < vertices_no; i++) {
            adj_list.add(new ArrayList<>());
        }

        // Create adjacency matrix
        adj_matrix = new int[vertices_no][vertices_no];
    }


    // Add edges to both graph representations
    public void add_edges(int from, int to) {

        // Adjacency List
        adj_list.get(from).add(to);
        adj_list.get(to).add(from);

        // Adjacency Matrix
        adj_matrix[from][to] = 1;
        adj_matrix[to][from] = 1;
    }


    // DFS for Adjacency List
    public void DFS_List(int start_node) {

        boolean[] visited = new boolean[vertices_no];

        System.out.println("DFS - Adjacency List:");

        DFS_List_Recursive(start_node, visited);
    }


    // Recursive DFS for Adjacency List
    private void DFS_List_Recursive(int node, boolean[] visited) {

        visited[node] = true;

        System.out.println("Visiting: " + node);

        for (int neighbour : adj_list.get(node)) {

            if (!visited[neighbour]) {

                DFS_List_Recursive(neighbour, visited);
            }
        }
    }


    // DFS for Adjacency Matrix
    public void DFS_Matrix(int start_node) {

        boolean[] visited = new boolean[vertices_no];

        System.out.println("\nDFS - Adjacency Matrix:");

        DFS_Matrix_Recursive(start_node, visited);
    }


    // Recursive DFS for Adjacency Matrix
    private void DFS_Matrix_Recursive(int node, boolean[] visited) {

        visited[node] = true;

        System.out.println("Visiting: " + node);

        for (int neighbour = 0; neighbour < vertices_no; neighbour++) {

            if (adj_matrix[node][neighbour] == 1 && !visited[neighbour]) {

                DFS_Matrix_Recursive(neighbour, visited);
            }
        }
    }
}
