package example.hello_security.repository;

import example.hello_security.model.Tweet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TweetRepository extends JpaRepository<Tweet, Long> {


}
