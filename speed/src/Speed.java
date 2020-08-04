
import java.util.Scanner;

public class Speed {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Введите скорость в битах в секунду");
        long speed = sc.nextLong();
        System.out.println("Введите размер передачи в байтах");
        long size = convertBytesToBits(sc.nextLong());
        long time = estimateTime(size, speed);
        System.out.println("Передача будет завершена за " + time + " секунд");
        System.out.println(ConditionMessageMap.getMessageByTime(time).orElse(new Message("unknown")).getText());
    }

    public static long estimateTime(long size, long speed) {
        return size / speed;
    }

    public static long convertBytesToBits(long size) {
        return size * 8;
    }
}
