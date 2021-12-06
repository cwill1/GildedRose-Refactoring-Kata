package com.gildedrose;


public class ReusableItem {

    public String name;

    public int sellIn;

    public int quality;

    public int qualityMultiplier = 1;

    public ReusableItem(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public void update(){
        this.updateQualityMultiplier();
    }

    public void updateQualityMultiplier(){
        if(this.sellIn < 0){
            this.qualityMultiplier *= 2;
        }
    }

    public boolean isQuality(){
        return this.quality > 0;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}
