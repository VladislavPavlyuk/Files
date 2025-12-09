package files.services;

import files.interfaces.IFileReader;

import java.io.IOException;
import java.util.List;

public class LongestLineFinderService {
    private final IFileReader fileReader;

    public LongestLineFinderService(IFileReader fileReader) {
        this.fileReader = fileReader;
    }

    public static class LongestLineResult {
        private final String line;
        private final int length;

        public LongestLineResult(String line, int length) {
            this.line = line;
            this.length = length;
        }

        public String getLine() {
            return line;
        }

        public int getLength() {
            return length;
        }
    }

    public LongestLineResult findLongestLine(String filePath) throws IOException {
        List<String> lines = fileReader.readLines(filePath);
        
        String longestLine = "";
        int maxLength = 0;

        for (String line : lines) {
            if (line.length() > maxLength) {
                maxLength = line.length();
                longestLine = line;
            }
        }

        return new LongestLineResult(longestLine, maxLength);
    }
}


