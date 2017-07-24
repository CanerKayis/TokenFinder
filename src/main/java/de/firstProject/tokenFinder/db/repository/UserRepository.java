package de.firstProject.tokenFinder.db.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

import de.firstProject.tokenFinder.db.entity.Users;

public interface UserRepository extends CrudRepository<Users, Long> {

	Users findByUserName(String userName);

	@Autowired
	@Override
	Users save(Users persisted);

}
