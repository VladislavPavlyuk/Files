package files.implementations;

import files.interfaces.IFileComparator;
import files.interfaces.IFileReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileComparatorImpl implements IFileComparator {
    private final IFileReader fileReader;

    public FileComparatorImpl(IFileReader fileReader) {
        this.fileReader = fileReader;
    }

    @Override
    public List<String> compare(String filePath1, String filePath2) throws IOException {
        List<String> differences = new ArrayList<>();
        List<String> lines1 = fileReader.readLines(filePath1);
        List<String> lines2 = fileReader.readLines(filePath2);

        int maxSize = Math.max(lines1.size(), lines2.size());
        for (int i = 0; i < maxSize; i++) {
            String line1 = i < lines1.size() ? lines1.get(i) : null;
            String line2 = i < lines2.size() ? lines2.get(i) : null;

            if (line1 == null || line2 == null || !line1.equals(line2)) {
                differences.add(String.format("Line %d: File1='%s', File2='%s'", 
                    i + 1, line1 != null ? line1 : "EOF", line2 != null ? line2 : "EOF"));
            }
        }
        return differences;
    }

    @Override
    public boolean areEqual(String filePath1, String filePath2) throws IOException {
        List<String> differences = compare(filePath1, filePath2);
        return differences.isEmpty();
    }
}


