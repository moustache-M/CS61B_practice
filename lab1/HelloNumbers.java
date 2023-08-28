/** print out the cumulative sum of the integers from 0 to 9 */
public class HelloNumbers {
    public static void main(String[] args) {
        int x = 0, sum = 0;
        while (x < 10) {
            sum += x;
            System.out.print(sum+" ");
            x++;
        }
        System.out.println();
    }
}
