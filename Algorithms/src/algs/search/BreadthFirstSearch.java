package algs.search;

import algs.datastructures.Queue;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

/**
 * @author Robert Mitchell <robert.mitchell36@gmail.com>
 */
public class BreadthFirstSearch {

    /** A Breadth-First Search traverses a graph by first considering all the neighbors of one node before considering
     * the neighbors of any one neighbor of that node.
     * The graph searched in this implementation is accessed entirely through the children and isTarget functions: it
     * can be a normal graph, and children can simply return the neighbors member of each Node, or it can be a more
     * hypothetical graph, perhaps too large for memory, and children can generate the new Nodes as requested.
     *
     * @param source The node to begin searching from.
     * @param children A Function which given a Node will return a List of Nodes that are its neighbors in the graph.
     * @param isTarget A Function which will return true if the Node given as an argument is the target in the search.
     * @param <Node> The data-type of which the search graph consists.
     * @return Either the first Node in the graph which makes isTarget return true, or null if none are encountered.
     */
    public static <Node> Node search(Node source, Function<Node, List<Node>> children, Function<Node, Boolean> isTarget) {
        Set<Node> visited = new HashSet<>(); // TODO: Implement a Set interface and HashSet class.
        Queue<Node> toVisit = Queue.newInstance();
        toVisit.enqueue(source);

        while (toVisit.size() > 0) {
            final Node node = toVisit.dequeue();
            if (isTarget.apply(node)) {
                return node;
            }
            visited.add(node);
            for (final Node child : children.apply(node)) {
                // Do not consider nodes we have already visited.
                if (!visited.contains(child)) {
                    toVisit.enqueue(child);
                }
            }
        }

        // If the children function eventually stops producing new values, and the target is never found, return null.
        return null;
    }
}
