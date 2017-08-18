package de.firstProject.tokenFinder.service;

import java.util.ArrayList;
import java.util.List;

import org.easymock.EasyMock;
import org.easymock.EasyMockRunner;
import org.easymock.EasyMockSupport;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import de.firstProject.tokenFinder.db.entity.Application;
import de.firstProject.tokenFinder.db.entity.Token;
import de.firstProject.tokenFinder.db.entity.User;
import de.firstProject.tokenFinder.db.repository.UserRepository;
import de.firstProject.tokenFinder.mapper.UserMapper;
import de.firstProject.tokenFinder.transfer.UserTo;

@RunWith(EasyMockRunner.class)
public class UserServiceTest extends EasyMockSupport {

	@Mock
	private UserRepository userRepository;

	@Mock
	private UserMapper userMapper;

	@TestSubject
	UserService userService = new UserService();

	@Test
	@Ignore
	public void testGetUser() throws Exception {
		// Arrange
		int version = 1;
		long userId = 1;
		long tokenId = 2;
		long appId = 3;
		String userName = "max";
		String content = "tokenContent";

		// application
		Application testApplication = new Application();
		String applicationName = "testAppName";
		testApplication.setApplicationName(applicationName);
		testApplication.setVersion(version);
		testApplication.setId(appId);
		// token
		Token testToken = new Token();
		testToken.setId(tokenId);
		testToken.setContent(content);
		testToken.setVersion(version);
		testToken.setApplication(testApplication);
		// user
		User testUser = new User();
		testUser.setId(userId);
		testUser.setUserName(userName);
		testUser.setVersion(version);
		testUser.addToken(testToken);

		UserTo userTo = new UserTo();

		EasyMock.expect(this.userMapper.mapUser(testUser)).andReturn(userTo);
		EasyMock.replay(this.userMapper);

		// Act
		UserTo userToResult = this.userMapper.mapUser(testUser);
		List<User> resultList = this.userService.getUsers(userToResult.getUserName());

	}

	@Test
	public void testGetUserCaseNoUserFound() throws Exception {
		// arrange
		String unknownUser = "notFound";
		List<User> emptyUserList = new ArrayList<>();

		EasyMock.expect(this.userRepository.findByUserName(unknownUser)).andReturn(emptyUserList);
		EasyMock.replay(this.userRepository);

		// act
		List<User> resultList = this.userService.getUsers(unknownUser);

		// assert
		Assert.assertThat(resultList.size(), Matchers.is(0));
	}

	@Test
	@Ignore
	public void testGetUserCaseUserFound() throws Exception {
		// arrange
		String userName = "userName";

		UserTo expecteduser = new UserTo();

		User singleUser = new User();
		List<User> userList = new ArrayList<>();
		userList.add(singleUser);

		EasyMock.expect(this.userRepository.findByUserName(userName)).andReturn(userList);
		EasyMock.expect(this.userMapper.mapUser(singleUser)).andReturn(expecteduser);
		this.replayAll();

		// act
		List<User> resultList = this.userService.getUsers(userName);

		// assert
		Assert.assertThat(resultList.size(), Matchers.is(1));
		Assert.assertThat(resultList.get(0), Matchers.is(expecteduser));
	}

	@Test
	@Ignore
	public void testSaveUser() throws Exception {
		// arrange
		String userName = "userName";
		User singleUser = new User();
		singleUser.setUserName(userName);

		EasyMock.expect(this.userRepository.save(singleUser));
		this.replayAll();
		// act
		this.userService.save(singleUser);

		// assert
		Assert.assertEquals(this.userRepository.findByUserName(userName).contains(singleUser), Matchers.is(true));
	}
}
