package ua.nure.trigub.usermanagement.db;

import java.sql.Connection;

public interface ConnectionFactory {
Connection createConnection() throws DatabaseException;

}
