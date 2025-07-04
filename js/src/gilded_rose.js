class Item {
  constructor(name, sell_in, quality) {
    this.name = name;
    this.sell_in = sell_in;
    this.quality = quality;
  }
}

const items = [];

function update_quality(items) {
  for (var i = 0; i < items.length; i++) {
    var item = items[i];

    if (item.name !== "Sulfuras, Hand of Ragnaros") {
      item.sell_in -= 1;
    }

    if (item.name === "Aged Brie") {
      item.quality += (item.sell_in < 0) ? 2 : 1;
    } else if (item.name === "Backstage passes to a TAFKAL80ETC concert") {
      if (item.sell_in < 0) {
        item.quality = 0;
      } else if (item.sell_in < 5) {
        item.quality += 3;
      } else if (item.sell_in < 10) {
        item.quality += 2;
      } else {
        item.quality += 1;
      }
    } else if (item.name.startsWith("Conjured")) {
      item.quality -= (item.sell_in < 0) ? 4 : 2;
    } else {
      item.quality -= (item.sell_in < 0) ? 2 : 1;
    }

    if (item.name !== "Sulfuras, Hand of Ragnaros") {
      if (item.quality < 0) item.quality = 0;
      if (item.quality > 50) item.quality = 50;
    }
  }
}


module.exports = {
  Item,
  update_quality,
  items
};
