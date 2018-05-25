package com.example.charin.bookstore.presenters

import com.example.charin.bookstore.models.Book
import com.example.charin.bookstore.models.BookRepository
import java.util.*

/**
 * Created by kaizofaria on 30/3/2018 AD.
 */
class BookPresenter(val view: BookView,vararg val repository: BookRepository): Observer {
    var currentSort = 0
    var book = ArrayList<Book>()
    var filtered = ArrayList<Book>()
    var isFiltered = false

    fun start() {
        for (i in 0..repository.size - 1) {
            repository[i].addObserver(this)
            repository[i].loadAllBooks()
        }
    }


    override fun update(obj: Observable?, arg: Any?) {
        if (repository.contains(obj)) {
            book.addAll((obj as BookRepository).getBooks())
        }
        updateBookList(book)
    }

    fun updateBookList(books: ArrayList<Book>) {
        view.setBookList(books)
    }

    fun search(keyword: String) {
        if (keyword == null || keyword.trim().equals("")) {
            updateBookList(book)
            isFiltered = false
            return
        }
        var temp = ArrayList<Book>()
        try {
            var parsedKeyword = Integer.parseInt(keyword)
            for (book in book) {
                if (book.publicationYear == parsedKeyword) {
                    temp.add(book)
                }
            }
        } catch (e: RuntimeException) {
        }
        for (book in book) {
            if (book.title.toLowerCase().contains(keyword.toLowerCase())) {
                temp.add(book)
            }
        }
        filtered = temp
        isFiltered = true
        updateBookList(sortBookInList(currentSort))
    }

    fun sortBookInList(sortMode: Int): ArrayList<Book>{
        var temp = ArrayList<Book>()
        if (isFiltered) {
            temp.addAll(filtered)
        } else {
            temp.addAll(book)
        }
        when (sortMode) {
            0 -> {
                currentSort = 0
            }
            1 -> {
                temp.sortWith(compareBy(String.CASE_INSENSITIVE_ORDER, { it.title }))
                currentSort = 1
            }
            2 -> {
                temp.sortWith(compareBy(Book::publicationYear))
                currentSort = 2
            }
            3 -> {
                temp.sortWith(compareByDescending(String.CASE_INSENSITIVE_ORDER, { it.title }))
                currentSort = 3
            }
            4 -> {
                temp.sortWith(compareByDescending(Book::publicationYear))
                currentSort = 4
            }
        }
        return temp
    }
}