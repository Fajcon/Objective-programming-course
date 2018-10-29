package foto;
import io.indico.Indico;
import io.indico.api.results.IndicoResult;
import io.indico.api.utils.IndicoException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.*;
import java.util.stream.Stream;

public class FotoMain {
    public static void Recognition(String Image, Indico indico, IndicoResult single) throws IOException, IndicoException, DirectorCreationException {
        String resultString = null;
        double resultDouble = 0;
        Path pathToDst = null;
        Path pathToSrc = null;
        single = indico.imageRecognition.predict(
                Image
        );

        Map<String, Double> result = single.getImageRecognition();

        for (Map.Entry<String, Double> entry : result.entrySet()) {
            if (resultDouble < entry.getValue()) {
                resultString = entry.getKey();
                resultDouble = entry.getValue();
            }
        }
        if (!new File("/home/ficon/java/cw5/zdjecia_posegregowane/" + resultString.replaceAll("\\s+", "_")).exists()) {
            boolean success = (new File("/home/ficon/java/cw5/zdjecia_posegregowane/" + resultString.replaceAll("\\s+", "_"))).mkdirs();
            if (!success) {
                throw new DirectorCreationException();
            }
        }
        pathToSrc = Paths.get(Image);
        pathToDst = Paths.get("/home/ficon/java/cw5/zdjecia_posegregowane/" + resultString.replaceAll("\\s+", "_") + "/" + Image.substring(Image.lastIndexOf("/") + 1));

        Files.copy(pathToSrc, pathToDst, StandardCopyOption.REPLACE_EXISTING);
    }

    public static void readAndWrite(String pathString) throws NoDirException, IOException, IndicoException {
        // single example
        Indico indico = new Indico("244988bf56524ea8d00258263a1dcb35");
        IndicoResult single = null;

        File testDir = new File(pathString);
        if (!testDir.isDirectory()) throw new NoDirException();

        Stream<Path> paths = Files.walk(Paths.get(pathString));
        paths
                .filter((p) -> (p.toString().endsWith(".jpg")))
                .forEach((p) -> {
                    try {
                        Recognition(p.toString(), indico, single);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (IndicoException e) {
                        e.printStackTrace();
                        //throw new WrongAPIKeyException();
                    } catch (DirectorCreationException e) {
                        System.out.println(e.getMessage());
                    }
                });
    }

    public static void main(String[] argv) {

        try {
            readAndWrite(argv[0]);
        } catch (IndicoException e) {
            e.printStackTrace();
        } catch (NoDirException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
