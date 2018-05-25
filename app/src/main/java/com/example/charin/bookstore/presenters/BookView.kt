package com.example.charin.bookstore.presenters

import com.example.charin.bookstore.models.Book

/**
 * Created by kaizofaria on 30/3/2018 AD.
 */
interface  BookView {
    fun setBookList(books: ArrayList<Book>)
}