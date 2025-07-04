require File.join(File.dirname(__FILE__), 'gilded_rose')

describe GildedRose do

  describe "#update_quality" do
    it "does not change the name" do
      items = [Item.new("foo", 0, 0)]
      GildedRose.new(items).update_quality()
      items[0].name.should == "fixme"
    end
  end

end

  it "lowers quality by 2 for conjured items before sell date" do
    items = [Item.new("Conjured Mana Cake", 5, 10)]
    GildedRose.new(items).update_quality
    expect(items[0].quality).to eq 8
  end

  it "lowers quality by 4 for conjured items after sell date" do
    items = [Item.new("Conjured Mana Cake", 0, 10)]
    GildedRose.new(items).update_quality
    expect(items[0].quality).to eq 6
  end

end
