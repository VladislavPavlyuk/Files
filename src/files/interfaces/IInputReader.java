package files.interfaces;

public interface IInputReader {
    String readLine(String prompt);
    String readLineWithDefault(String prompt, String defaultValue);
    int readInt(String prompt);
    double readDouble(String prompt);
}


