package testNGHelper;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.util.Date;

public class FileUtil {

    private static FileUtil instance;

    // 7 gün'ün milisaniye değeri = 604800000
    public final long distanceFromCreatedDate = 604800000;

    public static FileUtil getInstance() {

        if (instance == null) {
            createInstance();
        }

        return instance;
    }

    public static String convertImageToBase64(File imageFile) {
        String image = null;
        BufferedImage buffImage = null;
        try {
            buffImage = ImageIO.read(imageFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (buffImage != null) {
            java.io.ByteArrayOutputStream os = new
                    java.io.ByteArrayOutputStream();
            try {
                ImageIO.write(buffImage, "png", os);
            } catch (IOException e) {
                e.printStackTrace();
            }
            byte[] data = os.toByteArray();
            image = Base64.encodeBase64String(data);
        }
        return "data:image/png;base64," + image;
    }

    private static synchronized void createInstance() {
        if (instance == null) {
            instance = new FileUtil();
        }
    }

    public void createDirectory(File dir) {
        if (!dir.exists()) {
            dir.mkdirs();
        }
    }

    public void copyFile(File srcFile, File destFile) throws IOException {
        FileUtils.copyFile(srcFile, destFile);
    }

    public void writeDatasInLogFile(String root, String datas, String tokenId) {
        PrintWriter pWriter = null;
        File file = new File(root + ".log");

        try {
            String Log = FileUtils.readFileToString(file);

            pWriter = new PrintWriter(root + ".log");
            datas = "Kullanilan veriler: -" + datas;

            for (int i = 0; i < datas.split("-").length; i++) {

                pWriter.println(datas.split("-")[i]);
            }
            pWriter.println("");
            pWriter.println("Log: ");
            pWriter.println(Log);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (pWriter != null)
                pWriter.close();
        }
    }

    public void deleteFileListing(File file) {
        File[] directoryListing = file.listFiles();
        if (directoryListing != null) {
            for (File child : directoryListing) {
                try {
                    deleteOlderFile(child, distanceFromCreatedDate);
                    if (child.isDirectory()) {
                        deleteFileListing(child);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void deleteOlderFile(File file, Long time) {
        try {
            Path path = file.toPath();
            BasicFileAttributes attributes = Files.readAttributes(path, BasicFileAttributes.class);
            FileTime creationTime = attributes.creationTime();

            long epoch = creationTime.toMillis();
            Date currentTime = new Date();
            // System.out.println("Dosyanin oluşturulma zamani : " +
            // creationTime);
            // System.out.println("Epoch Time : " + epoch);
            // System.out.println("Time : " + time);
            // System.out.println("CurrentTime : " + currentTime.getTime()) ;
            // System.out.println("Zaman farki :" +
            // (currentTime.getTime()-epoch));
            if (time <= (currentTime.getTime() - epoch)) {
                if (file.isDirectory()) {
                    FileUtils.deleteDirectory(new File(file.getCanonicalPath()));
                } else if (file.isFile()) {
                    file.delete();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteDirectory(File path) {
        if (path.exists()) {
            File[] files = path.listFiles();
            for (int i = 5; i <= files.length; i++) {
                if (files[i].isDirectory()) {
                    deleteDirectory(files[i]);
                } else {
                    files[i].delete();
                }
            }
        }
        path.delete();
    }
}
