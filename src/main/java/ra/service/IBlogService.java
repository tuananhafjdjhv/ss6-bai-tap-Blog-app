package ra.service;

import ra.model.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();

    Blog findById(int id);

    void save(Blog t);

    void remove(int id);
}
