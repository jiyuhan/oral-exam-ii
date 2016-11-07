import java.io.IOException;

/**
 * Created by thomas on 10/29/16.
 */

public class AmazonOrderProcessingTest {
    public static void main(String[] args) throws IOException{
        ReadOrders readOrders = new ReadOrders();
        boolean loadFileSuccessed = readOrders.loadFile();
        if(loadFileSuccessed == true) {
            readOrders.readFile();
            readOrders.printFile();
        }
    }
}