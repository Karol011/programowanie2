package pl.sdacademy.prog.threads.myThreads.zadG;

public class Prime {

    public static void main(String[] args) {

        int low = 3, high = 10;

        while (low < high) {
            boolean flag = false;

            for(int i = 2; i <= low/2; ++i) {
                // condition for nonprime number
                if(low % i == 0) {
                    flag = true;
                    break;
                }
            }

            if (!flag)
                System.out.print(low + " ");

            ++low;
        }
    }
}
