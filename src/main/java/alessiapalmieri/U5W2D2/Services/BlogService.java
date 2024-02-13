package alessiapalmieri.U5W2D2.Services;

import alessiapalmieri.U5W2D2.Entities.BlogPost;
import alessiapalmieri.U5W2D2.Exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

@Service
public class BlogService {
    private List<BlogPost> blogPosts = new ArrayList<>();

    public BlogPost save(BlogPost body) {
        Random rndm = new Random();
        body.setId(rndm.nextLong(1, 100000));
        this.blogPosts.add(body);
        return body;
    }

    public List<BlogPost> getBlogPosts() {
        return this.blogPosts;
    }

    public BlogPost findById(long id) throws NotFoundException {
        BlogPost u = null;
        for (BlogPost blogPost : this.blogPosts) {
            if (blogPost.getId() == id) {
                u = blogPost;
            }
        }
        if (u == null) {
            throw new NotFoundException(id);
        } else {
            return u;
        }
    }

    public void findByIdAndDelete(long id) {
        ListIterator<BlogPost> iterator = this.blogPosts.listIterator();

        while (iterator.hasNext()) {
            BlogPost current = iterator.next();
            if (current.getId() == id) {
                iterator.remove();
            }
        }
    }

    public BlogPost findByIdAndUpdate(long id, BlogPost body) throws NotFoundException {
        BlogPost found = null;

        for (BlogPost author : this.blogPosts) {
            if (author.getId() == id) {
                found = author;
                found.setId(id);
                found.setTitle(body.getTitle());
                found.setCategory(body.getCategory());
                found.setContent(body.getContent());
                found.setCover(body.getCover());
                found.setReadingTime(body.getReadingTime());
            }
        }
        if (found == null) {
            throw new NotFoundException(id);
        } else {
            return found;
        }
    }
}
