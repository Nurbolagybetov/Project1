package org.example.connectionPostgres;

import java.sql.Connection;

public interface IPostgresDB {
    Connection getConnection();
}
