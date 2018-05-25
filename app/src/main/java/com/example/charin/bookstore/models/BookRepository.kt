package com.example.charin.bookstore.models

import java.util.*
import kotlin.collections.ArrayList

/**
 * Created by kaizofaria on 30/3/2018 AD.
 */

abstract class BookRepository : Observable() {
    abstract fun loadAllBooks()
    abstract fun getBooks(): ArrayList<Book>
    abstract fun searchBooks(keyword: String)
}