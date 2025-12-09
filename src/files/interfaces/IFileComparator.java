package files.interfaces;

import java.io.IOException;
import java.util.List;

public interface IFileComparator {
    List<String> compare(String filePath1, String filePath2) throws IOException;
    boolean areEqual(String filePath1, String filePath2) throws IOException;
}


