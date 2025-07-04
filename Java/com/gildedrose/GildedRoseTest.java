package com.gildedrose;

public class GildedRoseTest {
    public static void main(String[] args) {
        testConjuredBeforeSellDate();
        testConjuredAfterSellDate();
    }

    private static void testConjuredBeforeSellDate() {
        Item[] items = new Item[] { new Item("Conjured Mana Cake", 5, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        if (items[0].quality == 8) {
            System.out.println("testConjuredBeforeSellDate passed");
        } else {
            System.out.println(" testConjuredBeforeSellDate failed: expected 8, got " + items[0].quality);
        }
    }

    private static void testConjuredAfterSellDate() {
        Item[] items = new Item[] { new Item("Conjured Mana Cake", 0, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        if (items[0].quality == 6) {
            System.out.println(" testConjuredAfterSellDate passed");
        } else {
            System.out.println(" testConjuredAfterSellDate failed: expected 6, got " + items[0].quality);
        }
    }
}
