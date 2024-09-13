import files.models.ArrayProcessor;
import files.service.ArrayToFileFabric;
import files.service.CompareFilesFabric;
import files.service.CorporationFabric;
import files.service.LongestLineFinderFabric;

import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {

        CompareFilesFabric compareFilesFabric = new CompareFilesFabric();
        compareFilesFabric.runCompareFiles();

        LongestLineFinderFabric longestLineFinderFabric = new LongestLineFinderFabric();
        longestLineFinderFabric.runLongestLineFinder();

        ArrayProcessor arrayProcessor = new ArrayProcessor();
        arrayProcessor.run(arrayProcessor.inputFilename());

        ArrayToFileFabric arrayToFileFabric = new ArrayToFileFabric();
        arrayToFileFabric.ArrayToFile();

        CorporationFabric corporationFabric = new CorporationFabric();
        corporationFabric.createCorporation();

    }
}