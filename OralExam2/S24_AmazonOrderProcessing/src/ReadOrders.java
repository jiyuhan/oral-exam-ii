import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * Created by thomas on 10/29/16.
 */
public class ReadOrders {

    private Order[] orders = new Order[30];
    private Path orderCsvFileLocation = Paths.get("/home/thomas/Desktop/oral-exam-ii/OralExam2/S24_AmazonOrderProcessing/files/S24_AmazonOrderProcessing_OrdersFile.csv");
    private String cvsSplit = ",";
    private int counter = 0;

    public boolean loadFile()  {
        System.out.println("Finding file at " + this.orderCsvFileLocation);
        if(Files.exists(this.orderCsvFileLocation)) {
            System.out.println("File found...");
            return true;
        } else {
            System.out.println("File does not exist");
            return false;
        }
    }

    public void readFile() throws IOException{
        int i = 0;
        try (Scanner scanner = new Scanner(this.orderCsvFileLocation)) {
            while (scanner.hasNext()) {
                this.orders[i].setDeliveryAddress(scanner.nextLine());
                this.counter++;
                i++;
            }
        }
    }
    public void printFile() {
        for(int i = 0; i < counter; i++) {
            System.out.println(orders[i].getDeliveryAddress());
        }
    }

}
