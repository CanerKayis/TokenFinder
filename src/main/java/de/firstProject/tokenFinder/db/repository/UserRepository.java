package de.firstProject.tokenFinder.db.repository;

import org.springframework.data.repository.CrudRepository;

import de.firstProject.tokenFinder.db.entity.Users;

public interface UserRepository extends CrudRepository<Users, Long> {

	// List<Token> findByUserName(String userName);
}
