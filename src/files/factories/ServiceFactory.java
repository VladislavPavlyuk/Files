package files.factories;

import files.implementations.*;
import files.interfaces.*;
import files.services.*;

import java.util.Scanner;

public class ServiceFactory {
    private static final Scanner scanner = new Scanner(System.in);

    public static IFileReader createFileReader() {
        return new FileReaderImpl();
    }

    public static IFileWriter createFileWriter() {
        return new FileWriterImpl();
    }

    public static IInputReader createInputReader() {
        return new ConsoleInputReader(scanner);
    }

    public static IArrayStatistics createArrayStatistics() {
        return new ArrayStatisticsCalculator();
    }

    public static IFileComparator createFileComparator() {
        return new FileComparatorImpl(createFileReader());
    }

    public static IEmployeeRepository createEmployeeRepository() {
        return new EmployeeRepository();
    }

    public static IEmployeeStorage createEmployeeStorage(String fileName) {
        return new EmployeeFileStorage(fileName);
    }

    public static EmployeeService createEmployeeService(String fileName) {
        IEmployeeRepository repository = createEmployeeRepository();
        IEmployeeStorage storage = createEmployeeStorage(fileName);
        IInputReader inputReader = createInputReader();
        return new EmployeeService(repository, storage, inputReader);
    }

    public static ArrayProcessorService createArrayProcessorService() {
        return new ArrayProcessorService(
            createFileReader(),
            createArrayStatistics(),
            createInputReader()
        );
    }

    public static ArrayToFileService createArrayToFileService() {
        return new ArrayToFileService(
            createFileWriter(),
            createInputReader()
        );
    }

    public static LongestLineFinderService createLongestLineFinderService() {
        return new LongestLineFinderService(createFileReader());
    }

    public static FileComparisonService createFileComparisonService() {
        return new FileComparisonService(createFileComparator());
    }
}


