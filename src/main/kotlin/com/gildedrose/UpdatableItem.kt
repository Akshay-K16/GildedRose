package com.gildedrose

abstract class UpdatableItem(val item: Item) {
    abstract fun update()

    fun checkBounds() {
        if (item.quality < 0) item.quality = 0
        if (item.quality > 50) item.quality = 50
    }
}

class NormalItem(item: Item) : UpdatableItem(item) {
    override fun update() {
        item.quality -= if (item.sellIn <= 0) 2 else 1
        item.sellIn -= 1

        checkBounds()
    }
}

class ConjuredItem(item: Item) : UpdatableItem(item) {
    override fun update() {
        item.quality -= if (item.sellIn <= 0) 4 else 2
        item.sellIn -= 1

        checkBounds()
    }
}

class AgedItem(item: Item) : UpdatableItem(item) {
    override fun update() {
        item.quality += if (item.sellIn <= 0) 2 else 1
        item.sellIn -= 1

        checkBounds()
    }
}

class TicketItem(item: Item) : UpdatableItem(item) {
    override fun update() {
        when (item.sellIn) {
            in Int.MIN_VALUE..0 -> item.quality = 0
            in 1..5 -> item.quality += 3
            in 6..10 -> item.quality += 2
            else -> item.quality += 1
        }
        item.sellIn -= 1

        checkBounds()
    }
}

class SulfurasItem(item: Item) : UpdatableItem(item) {
    override fun update() {
    }
}
