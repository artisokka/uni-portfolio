package fi.tuni.prog3.junitorder;

import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author janik
 */
public class OrderTest {

    public OrderTest() {
    }

    @Test
    public void testAddItems() {
        Order order = new Order();
        Order.Item item = new Order.Item("item1", 10.0);

        assertTrue(order.addItems(item, 5));
        assertEquals(1, order.getEntryCount());
        assertEquals(5, order.getItemCount());
        assertEquals(50.0, order.getTotalPrice(), 0.001);

        // Adding more units of the same item
        assertTrue(order.addItems(item, 3));
        assertEquals(1, order.getEntryCount());
        assertEquals(8, order.getItemCount());
        assertEquals(80.0, order.getTotalPrice(), 0.001);
    }

    @Test
    public void testAddItemsByName() {

    }

    @Test
    public void testRemoveItems() {

    }

    @Test
    public void testExceptions() {
        Order order = new Order();
        Order.Item item = new Order.Item("item4", 25.0);

        // Invalid item count in addItems (expecting IllegalArgumentException)
        assertThrows(IllegalArgumentException.class, () -> order.
                addItems(item, 0));

        // Invalid item count in removeItems (expecting IllegalArgumentException)
        assertThrows(IllegalArgumentException.class, () -> order.removeItems(
                "item4", 0));

        // Adding an item with different price to an existing entry (expecting IllegalStateException)
        order.addItems(item, 5);
        Order.Item newItem = new Order.Item("item4", 30.0);
        assertThrows(IllegalStateException.class, () -> order.
                addItems(newItem, 3));
    }
}
