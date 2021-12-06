package com.gildedrose.categories;
import com.gildedrose.ReusableItem;

public class Elixir extends ReusableItem {
    public Elixir(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void update(){
        this.updateQualityMultiplier();
        this.updateSellIn();
        this.updateQuality();
    }

    public void updateSellIn(){
        this.sellIn -= 1;
    }

    public void updateQuality(){
        if(this.isQuality()) {
            this.quality -= this.qualityMultiplier;
        }
    }
}
