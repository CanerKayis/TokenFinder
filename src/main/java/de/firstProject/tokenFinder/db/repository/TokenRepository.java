package de.firstProject.tokenFinder.db.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import de.firstProject.tokenFinder.db.entity.Token;

public interface TokenRepository extends CrudRepository<Token, Long> {

	@Override
	Optional<Token> findById(Long id);

	@Override
	Token save(Token persisted);
}
