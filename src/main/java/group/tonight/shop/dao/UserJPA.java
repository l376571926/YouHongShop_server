package group.tonight.shop.dao;

import group.tonight.shop.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.io.Serializable;

public interface UserJPA extends JpaRepository<User, Long>, JpaSpecificationExecutor<User>, Serializable {
    User findByUserName(String userName);
}
