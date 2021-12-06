package com.gildedrose.categories;

import com.gildedrose.ReusableItem;

public class BackstagePasses extends ReusableItem {
    public BackstagePasses(String name, int sellIn, int quality) {
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
            if(this.sellIn <= 5 && this.sellIn > 0){
                this.quality += 3;
            }
            else if(this.sellIn <= 10 && this.sellIn > 5){
                this.quality += 2;
            }
            else if(this.sellIn <= 0){
                this.quality = 0;
            }
            else {
                this.quality += 1;
            }
        }
    }
}
