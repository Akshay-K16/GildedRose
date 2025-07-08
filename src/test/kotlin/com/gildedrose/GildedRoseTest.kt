package com.gildedrose

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class GildedRoseTest {

    @Test
    fun testUpdatingLeavesNameUnchanged() {
        val items = listOf(Item("foo", 0, 0))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(items[0].name, app.items[0].name)
    }

    @Test
    fun testUpdatingDecreasesQualityIfUnexpired() {
        val items = listOf(Item("Elixir of the Mongoose", 10, 10))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(9, app.items[0].quality)
    }

    @Test
    fun testUpdatingDecreasesQualityIfExpired() {
        val items = listOf(Item("Elixir of the Mongoose", -5, 10))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(8, app.items[0].quality)
    }

    @Test
    fun testUpdatingDecreasesQualityIfBorderlineExpired() {
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
    fun testUpdatingBrieIncreasesQualityIfUnexpired() {
        val items = listOf(Item("Aged Brie", 10, 10))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(11, app.items[0].quality)
    }

    @Test
    fun testUpdatingBrieIncreasesQualityIfExpired() {
        val items = listOf(Item("Aged Brie", -5, 10))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(12, app.items[0].quality)
    }

    @Test
    fun testUpdatingBrieIncreasesQualityIfBorderlineExpired() {
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
    fun testUpdatingPassIncreasesQualityIfUnexpired() {
        val items = listOf(Item("Backstage passes to a TAFKAL80ETC concert", 20, 10))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(11, app.items[0].quality)
    }

    @Test
    fun testUpdatingPassIncreasesQualityWithTenDays() {
        val items = listOf(Item("Backstage passes to a TAFKAL80ETC concert", 10, 10))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(12, app.items[0].quality)
    }

    @Test
    fun testUpdatingPassIncreasesQualityWithEightDays() {
        val items = listOf(Item("Backstage passes to a TAFKAL80ETC concert", 8, 10))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(12, app.items[0].quality)
    }

    @Test
    fun testUpdatingPassIncreasesQualityWithFiveDays() {
        val items = listOf(Item("Backstage passes to a TAFKAL80ETC concert", 5, 10))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(13, app.items[0].quality)
    }

    @Test
    fun testUpdatingPassIncreasesQualityWithThreeDays() {
        val items = listOf(Item("Backstage passes to a TAFKAL80ETC concert", 3, 10))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(13, app.items[0].quality)
    }

    @Test
    fun testUpdatingPassIfExpired() {
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
    fun testUpdatingLeavesSulfurasQualityUnchangedIfUnexpired() {
        val items = listOf(Item("Sulfuras, Hand of Ragnaros", 10, 80))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(items[0].quality, app.items[0].quality)
    }

    @Test
    fun testUpdatingLeavesSulfurasSellInUnchangedIfUnexpired() {
        val items = listOf(Item("Sulfuras, Hand of Ragnaros", 10, 80))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(items[0].sellIn, app.items[0].sellIn)
    }

    @Test
    fun testUpdatingLeavesSulfurasQualityUnchangedIfExpired() {
        val items = listOf(Item("Sulfuras, Hand of Ragnaros", 0, 80))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(items[0].quality, app.items[0].quality)
    }

    @Test
    fun testUpdatingLeavesSulfurasSellInUnchangedIfExpired() {
        val items = listOf(Item("Sulfuras, Hand of Ragnaros", 0, 80))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(items[0].sellIn, app.items[0].sellIn)
    }

    @Test
    fun testUpdatingLeavesSulfurasQualityUnchangedIfBorderlineExpired() {
        val items = listOf(Item("Sulfuras, Hand of Ragnaros", -10, 80))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(items[0].quality, app.items[0].quality)
    }

    @Test
    fun testUpdatingLeavesSulfurasSellInUnchangedIfBorderlineExpired() {
        val items = listOf(Item("Sulfuras, Hand of Ragnaros", -10, 80))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(items[0].sellIn, app.items[0].sellIn)
    }

    @Test
    fun testUpdatingConjuredIfUnexpired() {
        val items = listOf(Item("Conjured Mana Cake", 10, 10))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(8, app.items[0].quality)
    }

    @Test
    fun testUpdatingConjuredIfBorderlineExpired() {
        val items = listOf(Item("Conjured Mana Cake", 0, 10))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(6, app.items[0].quality)
    }

    @Test
    fun testUpdatingConjuredIfExpired() {
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


