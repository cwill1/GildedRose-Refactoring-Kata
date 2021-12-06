package com.gildedrose;

class GildedRose {
    ReusableItem[] items;

    public GildedRose(ReusableItem[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (ReusableItem item : items) {
            item.update();
        }
    }

    public void updateQuality(int days) {
        while(days > 0) {
            for (ReusableItem item : items) {
                item.update();
            }
            days -= 1;
        }
    }
}
