package reskillAssignmentOne;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
public class ItemTest {


    @Test
    public void getItemType(){

        Item testItem = new Item("Cosmetics",437.20, 263.33);
        assertEquals("Cosmetics", testItem.getType());

    }

    @Test
    public void testGetUnitPrice(){
        Item testItem = new Item("Cosmetics",437.20, 263.33);
        assertEquals(437.20, testItem.getUnitPrice(),0.01);
    }

    @Test
    public void testGetUnitCost(){
        Item testItem = new Item("Cosmetics",437.20, 263.33);
        assertEquals(263.33, testItem.getUnitCost(),0.01);
    }

    @Test
    public void getProfitPerItemType(){
        Item testItem = new Item("Cosmetics",437.20, 263.33);
        assertEquals(173.87, testItem.getProfitPerItemType(),0.01);
    }

    @Test
    public void checkToItemsEqual(){
        Item item1 = new Item("Vegetables", 150.3, 120.5);
        Item item2 = new Item("Vegetables", 150.3, 120.5);

        Assert.assertTrue(item1.equals(item2));
    }

    @Test
    public void checkToItems_notEqual(){
        Item item1 = new Item("Vegetables", 150.3, 120.5);
        Item item2 = new Item("Vegetables", 180.3, 120.5);
        Assert.assertFalse(item1.equals(item2));
    }

}