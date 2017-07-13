package de.firstProject.tokenFinder.service;

import org.easymock.EasyMock;
import org.easymock.EasyMockRunner;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Test;
import org.junit.runner.RunWith;

import de.firstProject.tokenFinder.db.entity.Users;
import de.firstProject.tokenFinder.db.repository.UserRepository;

@RunWith(EasyMockRunner.class)
public class UserServiceTest {

	@Mock
	private UserRepository userRepository;

	@TestSubject
	private final UserService userService = new UserService();

	@Test
	public void testGetUser() throws Exception {
		// Arrange
		EasyMock.expect(this.userRepository.save(EasyMock.anyObject())).andReturn(null);
		EasyMock.expect(this.userRepository.findAll()).andReturn(null);
		EasyMock.replay(this.userRepository);

		// Act
		Iterable<Users> user = this.userService.getUser();

		// Assert

	}

}
