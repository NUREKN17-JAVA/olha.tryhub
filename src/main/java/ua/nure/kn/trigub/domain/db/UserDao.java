package ua.nure.kn.trigub.domain.db;

import java.util.Collection;

import ua.nure.kn.trigub.domain.User;

public interface UserDao {
	
	User create(User user) throws DatabaseException;
	
	void update(User user) throws DatabaseException;

    void delete(User user) throws DatabaseException;

    User find(Long ID) throws DatabaseException;

    Collection <User> findAll() throws DatabaseException;

    void setConnectionFactory(ConnectionFactory connectionFactory);

    Collection<User> find(String firstName, String lastName) throws DatabaseException;

}
	
