package files.interfaces;

import java.io.IOException;
import java.util.List;

public interface IFileReader {
    List<String> readLines(String filePath) throws IOException;
    String readAll(String filePath) throws IOException;
}


