package fi.tuni.prog3.json;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * A class for representing a JSON array.
 */
public class ArrayNode extends Node implements Iterable<Node> {
    private ArrayList<Node> nodes;

    /**
     * Constructs an initially empty JSON array node.
     *
     */
    public ArrayNode() {
        nodes = new ArrayList<>();
    }

    /**
     * Returns the number of JSON nodes stored in this JSON array.
     *
     * @return the number of JSON nodes in this JSON array.
     */
    public int size() {
        return nodes.size();
    }
    /**
     * Adds a new JSON node to the end of this JSON array.
     *
     * @param node the new JSON node to be added.
     *
     */


    public void add(Node node) {
        nodes.add(node);
    }

    /**
     * Returns a Node iterator that iterates the JSON nodes stored in this JSON
     * array.
     *
     * @return a Node iterator that iterates the JSON nodes stored in this JSON
     * array.
     */
    @Override
    public Iterator<Node> iterator() {
        return new NodeIterator();
    }



    private class NodeIterator implements Iterator<Node> {

        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < nodes.size();
        }

        @Override
        public Node next() {
            if (!hasNext()) {
                throw new IllegalStateException("No more elements to iterate");
            }
            Node node = nodes.get(currentIndex);
            currentIndex++;
            return node;
        }
    }

}
