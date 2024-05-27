package fi.tuni.prog3.junitorder;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Order {

    private List<Entry> entries;
    public Order() {
        this.entries = new ArrayList<>();
    }

    public boolean addItems(Item item, int count) throws
            IllegalArgumentException, IllegalStateException {
        if (count <= 0) {
            throw new IllegalArgumentException(
                    "Item unit count to add must be positive");
        }

        for (Entry entry : entries) {
            if (entry.getItem().getName().equals(item.getName())) {
                entry.incrementCount(count);
                return true;
            }
        }

        entries.add(new Entry(item, count));
        return true;
    }

    public boolean addItems(String name, int count) throws
            IllegalArgumentException, NoSuchElementException {
        if (count <= 0) {
            throw new IllegalArgumentException(
                    "Item unit count to add must be positive");
        }

        for (Entry entry : entries) {
            if (entry.getItem().getName().equals(name)) {
                entry.incrementCount(count);
                return true;
            }
        }

        throw new NoSuchElementException(
                "Order does not contain an entry with the specified item name");
    }

    public List<Entry> getEntries() {
        return new ArrayList<>(entries);
    }

    public int getEntryCount() {
        return entries.size();
    }

    public int getItemCount() {
        int totalCount = 0;
        for (Entry entry : entries) {
            totalCount += entry.getCount();
        }
        return totalCount;
    }

    public double getTotalPrice() {
        double totalPrice = 0.0;
        for (Entry entry : entries) {
            totalPrice += entry.getTotalPrice();
        }
        return totalPrice;
    }

    public boolean isEmpty() {
        return entries.isEmpty();
    }

    public boolean removeItems(String name, int count) throws
            IllegalArgumentException, NoSuchElementException {
        if (count <= 0) {
            throw new IllegalArgumentException(
                    "Item unit count to remove must be positive");
        }
        for (Entry entry : entries) {
            if (entry.getItem().getName().equals(name)) {

                entry.decrementCount(count);

                if (entry.getCount() == 0) {
                    entries.remove(entry);
                }

                return true;
            }
        }

        throw new NoSuchElementException(
                "Order does not contain an entry with the specified item name");
    }

    public static class Item {

        private String name;
        private double unitPrice;

        public Item(String name, double unitPrice) {
            this.name = name;
            this.unitPrice = unitPrice;
        }

        public String getName() {
            return name;
        }

        public double getUnitPrice() {
            return unitPrice;
        }
    }

    public static class Entry {

        private Item item;
        private int count;

        public Entry(Item item, int count) {
            this.item = item;
            this.count = count;
        }

        public Item getItem() {
            return item;
        }

        public int getCount() {
            return count;
        }

        public void incrementCount(int increment) {
            this.count += increment;
        }

        public void decrementCount(int decrement) throws
                IllegalArgumentException {
            if (decrement <= 0 || decrement > count) {
                throw new IllegalArgumentException(
                        "Invalid item unit count to remove");
            }
            this.count -= decrement;
        }

        public double getTotalPrice() {
            return count * item.getUnitPrice();
        }
    }
}
