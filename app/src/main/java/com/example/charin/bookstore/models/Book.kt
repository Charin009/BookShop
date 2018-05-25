package com.example.charin.bookstore.models

/**
 * Created by kaizofaria on 30/3/2018 AD.
 */
class Book(val id: Int,val title: String,val price: Double,val publicationYear: Int =0 ,val imageURL: String="") {

    override fun toString(): String {
        return "${title}, ${publicationYear} (${price})";
    }

}