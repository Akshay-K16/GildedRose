package com.gildedrose

class GildedRose(val items: List<Item>) {
    fun updateQuality() {
        for (i in items.indices) {
            var qualityChange = 1
            if (items[i].sellIn <= 0) qualityChange *= 2
            if (items[i].name.length > 8 && items[i].name.substring(0, 8) == "Conjured") qualityChange *= 2

            if (items[i].name == "Aged Brie") {
                items[i].quality += qualityChange
            } else if (items[i].name == "Backstage passes to a TAFKAL80ETC concert") {
                when (items[i].sellIn) {
                    in Int.MIN_VALUE..0 -> items[i].quality = 0
                    in 1..5 -> items[i].quality += 3
                    in 6..10 -> items[i].quality += 2
                    else -> items[i].quality += 1
                }
            } else if (items[i].name == "Sulfuras, Hand of Ragnaros") {
                continue;
            } else {
                items[i].quality -= qualityChange
            }

            items[i].sellIn -= 1

            if (items[i].quality < 0) items[i].quality = 0
            if (items[i].quality > 50) items[i].quality = 50
        }
    }

}

