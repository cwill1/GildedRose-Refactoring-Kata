package com.gildedrose.categories;

import com.gildedrose.ReusableItem;

public class AgedBrie extends ReusableItem {
    public AgedBrie(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void update(){
        this.updateSellIn();
        this.updateQuality();
    }

    public void updateSellIn(){
        this.sellIn -= 1;
    }

    public void updateQuality(){
        if(this.quality < 50){
            this.quality += this.qualityMultiplier;
        }
    }
}
