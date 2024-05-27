package fi.tuni.prog3.json;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author janik
 */
public class ArrayNode extends Node implements Iterable<Node> {
    private ArrayList<Node> nodes;

    public ArrayNode() {
        nodes = new ArrayList<>();
    }

    public void add(Node node) {
        nodes.add(node);
    }

    public int size() {
        return nodes.size();
    }

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
