package gdb.utilities.tools;

import gdb.utilities.BinaryFileManager;
import org.apache.mina.core.buffer.IoBuffer;

import java.io.*;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class GDBConfigCreator {

    private static final String config_path = "./filestore/utils_out/config.gdb";
    private static final String secrets_path = "./filestore/utils_out/secrets.gdb";

    public static void main(String[] args) {
        createConfig();
    }

    private static void createConfig() {
        try {
            OutputStream os = new GZIPOutputStream(new FileOutputStream(config_path));
            IoBuffer buf = IoBuffer.allocate(1024);
            buf.setAutoExpand(true);
            buf.putInt(3306);//Port
            BinaryFileManager.putString(buf, "");//host
            BinaryFileManager.putString(buf, "");//user
            BinaryFileManager.putString(buf, "");//password
            BinaryFileManager.putString(buf, "");//database
            BinaryFileManager.putString(buf, "");//auth table
            BinaryFileManager.putString(buf, "");//gd table
            buf.flip();
            byte[] data = new byte[buf.limit()];
            buf.get(data);
            os.write(data);
            os.flush();
            os.close();
            System.out.println("Configuration file created. Now test reading...");
            readConfig();
        } catch (IOException ex) {
            ex.fillInStackTrace();
        }
    }

    private static void readConfig() {
        try {
            File f = new File(config_path);
            InputStream is = new GZIPInputStream(new FileInputStream(f));
            IoBuffer buf = IoBuffer.allocate(1024);
            buf.setAutoExpand(true);
            while (true) {
                byte[] temp = new byte[1024];
                int read = is.read(temp, 0, temp.length);
                if (read == -1) {
                    break;
                } else {
                    buf.put(temp, 0, read);
                }
            }
            buf.flip();
            int port = buf.getInt();
            String host = BinaryFileManager.getString(buf);
            String user = BinaryFileManager.getString(buf);
            String password = BinaryFileManager.getString(buf);
            String database = BinaryFileManager.getString(buf);
            System.out.println("Test reading of the config file:");
            System.out.println("Port: " + port);
            System.out.println("host: " + host);
            System.out.println("user: " + user);
            System.out.println("password: " + password);
        } catch (IOException ex) {
        }
    }

}
