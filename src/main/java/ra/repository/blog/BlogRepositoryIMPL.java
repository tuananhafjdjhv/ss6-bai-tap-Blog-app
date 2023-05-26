package ra.repository.blog;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ra.model.Blog;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Transactional
public class BlogRepositoryIMPL implements IBlogRepository{
    @PersistenceContext
    private EntityManager em;
    @Override
    public List<Blog> findAll() {
        TypedQuery<Blog> query = em.createQuery("select c from Blog c", Blog.class);
        return query.getResultList();
    }

    @Override
    public Blog findById(int id) {
       return em.find(Blog.class,id);
    }

    @Override
    public void save(Blog blog) {
        if (blog != null){
            em.merge(blog);
        } else {
            em.persist(blog);
        }

    }

    @Override
    public void remove(int id) {
            em.remove(findById(id));
    }
}
