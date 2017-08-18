package de.firstProject.tokenFinder.db.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import de.firstProject.tokenFinder.db.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

	List<User> findByuserName(String userName);

}
