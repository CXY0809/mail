package com.cxy.template.elasticsearch;


import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface BookRepository extends ElasticsearchRepository<Book,String> {
}
