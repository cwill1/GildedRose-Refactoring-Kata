package com.gildedrose;

import com.gildedrose.categories.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GildedRoseTest {
    @Test
    @DisplayName("should have correct sellIn and quality values after 1 day for Dexterity Vest")
    void shouldHaveCorrectValuesAfterOneDayForDexterity() {
        ReusableItem[] items = new ReusableItem[] { new Dexterity("Dexterity Vest", 10, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Dexterity Vest", app.items[0].name);
        assertEquals(9, app.items[0].sellIn);
        assertEquals(19, app.items[0].quality);
    }

    @Test
    @DisplayName("should have correct sellIn and quality values after 1 day for Aged Brie")
    void shouldHaveCorrectValuesAfterOneDayForAgedBrie() {
        ReusableItem[] items = new ReusableItem[] { new AgedBrie("Aged Brie", 2, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Aged Brie", app.items[0].name);
        assertEquals(1, app.items[0].sellIn);
        assertEquals(1, app.items[0].quality);
    }

    @Test
    @DisplayName("should have correct sellIn and quality values after 1 day for Elixir")
    void shouldHaveCorrectValuesAfterOneDayForElixir() {
        ReusableItem[] items = new ReusableItem[] { new Elixir("Elixir", 5, 7) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Elixir", app.items[0].name);
        assertEquals(4, app.items[0].sellIn);
        assertEquals(6, app.items[0].quality);
    }

    @Test
    @DisplayName("should have correct sellIn and quality values after 1 day for Sulfuras")
    void shouldHaveCorrectValuesAfterOneDayForSulfuras() {
        ReusableItem[] items = new ReusableItem[] { new Sulfuras("Sulfuras, Hand of Ragnaro", 0, 80) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Sulfuras, Hand of Ragnaro", app.items[0].name);
        assertEquals(0, app.items[0].sellIn);
        assertEquals(80, app.items[0].quality);
    }

    @Test
    @DisplayName("should have correct sellIn and quality values after 1 day for Backstage")
    void shouldHaveCorrectValuesAfterOneDayForBackstage() {
        ReusableItem[] items = new ReusableItem[] {
                new BackstagePasses("Backstage", 15, 20)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Backstage", app.items[0].name);
        assertEquals(14, app.items[0].sellIn);
        assertEquals(21, app.items[0].quality);
    }

    @Test
    @DisplayName("should have correct quality values for Backstage when there are less than 10, 5, or 0 days left")
    void shouldHaveCorrectQualityValuesAfterXDaysForBackstage() {
        ReusableItem[] items = new ReusableItem[] {
                new BackstagePasses("Backstage", 10, 20),
                new BackstagePasses("Backstage", 4, 20),
                new BackstagePasses("Backstage", 0, 20)
        };

        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Backstage", app.items[0].name);
        assertEquals(9, app.items[0].sellIn);
        assertEquals(22, app.items[0].quality);

        assertEquals(3, app.items[1].sellIn);
        assertEquals(23, app.items[1].quality);

        assertEquals(-1, app.items[2].sellIn);
        assertEquals(0, app.items[2].quality);
    }

    @Test
    @DisplayName("should have correct sellIn and quality values after 1 day for Conjured")
    void shouldHaveCorrectValuesAfterOneDayForConjured() {
        ReusableItem[] items = new ReusableItem[] { new Conjured("Conjured", 3, 6) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Conjured", app.items[0].name);
        assertEquals(2, app.items[0].sellIn);
        assertEquals(4, app.items[0].quality);
    }

    @Test
    @DisplayName("should have correct quality for any item after X days. " +
            "Quality should never exceed 50, except for Sulfuras")
    void shouldHaveQualityNeverExceedingFifty() {
        ReusableItem[] items = new ReusableItem[] {
                new AgedBrie("AgedBrie", 3, 6) ,
                new BackstagePasses("BackstagePasses", 70, 27) ,
                new Sulfuras("Sulfuras", 0, 80) ,

        };
        GildedRose app = new GildedRose(items);

        app.updateQuality(50);

        assertEquals("AgedBrie"
                , app.items[0].name);
        assertEquals(-47, app.items[0].sellIn);
        assertEquals(50, app.items[0].quality);

        assertEquals("BackstagePasses"
                , app.items[1].name);
        assertEquals(20, app.items[1].sellIn);
        assertEquals(50, app.items[1].quality);

        assertEquals("Sulfuras"
                , app.items[2].name);
        assertEquals(0, app.items[2].sellIn);
        assertEquals(80, app.items[2].quality);
    }

    @Test
    @DisplayName("should never have a negative quality for any item")
    void shouldNeverHaveANegativeQualityForAnyItem() {
        ReusableItem[] items = new ReusableItem[] {
                new AgedBrie("AgedBrie", 3, 6),
                new Conjured("Conjured", 3, 6),
                new Dexterity("Dexterity", 3, 6),
                new Sulfuras("Sulfuras", 0, 80),
                new Elixir("Elixir", 3, 6),
                new BackstagePasses("BackstagePasses", 3, 6)
        };

        GildedRose app = new GildedRose(items);
        app.updateQuality(50);

        assertEquals("AgedBrie"
                , app.items[0].name);
        assertTrue(app.items[0].quality >= 0);
        assertEquals(50, app.items[0].quality);

        assertEquals("Conjured"
                , app.items[1].name);
        assertTrue(app.items[1].quality >= 0);
        assertEquals(0, app.items[1].quality);

        assertEquals("Dexterity"
                , app.items[2].name);
        assertTrue(app.items[2].quality >= 0);
        assertEquals(0, app.items[2].quality);

        assertEquals("Sulfuras"
                , app.items[3].name);
        assertTrue(app.items[3].quality >= 0);
        assertEquals(80, app.items[3].quality);

        assertEquals("Elixir"
                , app.items[4].name);
        assertTrue(app.items[4].quality >= 0);
        assertEquals(0, app.items[4].quality);

        assertEquals("BackstagePasses"
                , app.items[5].name);
        assertTrue(app.items[5].quality >= 0);
        assertEquals(0, app.items[5].quality);
    }

    @Test
    @DisplayName("should degrade quality twice as fast if sell by date is passed")
    void shouldDegradeQualityTwiceAsFast() {
        ReusableItem[] items = new ReusableItem[] {
                new AgedBrie("AgedBrie", -1, 6),
                new Conjured("Conjured", -1, 6),
                new Dexterity("Dexterity", -1, 6),
                new Sulfuras("Sulfuras", -1, 80),
                new Elixir("Elixir", -1, 6),
                new BackstagePasses("BackstagePasses", 15, 6)
        };

        GildedRose app = new GildedRose(items);
        app.updateQuality(1);

        assertEquals("AgedBrie"
                , app.items[0].name);
        assertTrue(app.items[0].quality >= 0);
        assertEquals(7, app.items[0].quality);

        assertEquals("Conjured"
                , app.items[1].name);
        assertTrue(app.items[1].quality >= 0);
        assertEquals(4, app.items[1].quality);

        assertEquals("Dexterity"
                , app.items[2].name);
        assertTrue(app.items[2].quality >= 0);
        assertEquals(4, app.items[2].quality);

        assertEquals("Sulfuras"
                , app.items[3].name);
        assertTrue(app.items[3].quality >= 0);
        assertEquals(80, app.items[3].quality);

        assertEquals("Elixir"
                , app.items[4].name);
        assertTrue(app.items[4].quality >= 0);
        assertEquals(4, app.items[4].quality);

        assertEquals("BackstagePasses"
                , app.items[5].name);
        assertTrue(app.items[5].quality >= 0);
        assertEquals(7, app.items[5].quality);
    }
}
