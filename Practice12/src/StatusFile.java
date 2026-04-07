import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;

public class StatusFile {
    public static void updateStatus(Path file, int index, byte status) throws IOException {
        try (RandomAccessFile raf = new RandomAccessFile(file.toFile(), "rw");
             FileChannel channel = raf.getChannel()) {

             ByteBuffer writeBuffer = ByteBuffer.allocate(1);
             writeBuffer.put(status);
             writeBuffer.flip();

             channel.write(writeBuffer, index);
            ByteBuffer readBuffer = ByteBuffer.allocate(1);


            channel.read(readBuffer, index);


            readBuffer.flip();

            byte readStatus = readBuffer.get();

            System.out.println("Updating index: " + index + "...");
            System.out.println("Writing status: " + status);
            System.out.println("Reading status: " + readStatus);

            if (status == readStatus) {
                System.out.println("Success! The same bit");
            }
        }
    }
}