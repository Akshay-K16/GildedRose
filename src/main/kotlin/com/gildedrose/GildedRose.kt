package com.gildedrose

class GildedRose(val items: List<Item>) {
    fun updateQuality() {
        items.forEach{ item ->
            val updatableItem = when (item.name) {
                "Aged Brie" -> AgedItem(item)
                "Backstage passes to a TAFKAL80ETC concert" -> TicketItem(item)
                "Sulfuras, Hand of Ragnaros" -> SulfurasItem(item)
                else -> {
                    when {
                        item.name.startsWith("Conjured") -> ConjuredItem(item)
                        else -> NormalItem(item)
                    }
                }
            }
            updatableItem.update()
        }
    }

}

