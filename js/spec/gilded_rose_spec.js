const { Item, update_quality } = require('../src/gilded_rose');

describe("Gilded Rose", function() {
  it("should degrade quality by 2 for Conjured items before sell date", function() {
    const items = [new Item("Conjured Mana Cake", 5, 10)];
    update_quality(items);
    expect(items[0].quality).toEqual(8);
  });
});
