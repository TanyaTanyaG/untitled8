package com.jdbc;

import java.sql.*;
import java.util.Properties;
import java.util.logging.Logger;

public class FabricMySQLDriver implements Driver {
    public Connection connect(String url, Properties info) {
        return null;
    }

    public boolean acceptsURL(String url) {
        return false;
    }

    public DriverPropertyInfo[] getPropertyInfo(String url, Properties info) {
        return new DriverPropertyInfo[0];
    }

    public int getMajorVersion() {
        return 0;
    }

    public int getMinorVersion() {
        return 0;
    }

    public boolean jdbcCompliant() {
        return false;
    }

    public Logger getParentLogger() {
        return null;
    }
}
