package de.firstProject.tokenFinder.db.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import de.firstProject.tokenFinder.db.entity.Token;

@Repository
public interface TokenRepository extends CrudRepository<Token, Long> {

}
