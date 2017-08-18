package de.firstProject.tokenFinder.mapper;

import org.easymock.EasyMock;
import org.easymock.EasyMockRunner;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import de.firstProject.tokenFinder.db.entity.Token;
import de.firstProject.tokenFinder.db.entity.User;
import de.firstProject.tokenFinder.transfer.TokenTo;
import de.firstProject.tokenFinder.transfer.UserTo;

@RunWith(EasyMockRunner.class)
public class UserMapperTest {

	@Mock
	private final TokenMapper tokenMapper = new TokenMapper();

	@TestSubject
	private final UserMapper userMapper = new UserMapper();

	@Test
			public void testMapUserToUserUserToWithoutToken() throws Exception {
				// ARRANGE
				UserTo user = new UserTo();
				user.setUserName("testUser");
				user.setVersion(2);
		
				// ACT
				User result = this.userMapper.mapUserTo(user);
		
				// ASSERT
				Assert.assertThat(result.getUserName(), Matchers.is("testUser"));
				Assert.assertThat(result.getVersion(), Matchers.is(2));
		
			}

	@Test
			public void testMapUserToUserUserWithoutToken() throws Exception {
				// Arrange
				User user = new User();
				user.setUserName("Hans");
				user.setVersion(5);
		
				// act
				UserTo result = this.userMapper.mapUser(user);
		
				// assert
		
				Assert.assertThat(result.getUserName(), Matchers.is("Hans"));
				Assert.assertThat(result.getVersion(), Matchers.is(5));
				Assert.assertThat(result.getTokens().size(), Matchers.is(0));
		
			}

	@Test
			public void testMapUserToUserUserWithToken() {
				// ARRANGE
				int expectedVersion = 5;
				String expectedUserName = "Hans";
		
				User user = new User();
				user.setUserName(expectedUserName);
				user.setVersion(expectedVersion);
				Token token = new Token();
				token.setContent("tokenContent");
				user.addToken(token);
		
				TokenTo tokenTo = new TokenTo();
				EasyMock.expect(this.tokenMapper.map(token)).andReturn(tokenTo);
				EasyMock.replay(this.tokenMapper);
		
				// ACT
				UserTo result = this.userMapper.mapUser(user);
		
				// ASSERT
				Assert.assertThat(result.getUserName(), Matchers.is(expectedUserName));
				Assert.assertThat(result.getVersion(), Matchers.is(expectedVersion));
				Assert.assertThat(result.getTokens().get(0), Matchers.is(tokenTo));
				EasyMock.verify(this.tokenMapper);
		
			}

}
