import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;
import java.util.SortedSet;
import java.util.TreeSet;

public class GraphDistance {

    public static class Node {

        private int val;
        private int dist;
        private String path;
        private List<Node> children = new ArrayList<>();

        public Node(int val) {
            this.val = val;
        }

        public void addNode(Node node) {
            this.children.add(node);
        }

    }

    public static class Pair {

        private int left;
        private int right;

        public Pair(int left, int right) {
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "(" + left + ", " + right + ")";
        }

    }

    public static class Edge {

        private int val;
        private Pair vert;

        public Edge(int val, Pair vert) {
            this.val = val;
            this.vert = vert;
        }

        @Override
        public String toString() {
            return this.vert.toString() + " => " + this.val;
        }

    }

    public static class Graph {

        private Node head;
        private int size;
        private List<Edge> edges = new ArrayList<>();

        public Graph(Node head) {
            this.head = head;
            this.size = 1;
        }

        public void addEdge(Edge edge) {
            this.edges.add(edge);
        }

        public void addNode(int val, Node node) {
            Node parent = find(val);
            if(parent != null) {
                parent.addNode(node);
                size++;
            }
        }

        public int getSize() {
            return this.size;
        }

        public int getWeight(int n1, int n2) {
            for(Edge edge : edges) {
                if((edge.vert.left == n1 && edge.vert.right == n2) || (edge.vert.left == n2 && edge.vert.right == n1)) {
                    return edge.val;
                }
            }
            return 0;
        }

        public SortedSet<String> findAllPaths(Node start, int n2, List<Integer> visited) {
            SortedSet<String> paths = new TreeSet<>();
            Queue<Node> queue = new LinkedList<>();
            queue.add(start);

            if(visited == null) {
                visited = new ArrayList<>();
            }
            visited.add(start.val);

            while(!queue.isEmpty()) {
                Node node = queue.poll();

                if(n2 == node.val) {
                    paths.add(node.path + " => " + node.dist);
                } else {
                    for(Node child : node.children) {
                        if(!visited.contains(child.val)) {
                            child.dist = node.dist + getWeight(node.val, child.val);
                            child.path = node.path + " -> " + child.val;
                            queue.add(child);
                            visited.add(child.val);
                            paths.addAll(findAllPaths(child, n2, deepCopy(visited)));
                        }
                    }
                }
            }

            return paths;
        }

        private List<Integer> deepCopy(List<Integer> intList) {
            List<Integer> newList = new ArrayList<>();
            newList.addAll(intList);
            return newList;
        }

        public int findDist(int  n1, int n2) {
            int dist = 0;
            Node start = find(n1);
            if(start != null) {
                start.dist = 0;
                start.path = "" + start.val;
                Queue<Node> queue = new LinkedList<>();
                queue.add(start);

                List<Integer> visited = new ArrayList<>();
                visited.add(start.val);

                while(!queue.isEmpty()) {
                    Node node = queue.poll();

                    if(n2 == node.val) {
                        dist = node.dist;
                        log("path=" + node.path);
                        break;
                    } else {
                        for(Node child : node.children) {
                            if(!visited.contains(child.val)) {
                                child.dist = node.dist + getWeight(node.val, child.val);
                                child.path = node.path + " -> " + child.val;
                                queue.add(child);
                                visited.add(child.val);
                            }
                        }
                    }
                }
            }

            return dist;
        }

        public Node find(int val) {
            Queue<Node> queue = new LinkedList<>();
            queue.add(this.head);

            List<Integer> visited = new ArrayList<>();
            visited.add(this.head.val);

            Node found = null;
            while(!queue.isEmpty()) {
                Node node = queue.poll();

                if(val == node.val) {
                    found = node;
                    break;
                } else {
                    for(Node child : node.children) {
                        if(!visited.contains(child.val)) {
                            queue.add(child);
                            visited.add(child.val);
                        }
                    }
                }
            }

            return found;
        }

        @Override
        public String toString() {
            String strGraph = "";
            Queue<Node> queue = new LinkedList<>();
            queue.add(this.head);

            List<Integer> visited = new ArrayList<>();
            visited.add(this.head.val);

            while(!queue.isEmpty()) {
                Node node = queue.poll();
                strGraph += node.val + " ";

                for(Node child : node.children) {
                    if(!visited.contains(child.val)) {
                        queue.add(child);
                        visited.add(child.val);
                    }
                }
            }

            strGraph += "\n";
            for(Edge edge : edges) {
                strGraph += edge.toString() + " ";
            }
            return strGraph;
        }

        private void log(String msg) {
            System.out.println(msg);
        }

    }

    public static void main(String[] args) {

        Node node4 = new Node(4);
        Node node9 = new Node(9);
        Node node7 = new Node(7);
        Node node5 = new Node(5);
        Node node2 = new Node(2);
        Node node8 = new Node(8);
        Node node3 = new Node(3);
        Node node6 = new Node(6);

        node4.addNode(node9);
        node4.addNode(node8);

        node9.addNode(node4);
        node9.addNode(node3);
        node9.addNode(node7);

        node7.addNode(node9);
        node7.addNode(node6);
        node7.addNode(node5);

        node5.addNode(node7);
        node5.addNode(node2);

        node2.addNode(node5);
        node2.addNode(node6);
        node2.addNode(node8);

        node8.addNode(node2);
        node8.addNode(node3);
        node8.addNode(node4);

        node3.addNode(node9);
        node3.addNode(node8);

        node6.addNode(node7);
        node6.addNode(node2);

        Graph graph = new Graph(node4);
        graph.addEdge(new Edge(1, new Pair(4, 9)));
        graph.addEdge(new Edge(3, new Pair(9, 7)));
        graph.addEdge(new Edge(5, new Pair(7, 5)));
        graph.addEdge(new Edge(4, new Pair(5, 2)));
        graph.addEdge(new Edge(2, new Pair(2, 8)));
        graph.addEdge(new Edge(6, new Pair(8, 4)));
        graph.addEdge(new Edge(7, new Pair(9, 3)));
        graph.addEdge(new Edge(9, new Pair(8, 3)));
        graph.addEdge(new Edge(8, new Pair(7, 6)));
        graph.addEdge(new Edge(10, new Pair(2, 6)));

        // Graph
        /**
         *            --- 1 --> (9) <---- 3 ----> (7) <--- 5 ----
         *           -           A                 A             -
         *          -            |                 |              -
         *         -             7                 8               -
         *        -              |                 |                -
         *      <-               V                 V                 ->
         *    (4)               (3)               (6)                 (5)
         *      <-               A                 A                 ->
         *        -              |                 |                -
         *         -             9                10               -
         *          -            |                 |              -
         *           -           V                 V             -
         *            --- 6 --> (8) <---- 2 ----> (2) <--- 4 ----
         */

        GraphDistance graphDist = new GraphDistance();
        graphDist.log("" + graph.toString());

        graphDist.log("dist=" + graph.findDist(2, 9));
        graphDist.log("dist=" + graph.findDist(4, 5));
        graphDist.log("dist=" + graph.findDist(3, 5));
        graphDist.log("dist=" + graph.findDist(6, 4));
        graphDist.log("dist=" + graph.findDist(7, 8));
        graphDist.log("dist=" + graph.findDist(2, 9));

        Node start = graph.find(2);
        start.dist = 0;
        start.path = "" + start.val;
        for(String path : graph.findAllPaths(start, 9, null)) {
            graphDist.log("path=" + path);
        }
    }

    private void log(String msg) {
        System.out.println(msg);
    }
    
}
