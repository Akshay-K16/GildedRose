package com.gildedrose

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class GildedRoseTest {

    @Test
    fun testUpdateLeavesNameUnchanged() {
        val items = listOf(Item("foo", 0, 0))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(items[0].name, app.items[0].name)
    }

    @Test
    fun testUpdateDecreasesQualityNormal() {
        val items = listOf(Item("Elixir of the Mongoose", 10, 10))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(9, app.items[0].quality)
    }

    @Test
    fun testUpdateDecreasesQualityExpired() {
        val items = listOf(Item("Elixir of the Mongoose", -5, 10))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(8, app.items[0].quality)
    }

    @Test
    fun testUpdateDecreasesQualityBorderlineExpired() {
        val items = listOf(Item("Elixir of the Mongoose", 0, 10))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(8, app.items[0].quality)
    }

    @Test
    fun testQualityNeverNegativeNormal() {
        val items = listOf(Item("Elixir of the Mongoose", 10, 0))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(0, app.items[0].quality)
    }

    @Test
    fun testQualityNeverNegativeExpired() {
        val items = listOf(Item("Elixir of the Mongoose", -5, 1))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(0, app.items[0].quality)
    }

    @Test
    fun testUpdateBrieIncreasesQualityNormal() {
        val items = listOf(Item("Aged Brie", 10, 10))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(11, app.items[0].quality)
    }

    @Test
    fun testUpdateBrieIncreasesQualityExpired() {
        val items = listOf(Item("Aged Brie", -5, 10))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(12, app.items[0].quality)
    }

    @Test
    fun testUpdateBrieIncreasesQualityBorderlineExpired() {
        val items = listOf(Item("Aged Brie", 0, 10))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(12, app.items[0].quality)
    }

    @Test
    fun testBrieQualityNeverExceedsFiftyNormal() {
        val items = listOf(Item("Aged Brie", 10, 50))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(50, app.items[0].quality)
    }

    @Test
    fun testBrieQualityNeverExceedsFiftyExpired() {
        val items = listOf(Item("Aged Brie", -5, 49))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(50, app.items[0].quality)
    }

    @Test
    fun testUpdatePassIncreasesQualityNormal() {
        val items = listOf(Item("Backstage passes to a TAFKAL80ETC concert", 20, 10))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(11, app.items[0].quality)
    }

    @Test
    fun testUpdatePassIncreasesQualityTenDays() {
        val items = listOf(Item("Backstage passes to a TAFKAL80ETC concert", 10, 10))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(12, app.items[0].quality)
    }

    @Test
    fun testUpdatePassIncreasesQualityEightDays() {
        val items = listOf(Item("Backstage passes to a TAFKAL80ETC concert", 8, 10))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(12, app.items[0].quality)
    }

    @Test
    fun testUpdatePassIncreasesQualityFiveDays() {
        val items = listOf(Item("Backstage passes to a TAFKAL80ETC concert", 5, 10))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(13, app.items[0].quality)
    }

    @Test
    fun testUpdatePassIncreasesQualityThreeDays() {
        val items = listOf(Item("Backstage passes to a TAFKAL80ETC concert", 3, 10))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(13, app.items[0].quality)
    }

    @Test
    fun testUpdatePassExpired() {
        val items = listOf(Item("Backstage passes to a TAFKAL80ETC concert", 0, 10))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(0, app.items[0].quality)
    }

    @Test
    fun testPassQualityNeverExceedsFiftyNormal() {
        val items = listOf(Item("Backstage passes to a TAFKAL80ETC concert", 20, 50))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(50, app.items[0].quality)
    }

    @Test
    fun testPassQualityNeverExceedsFiftyTenDays() {
        val items = listOf(Item("Backstage passes to a TAFKAL80ETC concert", 10, 49))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(50, app.items[0].quality)
    }

    @Test
    fun testPassQualityNeverExceedsFiftyFiveDays() {
        val items = listOf(Item("Backstage passes to a TAFKAL80ETC concert", 5, 48))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(50, app.items[0].quality)
    }

    @Test
    fun testUpdateLeavesSulfurasUnchangedNormal() {
        val items = listOf(Item("Sulfuras, Hand of Ragnaros", 10, 80))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(items[0].name, app.items[0].name)
        assertEquals(items[0].quality, app.items[0].quality)
        assertEquals(items[0].sellIn, app.items[0].sellIn)
    }

    @Test
    fun testUpdateLeavesSulfurasUnchangedExpired() {
        val items = listOf(Item("Sulfuras, Hand of Ragnaros", 0, 80))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(items[0].name, app.items[0].name)
        assertEquals(items[0].quality, app.items[0].quality)
        assertEquals(items[0].sellIn, app.items[0].sellIn)
    }

    @Test
    fun testUpdateLeavesSulfurasUnchangedBorderlineExpired() {
        val items = listOf(Item("Sulfuras, Hand of Ragnaros", -10, 80))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(items[0].name, app.items[0].name)
        assertEquals(items[0].quality, app.items[0].quality)
        assertEquals(items[0].sellIn, app.items[0].sellIn)
    }

    @Test
    fun testUpdateConjuredNormal() {
        val items = listOf(Item("Conjured Mana Cake", 10, 10))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(8, app.items[0].quality)
    }

    @Test
    fun testUpdateConjuredBorderlineExpired() {
        val items = listOf(Item("Conjured Mana Cake", 0, 10))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(6, app.items[0].quality)
    }

    @Test
    fun testUpdateConjuredExpired() {
        val items = listOf(Item("Conjured Mana Cake", -5, 10))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(6, app.items[0].quality)
    }

    @Test
    fun testConjuredQualityNeverNegativeNormal() {
        val items = listOf(Item("Conjured Mana Cake", 10, 1))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(0, app.items[0].quality)
    }

    @Test
    fun testConjuredQualityNeverNegativeExpired() {
        val items = listOf(Item("Conjured Mana Cake", 0, 3))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(0, app.items[0].quality)
    }

}


