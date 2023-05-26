package ra.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import ra.model.Blog;
import ra.repository.blog.IBlogRepository;

import java.util.List;

@Service
public class BlogService implements IBlogService{
    @Autowired
    private IBlogRepository blogRepository;
    @Override
    public List<Blog> findAll() {
       return blogRepository.findAll();
    }

    @Override
    public Blog findById(int id) {
        return blogRepository.findById(id);
    }

    @Override
    public void save(Blog t) {
        blogRepository.save(t);
    }

    @Override
    public void remove(int id) {
        blogRepository.remove(id);
    }
}
