package ua.nure.kn.trigubs.domain.db;

import java.sql.Connection;

public interface ConnectionFactory {

    Connection createConnection() throws DatabaseException;
}
