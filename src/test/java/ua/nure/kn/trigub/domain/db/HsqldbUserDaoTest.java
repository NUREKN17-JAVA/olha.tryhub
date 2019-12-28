package ua.nure.kn.panasiuk.domain.db;


import java.util.Collection;
import java.util.Date;

import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;

import junit.framework.TestCase;
import ua.nure.kn.panasiuk.domain.User;


public class HsqldbUserDaoTest extends TestCase {
	
	private User user;
	private static final long TEST_ID = 1001L;
    private static final String FIRST_NAME = "Aleksandr";
    private static final String LAST_NAME = "Panasiuk";
	private static final Long ID = 4L;
	
	private UserDao userDao;
	protected IDatabaseConnection getConnection() throws Exception {
        return null;
    }

    
    protected IDataSet getDataSet() throws Exception {
        return null;
    }

   
    public void setUp() throws Exception {
       super.setUp();
       user = new User();
       user.setId(ID);
       user.setFirstName(FIRST_NAME);
       user.setLastName(LAST_NAME);
       user.setDateOfBirthd(new Date());
    }

 
    public void tearDown() throws Exception {
        super.tearDown();

    }

	public void testCreate() throws DatabaseException {
		User user = new User();
        user.setFirstName("Aleksandr");
        user.setLastName("Panasiuk");
        user.setFirstName(FIRST_NAME);
        user.setLastName(LAST_NAME);
        user.setDateOfBirthd(new Date());

        assertNull(user.getId());
        User userExpected = userDao.create(user);
        assertNotNull(userExpected);
        assertNotNull(userExpected.getId());
        assertEquals(userExpected.getFirstName(), user.getFirstName());
        assertEquals(userExpected.getLastName(), user.getLastName());
        assertEquals(userExpected.getDateOfBirthd(), user.getDateOfBirthd());
    }
    public void testFindAll() throws DatabaseException {
        int expectedUsersNumber = 2;
        Collection<User> users = userDao.findAll();
        assertNotNull("Collection is null", users);
        assertEquals("Collection size.", expectedUsersNumber, users.size());
    }

    public void testFind() {
        long id = TEST_ID;
        try {
            User user = userDao.find(id);

            assertNotNull(user);

            long userId = user.getId();
            assertEquals(id, userId);
        } catch (DatabaseException e) {
            fail(e.getMessage());
        }

    }

    public void testDelete() {
        User testUser = createUser();
        int expectedBeforeSize = 2;
        int expectedAfterSize = 1;
        try {
            int beforeSize = userDao.findAll().size();
            userDao.delete(testUser);
            int afterSize = userDao.findAll().size();

            assertEquals(expectedBeforeSize, beforeSize);
            assertEquals(expectedAfterSize, afterSize);
        } catch (DatabaseException e) {
            fail(e.getMessage());
        }
    }

    public void testUpdate() {
        User testUser = createUser();
        try {
            userDao.update(testUser);
            User updatedUser = userDao.find(TEST_ID);

            assertEquals(FIRST_NAME, updatedUser.getFirstName());
            assertEquals(LAST_NAME, updatedUser.getLastName());
        } catch (DatabaseException e) {
            fail(e.getMessage());
        }
    }

    private User createUser() {
        User user = new User();
        user.setId(TEST_ID);
        user.setFirstName(FIRST_NAME);
        user.setLastName(LAST_NAME);
        user.setDateOfBirthd(new Date());
        return user;
    }
}
