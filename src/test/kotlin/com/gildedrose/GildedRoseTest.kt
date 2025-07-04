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
    fun testUpdateDecreasesQualityIfUnexpired() {
        val items = listOf(Item("Elixir of the Mongoose", 10, 10))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(9, app.items[0].quality)
    }

    @Test
    fun testUpdateDecreasesQualityIfExpired() {
        val items = listOf(Item("Elixir of the Mongoose", -5, 10))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(8, app.items[0].quality)
    }

    @Test
    fun testUpdateDecreasesQualityIfBorderlineExpired() {
        val items = listOf(Item("Elixir of the Mongoose", 0, 10))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(8, app.items[0].quality)
    }

    @Test
    fun testQualityNeverNegativeIfUnexpired() {
        val items = listOf(Item("Elixir of the Mongoose", 10, 0))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(0, app.items[0].quality)
    }

    @Test
    fun testQualityNeverNegativeIfExpired() {
        val items = listOf(Item("Elixir of the Mongoose", -5, 1))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(0, app.items[0].quality)
    }

    @Test
    fun testUpdateBrieIncreasesQualityIfUnexpired() {
        val items = listOf(Item("Aged Brie", 10, 10))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(11, app.items[0].quality)
    }

    @Test
    fun testUpdateBrieIncreasesQualityIfExpired() {
        val items = listOf(Item("Aged Brie", -5, 10))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(12, app.items[0].quality)
    }

    @Test
    fun testUpdateBrieIncreasesQualityIfBorderlineExpired() {
        val items = listOf(Item("Aged Brie", 0, 10))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(12, app.items[0].quality)
    }

    @Test
    fun testBrieQualityNeverExceedsFiftyIfUnexpired() {
        val items = listOf(Item("Aged Brie", 10, 50))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(50, app.items[0].quality)
    }

    @Test
    fun testBrieQualityNeverExceedsFiftyIfExpired() {
        val items = listOf(Item("Aged Brie", -5, 49))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(50, app.items[0].quality)
    }

    @Test
    fun testUpdatePassIncreasesQualityIfUnexpired() {
        val items = listOf(Item("Backstage passes to a TAFKAL80ETC concert", 20, 10))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(11, app.items[0].quality)
    }

    @Test
    fun testUpdatePassIncreasesQualityWithTenDays() {
        val items = listOf(Item("Backstage passes to a TAFKAL80ETC concert", 10, 10))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(12, app.items[0].quality)
    }

    @Test
    fun testUpdatePassIncreasesQualityWithEightDays() {
        val items = listOf(Item("Backstage passes to a TAFKAL80ETC concert", 8, 10))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(12, app.items[0].quality)
    }

    @Test
    fun testUpdatePassIncreasesQualityWithFiveDays() {
        val items = listOf(Item("Backstage passes to a TAFKAL80ETC concert", 5, 10))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(13, app.items[0].quality)
    }

    @Test
    fun testUpdatePassIncreasesQualityWithThreeDays() {
        val items = listOf(Item("Backstage passes to a TAFKAL80ETC concert", 3, 10))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(13, app.items[0].quality)
    }

    @Test
    fun testUpdatePassIfExpired() {
        val items = listOf(Item("Backstage passes to a TAFKAL80ETC concert", 0, 10))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(0, app.items[0].quality)
    }

    @Test
    fun testPassQualityNeverExceedsFiftyIfUnexpired() {
        val items = listOf(Item("Backstage passes to a TAFKAL80ETC concert", 20, 50))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(50, app.items[0].quality)
    }

    @Test
    fun testPassQualityNeverExceedsFiftyWithTenDays() {
        val items = listOf(Item("Backstage passes to a TAFKAL80ETC concert", 10, 49))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(50, app.items[0].quality)
    }

    @Test
    fun testPassQualityNeverExceedsFiftyWithFiveDays() {
        val items = listOf(Item("Backstage passes to a TAFKAL80ETC concert", 5, 48))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(50, app.items[0].quality)
    }

    @Test
    fun testUpdateLeavesSulfurasQualityUnchangedIfUnexpired() {
        val items = listOf(Item("Sulfuras, Hand of Ragnaros", 10, 80))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(items[0].quality, app.items[0].quality)
    }

    @Test
    fun testUpdateLeavesSulfurasSellInUnchangedIfUnexpired() {
        val items = listOf(Item("Sulfuras, Hand of Ragnaros", 10, 80))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(items[0].sellIn, app.items[0].sellIn)
    }

    @Test
    fun testUpdateLeavesSulfurasQualityUnchangedIfExpired() {
        val items = listOf(Item("Sulfuras, Hand of Ragnaros", 0, 80))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(items[0].quality, app.items[0].quality)
    }

    @Test
    fun testUpdateLeavesSulfurasSellInUnchangedIfExpired() {
        val items = listOf(Item("Sulfuras, Hand of Ragnaros", 0, 80))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(items[0].sellIn, app.items[0].sellIn)
    }

    @Test
    fun testUpdateLeavesSulfurasQualityUnchangedIfBorderlineExpired() {
        val items = listOf(Item("Sulfuras, Hand of Ragnaros", -10, 80))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(items[0].quality, app.items[0].quality)
    }

    @Test
    fun testUpdateLeavesSulfurasSellInUnchangedIfBorderlineExpired() {
        val items = listOf(Item("Sulfuras, Hand of Ragnaros", -10, 80))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(items[0].sellIn, app.items[0].sellIn)
    }

    @Test
    fun testUpdateConjuredIfUnexpired() {
        val items = listOf(Item("Conjured Mana Cake", 10, 10))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(8, app.items[0].quality)
    }

    @Test
    fun testUpdateConjuredIfBorderlineExpired() {
        val items = listOf(Item("Conjured Mana Cake", 0, 10))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(6, app.items[0].quality)
    }

    @Test
    fun testUpdateConjuredIfExpired() {
        val items = listOf(Item("Conjured Mana Cake", -5, 10))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(6, app.items[0].quality)
    }

    @Test
    fun testConjuredQualityNeverNegativeIfUnexpired() {
        val items = listOf(Item("Conjured Mana Cake", 10, 1))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(0, app.items[0].quality)
    }

    @Test
    fun testConjuredQualityNeverNegativeIfExpired() {
        val items = listOf(Item("Conjured Mana Cake", 0, 3))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(0, app.items[0].quality)
    }

}


