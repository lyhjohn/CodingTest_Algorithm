import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        boolean[] dn = new boolean[10100];
        for (int i = 1; i < 10001; i++) {
            if (!dn[i])
                System.out.println(i);

            dn[i + i % 10 + i / 10 % 10 + i / 100 % 10 + i / 1000] = true;



        }
    }
}
