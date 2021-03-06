package com.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookService {
    @Autowired
    BookDao bookDao;

    @Transactional
    public void checkout(String username,String isbn){
        bookDao.updateStock(isbn);
        int price=bookDao.getPrice(isbn);
        bookDao.updateBalance(username,price);
        //int i=1/0;
    }
}
