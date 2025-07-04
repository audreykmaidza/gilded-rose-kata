# -*- coding: utf-8 -*-
import unittest

from gilded_rose import Item, GildedRose

class GildedRoseTest(unittest.TestCase):
    def test_foo(self):
        items = [Item("foo", 0, 0)]
        gilded_rose = GildedRose(items)
        gilded_rose.update_quality()
        self.assertEquals("fixme", items[0].name)

if __name__ == '__main__':
    unittest.main()


def test_conjured_items_degrade_twice_as_fast():
    from gilded_rose import Item, update_quality
    items = [Item("Conjured Mana Cake", 3, 6)]
    update_quality(items)
    assert items[0].quality == 4

def test_conjured_items_degrade_four_after_sellin():
    from gilded_rose import Item, update_quality
    items = [Item("Conjured Mana Cake", 0, 10)]
    update_quality(items)
    assert items[0].quality == 6
