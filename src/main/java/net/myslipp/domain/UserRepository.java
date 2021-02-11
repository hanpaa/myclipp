package net.myslipp.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserId(String userId);
    // findBy{인자}(인자) 를 주면, userId를 기반으로 Id를 찾을 수 있다.
}
