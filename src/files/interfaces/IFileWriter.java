package files.interfaces;

import java.io.IOException;
import java.util.List;

public interface IFileWriter {
    void writeLines(String filePath, List<String> lines) throws IOException;
    void write(String filePath, String content) throws IOException;
}


