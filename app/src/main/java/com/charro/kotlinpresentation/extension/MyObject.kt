package com.charro.kotlinpresentation.extension

internal data class MyObject(val title: String, val subject: String, val id: Int)
{
    companion object NewsAgency
    {
        val news = mutableListOf<MyObject>()

        fun makeNews(title: String, subject: String, id: Int): MyObject
        {
            val car = MyObject(title, subject, id)
            news.add(car)
            return car
        }
    }
}

