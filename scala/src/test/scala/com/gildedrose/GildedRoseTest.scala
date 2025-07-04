package com.gildedrose

import org.scalatest._

class GildedRoseTest  extends FlatSpec with Matchers {
      it should "foo" in {
        var items = Array[Item](new Item("foo", 0, 0))
        val app = new GildedRose(items)
        app.updateQuality()
        (app.items(0).name) should equal ("fixme")
      }
}

  test("Conjured items degrade by 2 before sell date") {
    val items = Array(new Item("Conjured Mana Cake", 5, 10))
    val app = new GildedRose(items)
    app.updateQuality()
    assert(items(0).quality == 8)
  }

  test("Conjured items degrade by 4 after sell date") {
    val items = Array(new Item("Conjured Mana Cake", 0, 10))
    val app = new GildedRose(items)
    app.updateQuality()
    assert(items(0).quality == 6)
  }

