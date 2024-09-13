import files.models.ArrayProcessor;
import files.service.CompareFilesFabric;
import files.service.LongestLineFinderFabric;


public class Main {
    public static void main(String[] args) {
/*
        CompareFilesFabric compareFilesFabric = new CompareFilesFabric();
        compareFilesFabric.runCompareFiles();

        LongestLineFinderFabric longestLineFinderFabric = new LongestLineFinderFabric();
        longestLineFinderFabric.runLongestLineFinder();
*/
        ArrayProcessor arrayProcessor = new ArrayProcessor();
        arrayProcessor.run(arrayProcessor.inputFilename());

    }
}