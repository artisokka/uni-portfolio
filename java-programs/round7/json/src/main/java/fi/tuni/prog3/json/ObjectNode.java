package fi.tuni.prog3.json;

import java.util.TreeMap;
import java.util.Iterator;

/**
 *
 * @author janik
 */
public class ObjectNode extends Node implements Iterable<String> {

    TreeMap<String, Node> nodes;

    public ObjectNode() {
        nodes = new TreeMap<>();
    }

    public Node get(String key) {
        if (nodes.get(key) == null) {
            return null;
        }
        return nodes.get(key);
    }
    public void set(String key, Node node) {
        nodes.put(key, node);
    }

    public int size() {
        return nodes.size();
    }

    @Override
    public Iterator<String> iterator() {
        return new ObjectNodeIterator();
    }

    private class ObjectNodeIterator implements Iterator<String> {

        private Iterator<String> keysIterator = nodes.keySet().iterator();

        @Override
        public boolean hasNext() {
            return keysIterator.hasNext();
        }

        @Override
        public String next() {
            return keysIterator.next();
        }
    }

}
