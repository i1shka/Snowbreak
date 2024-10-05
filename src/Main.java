import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
//        чтение данных из файла
        File file = new File(
                "input.txt");
        Scanner sc = new Scanner(file);
        int sumDays= sc.nextInt();
        int [] temps=new int[sumDays];
        for (int i=0; i<sumDays;i++){
        temps[i]=sc.nextInt();
        sc.useDelimiter(" ");}

// запись результата в файл
        writing(counting(temps));
        System.out.println(counting(temps));
    }

    static void writing (int res){
        try {
            FileWriter writer = new FileWriter("output.txt", false);
            writer.write(Integer.toString(res));
            writer.close();

        } catch (IOException e) {
            System.out.println("Возникла ошибка во время записи, проверьте данные.");
        }
    }

    static int counting(int [] temps){
        int counter =0;
        int buffer =0;
        for (int i : temps) {
            if (i > 0) {
                counter++;
            } else {
                counter = 0;
            }
            if (counter > buffer) {
                buffer = counter;
            }
        }
        return buffer;
    }
}

