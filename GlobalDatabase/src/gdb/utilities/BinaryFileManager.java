package gdb.utilities;

import gdb.DatabaseConfiguration;
import org.apache.mina.core.buffer.IoBuffer;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.zip.GZIPInputStream;

public class BinaryFileManager {

    public static IoBuffer getConfig() {
        try {
            File f = new File(DatabaseConfiguration.config_path);
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
            return buf;
        } catch (Exception e) {
            return null;
        }
    }

    public static void putString(IoBuffer buf, String string) {
        for (final char c : string.toCharArray()) {
            buf.put((byte) c);
        }
        buf.put((byte) 0);
    }

    public static String getString(IoBuffer buf) {
        final StringBuilder bldr = new StringBuilder();
        byte b;
        while (buf.hasRemaining() && (b = buf.get()) != 0) {
            bldr.append((char) b);
        }
        return bldr.toString();
    }

}
