require File.join(File.dirname(__FILE__), 'gilded_rose')
require 'test/unit'

class TestUntitled < Test::Unit::TestCase

  def test_foo
    items = [Item.new("foo", 0, 0)]
    GildedRose.new(items).update_quality()
    assert_equal items[0].name, "fixme"
  end

end

  def test_conjured_item_quality_degrades_twice_as_fast
    items = [Item.new("Conjured Mana Cake", 5, 10)]
    GildedRose.new(items).update_quality
    assert_equal 8, items[0].quality
  end

  def test_conjured_item_quality_degrades_four_after_sell_by
    items = [Item.new("Conjured Mana Cake", 0, 10)]
    GildedRose.new(items).update_quality
    assert_equal 6, items[0].quality
  end

end
