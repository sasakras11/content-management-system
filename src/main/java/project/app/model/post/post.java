package project.app.model.post;

import org.springframework.context.annotation.Bean;
import project.app.model.user.User;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "post")
public class post implements Serializable {

    private static final long serialVersionUID = -5118896781683996473L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "postid")
    private int id;


    @Column(name = "topic")
    private String topic;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private int price;

    @ManyToOne
    @JoinColumn(name = "usersid",nullable = false)
   private User user;


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public int getPrice() { return price; }

    public void setPrice(int price) { this.price = price; }
}
