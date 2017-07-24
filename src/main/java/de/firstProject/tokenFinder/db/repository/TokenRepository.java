package de.firstProject.tokenFinder.db.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import de.firstProject.tokenFinder.db.entity.Token;

public interface TokenRepository extends CrudRepository<Token, Long> {

	List<Token> findById(String userName);
}
