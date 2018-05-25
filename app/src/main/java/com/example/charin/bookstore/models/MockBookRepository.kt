package com.example.charin.bookstore.models

import java.util.ArrayList

/**
 * Created by kaizofaria on 30/3/2018 AD.
 */

class MockBookRepository : BookRepository() {
    val bookList = ArrayList<Book>()

    override fun loadAllBooks() {
        bookList.clear()
        bookList.add(Book(1,"How to win BNK election",500.0,2018))
        bookList.add(Book(2,"Kotlin is hard",199.0,2018))
        bookList.add(Book(3,"Wanna Sleep?",39.99,2018))
        setChanged()
        notifyObservers()
    }

    override fun searchBooks(keyword: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getBooks(): ArrayList<Book> {
        return bookList
    }

}