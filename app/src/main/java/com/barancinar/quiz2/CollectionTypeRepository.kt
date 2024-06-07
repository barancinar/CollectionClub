package com.barancinar.quiz2

class CollectionTypeRepository {
    fun getItems(): ArrayList<CollectionTypeModel> {
        val items = ArrayList<CollectionTypeModel>()

        items.add(CollectionTypeModel(1, R.drawable.kartpostal, R.string.kartpostal_text))
        items.add(CollectionTypeModel(2, R.drawable.pul, R.string.pul_text))
        items.add(CollectionTypeModel(3, R.drawable.oyun, R.string.oyun_text))
        items.add(CollectionTypeModel(4, R.drawable.kapak, R.string.kapak_text))
        items.add(CollectionTypeModel(5, R.drawable.kalem, R.string.kalem_text))

        return items
    }
}