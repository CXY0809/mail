package com.cxy.template;

import com.cxy.template.elasticsearch.Book;
import com.cxy.template.elasticsearch.BookRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.CriteriaQuery;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @program: template
 * @description:
 * @author: cuixy
 * @create: 2019-08-14 16:38
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private ElasticsearchTemplate template;

    @Test
    public void save() {

        Book book = new Book();
        book.setId("123453");
        book.setName("Spring Data Redis");
        book.setPrice(69.0);
        book.setVersion(System.currentTimeMillis());
        this.bookRepository.save(book);
    }

//    @Test
//    public void update() {
//
//        Book book = new Book();
//        book.setId("123457");
//        book.setName("Spring Data Redis");
//        book.setVersion(System.currentTimeMillis());
//        this.bookRepository.save(book);
//    }
//
//    @Test
//    public void delete() {
//
//        this.bookRepository.deleteById("123458");
//    }
//
//    @Test
//    public void query() {
//        Page<Book> books = this.bookRepository.findAll(PageRequest.of(0, 2));
//
//        System.out.println("size:"+books.getSize()); // 结果集大小
//        System.out.println("totalPages:"+books.getTotalPages()); // 总页数
//        System.out.println("number:"+books.getNumber()); // 索引
//        System.out.println("totalElements:"+books.getTotalElements()); // 总记录数
//        System.out.println("numberOfElement:"+books.getNumberOfElements());
//
//        System.out.println(books.getContent());
//    }
//
//    @Test
//    public void query2() {
//        Criteria criteria = Criteria.where("id").is("123451");
//        List<Book> list = this.template.queryForList(new CriteriaQuery(criteria), Book.class);
//
//        System.out.println("id查询结果："+list);
//    }
}