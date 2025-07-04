
class Item
  attr_accessor :name, :sell_in, :quality

  def initialize(name, sell_in, quality)
    @name = name
    @sell_in = sell_in
    @quality = quality
  end

  def to_s()
    "#{@name}, #{@sell_in}, #{@quality}"
  end
end

class GildedRose
  def initialize(items)
    @items = items
  end

  def update_quality()
    @items.each do |item|
      next if item.name == "Sulfuras, Hand of Ragnaros"

      item.sell_in -= 1
      degrade = item.name.start_with?("Conjured") ? 2 : 1

      if item.name == "Aged Brie"
        item.quality += item.sell_in < 0 ? 2 : 1
        item.quality = 50 if item.quality > 50
      elsif item.name == "Backstage passes to a TAFKAL80ETC concert"
        if item.sell_in < 0
          item.quality = 0
        elsif item.sell_in < 5
          item.quality += 3
        elsif item.sell_in < 10
          item.quality += 2
        else
          item.quality += 1
        end
        item.quality = 50 if item.quality > 50
      else
        degrade *= 2 if item.sell_in < 0
        item.quality -= degrade
        item.quality = 0 if item.quality < 0
      end
    end
  end
end
