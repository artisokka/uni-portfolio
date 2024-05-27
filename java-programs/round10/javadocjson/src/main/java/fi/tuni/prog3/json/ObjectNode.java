package fi.tuni.prog3.json;

import java.util.TreeMap;
import java.util.Iterator;

/**
 * A class for representing a JSON object.
 *
 */
public class ObjectNode extends Node implements Iterable<String> {

    TreeMap<String, Node> nodes;

    /**
     * Constructs an initially empty JSON object node.
     */
    public ObjectNode() {
        nodes = new TreeMap<>();
    }

    /**
     *
     * Returns the number of JSON nodes stored under this JSON object.
     *
     * @return the number of JSON nodes under this JSON object.
     */
    public int size() {
        return nodes.size();
    }

    /**
     * Returns the JSON node stored under the given name.
     *
     * @param name the name of the name-node pair whose node should be returned.
     * @return the JSON node corresponding to name, or null if such node does
     * not exist.
     */

    public Node get(String name) {
        if (nodes.get(name) == null) {
            return null;
        }
        return nodes.get(name);
    }

    /**
     * Stores a name - JSON node pair into this JSON object. If a name-node pair
     * with the same name already exists, the previously existing node will be
     * replaced.
     *
     * @param name the name of the name-node pair.
     * @param node the JSON node of the name-node pair.
     */
    public void set(String name, Node node) {
        nodes.put(name, node);
    }

    /**
     * Returns a String iterator that iterates the names of the name-node pairs
     * stored in this JSON object in natural String order.
     *
     * @return a String iterator that iterates the names of the stored name-node
     * pairs in natural String order.
     */
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
