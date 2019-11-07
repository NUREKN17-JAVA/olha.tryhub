package ua.nure.trigub.usermanagement.db;

import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

import org.dbunit.DatabaseTestCase;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.XmlDataSet;

import junit.framework.TestCase;

import ua.nure.trigub.usermanagement.User;
import ua.nure.trigub.usermanagement.db.HsqldbUserDao;

public class HsqldbUserDaoTest extends DatabaseTestCase {
	private HsqldbUserDao dao;
	private ConnectionFactory connectionFactory;
	 private static final String LAST_NAME = "Tryhub";
	  private static final String FIRST_NAME = "Olha";
	  private static final int DAY_OF_BIRTH = 19;
	  private static final int MONTH = 6;
	  private static final int YEAR = 2000;
	  private static final long ID = 1L;
	  private HsqldbUserDao hsqldbUserDao;
	  private User user;

	protected void setUp() throws Exception {
		super.setUp();
		dao = new HsqldbUserDao(connectionFactory);

        user = new User();
        user.setId(ID);
        user.setFirstName(FIRST_NAME);
        user.setLastName(LAST_NAME);
        user.setDateOfBirth(new Date());

        hsqldbUserDao = new HsqldbUserDao(connectionFactory);
	}

	public void testCreate() {
		try {
			User user = new User();
			user.setFirstName(FIRST_NAME);
			user.setLastName(LAST_NAME);
			Calendar calendar = Calendar.getInstance(); 
		    calendar.set(YEAR, MONTH, DAY_OF_BIRTH);
		    user.setDateOfBirth(calendar.getTime());
			assertNull(user.getId());
			user = dao.create(user);
			assertNotNull(user);
			assertNotNull(user.getId());
		} catch (DatabaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail(e.toString());
		}
	}
	public void testFindAll() {
		try {
			Collection collection = dao.findAll();
			assertNotNull("Collections is null", collection);
			assertEquals("Collections size.", 2, collection.size());
		} catch (DatabaseException e) { 
			e.printStackTrace();
			fail(e.toString());
		}
	}
	
	   public void testUpdate() throws DatabaseException {
		     User testUser = user;
		       hsqldbUserDao.create(user); 
		       testUser.setFirstName("Olia");
		       hsqldbUserDao.update(testUser);
		       User updatedUser = hsqldbUserDao.find(testUser.getId());
		       assertNotNull(updatedUser);
		       assertEquals(testUser.getFirstName(), updatedUser.getFirstName());
		       assertEquals(testUser.getLastName(), updatedUser.getLastName());
		   }

		   public void testDelete() throws DatabaseException {
		        User deletedUser = hsqldbUserDao.create(user);
		        hsqldbUserDao.delete(deletedUser);
		          assertNull(hsqldbUserDao.find(deletedUser.getId()));
		   }
		   
		  public void testFind() throws DatabaseException {
		        assertNotNull(user.getId());
		          User ethalonUser = hsqldbUserDao.create(user);
		          User findedUser = hsqldbUserDao.find(ethalonUser.getId());

		          assertNotNull(findedUser);
		          assertEquals(ethalonUser.getId(), findedUser.getId());
		          assertEquals(ethalonUser.getFirstName(), findedUser.getFirstName());
		          assertEquals(ethalonUser.getLastName(), findedUser.getLastName());
		          }
		  
	protected IDatabaseConnection getConnection() throws Exception {
	    connectionFactory = new ConnectionFactoryImpl( "org.hsqldb.jdbcDriver",  "jdbc:hsqldb:file:db/usermanagement", "sa", "");
	    return new DatabaseConnection(connectionFactory.createConnection());
	  }

	@Override
	protected IDataSet getDataSet() throws Exception {
		IDataSet dataSet = new XmlDataSet(getClass().getClassLoader()
				.getResourceAsStream("usersDataSet.xml"));
		return dataSet ;
	}

}
