package com.barancinar.quiz2

class CollectionStateRepository {
    fun getItems():ArrayList<CollectionStateModel> {
        val items = ArrayList<CollectionStateModel>()

        items.add(CollectionStateModel(1, R.drawable.state, R.string.degisim_text))
        items.add(CollectionStateModel(2, R.drawable.state, R.string.degismeyen_text))
        items.add(CollectionStateModel(3, R.drawable.state, R.string.gizli_text))
        items.add(CollectionStateModel(4, R.drawable.state, R.string.devam_text))
        items.add(CollectionStateModel(5, R.drawable.state, R.string.kayip_text))

        return items
    }
}