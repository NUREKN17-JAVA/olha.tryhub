package ua.nure.kn.trigub.domain.db;

import java.sql.Connection;

public interface ConnectionFactory {

    Connection createConnection() throws DatabaseException;
}
