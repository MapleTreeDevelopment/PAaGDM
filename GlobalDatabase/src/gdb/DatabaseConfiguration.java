package gdb;

import gdb.utilities.BinaryFileManager;
import org.apache.mina.core.buffer.IoBuffer;

public class DatabaseConfiguration {

    public static final String config_path = "./filestore/config";
    public static final String secrets_path = "./filestore/secrets";

    private final String host;
    private final String database;
    private final String username;
    private final String password;
    private final int port;

    public DatabaseConfiguration() {
        IoBuffer buffer = BinaryFileManager.getConfig();
        assert buffer != null;
        port = buffer.getInt();
        host = BinaryFileManager.getString(buffer);
        username = BinaryFileManager.getString(buffer);
        password = BinaryFileManager.getString(buffer);
        database = BinaryFileManager.getString(buffer);
    }

    public String getHost() {
        return host;
    }

    public String getDatabase() {
        return database;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getPort() {
        return port;
    }
}
