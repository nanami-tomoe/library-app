package com.group.libraryapp.Repository.book;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
public class BookMySqlRepository implements BookRepository {
    @Override
    public void saveBook() {
        System.out.println("MySqlRepository");
    }
}
