package com.gildedrose

class GildedRose(val items: List<Item>) {
    fun updateQuality() {
        for (item in items) {

            when (item.name) {
                "Aged Brie" -> item.quality += if (item.sellIn <= 0) 2 else 1
                "Backstage passes to a TAFKAL80ETC concert" -> {
                    when (item.sellIn) {
                        in Int.MIN_VALUE..0 -> item.quality = 0
                        in 1..5 -> item.quality += 3
                        in 6..10 -> item.quality += 2
                        else -> item.quality += 1
                    }
                }
                "Sulfuras, Hand of Ragnaros" -> continue
                else -> {
                    val multiplier = if (item.name.length > 8 && item.name.startsWith("Conjured"))  2 else 1
                    item.quality -= if (item.sellIn <= 0) 2*multiplier else multiplier
                }
            }

            item.sellIn -= 1

            if (item.quality < 0) item.quality = 0
            if (item.quality > 50) item.quality = 50
        }
    }

}

