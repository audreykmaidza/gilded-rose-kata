
package com.gildedrose

class GildedRose(var items: Array[Item]) {
  def updateQuality(): Unit = {
    for (i <- items.indices) {
      val item = items(i)
      if (item.name != "Sulfuras, Hand of Ragnaros") {
        item.sellIn -= 1
      }

      item.name match {
        case "Aged Brie" =>
          item.quality += (if (item.sellIn < 0) 2 else 1)
        case "Backstage passes to a TAFKAL80ETC concert" =>
          if (item.sellIn < 0) {
            item.quality = 0
          } else if (item.sellIn < 5) {
            item.quality += 3
          } else if (item.sellIn < 10) {
            item.quality += 2
          } else {
            item.quality += 1
          }
        case name if name.startsWith("Conjured") =>
          item.quality -= (if (item.sellIn < 0) 4 else 2)
        case "Sulfuras, Hand of Ragnaros" =>
          // legendary item does not change
        case _ =>
          item.quality -= (if (item.sellIn < 0) 2 else 1)
      }

      if (item.quality < 0) item.quality = 0
      if (item.quality > 50 && item.name != "Sulfuras, Hand of Ragnaros") item.quality = 50
    }
  }
}
