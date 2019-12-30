package app.service;

import java.sql.Blob;
import javax.sql.rowset.serial.SerialException;
import javax.sql.rowset.serial.SerialBlob;
import java.io.IOException;
import java.sql.SQLException;
import org.springframework.web.multipart.MultipartFile;

public class Converter {
  public Converter(){

  }

  public static Blob convertMultipartFileToBlob(MultipartFile file) throws IOException, SerialException, SQLException {
    return (new SerialBlob(file.getBytes()));
  }
}
