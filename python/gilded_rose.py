
class Item:
    def __init__(self, name, sell_in, quality):
        self.name = name
        self.sell_in = sell_in
        self.quality = quality

    def __repr__(self):
        return "%s, %s, %s" % (self.name, self.sell_in, self.quality)


def update_quality(items):
    for item in items:
        if item.name == "Sulfuras, Hand of Ragnaros":
            continue

        item.sell_in -= 1

        degrade = 1
        if item.name.startswith("Conjured"):
            degrade = 2

        if item.name == "Aged Brie":
            if item.quality < 50:
                item.quality += 2 if item.sell_in < 0 else 1
                item.quality = min(50, item.quality)
        elif item.name == "Backstage passes to a TAFKAL80ETC concert":
            if item.sell_in < 0:
                item.quality = 0
            elif item.sell_in < 5:
                item.quality = min(item.quality + 3, 50)
            elif item.sell_in < 10:
                item.quality = min(item.quality + 2, 50)
            else:
                item.quality = min(item.quality + 1, 50)
        else:
            if item.sell_in < 0:
                degrade *= 2
            item.quality = max(0, item.quality - degrade)
