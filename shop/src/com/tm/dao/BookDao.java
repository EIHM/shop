package com.tm.dao;

import java.util.LinkedHashMap;

import com.tm.domain.Book;

public interface BookDao {

	 public LinkedHashMap<Integer, Book> getAllBook();
}
