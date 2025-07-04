
package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            Item item = items[i];

            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                item.sellIn = item.sellIn - 1;
            }

            if (item.name.equals("Aged Brie")) {
                item.quality += (item.sellIn < 0) ? 2 : 1;
            } else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (item.sellIn < 0) {
                    item.quality = 0;
                } else if (item.sellIn < 5) {
                    item.quality += 3;
                } else if (item.sellIn < 10) {
                    item.quality += 2;
                } else {
                    item.quality += 1;
                }
            } else if (item.name.startsWith("Conjured")) {
                item.quality -= (item.sellIn < 0) ? 4 : 2;
            } else if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                item.quality -= (item.sellIn < 0) ? 2 : 1;
            }

            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                if (item.quality < 0) item.quality = 0;
                if (item.quality > 50) item.quality = 50;
            }
        }
    }
}
