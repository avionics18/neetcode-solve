import java.util.*;

public class C01_121_Buy_and_Sell_Stock {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int[] arr = Arrays.stream(str.trim().split(","))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        sc.close();

        System.out.println(maxProfit(arr));
    }

    public static int maxProfit(int[] prices) {
        // The concept is that profit can only be obtained
        // from the day the cost of coin was minimum.
        // But there can be multiple profits, so we return
        // the max profit.

        // So we have a variable "min", which will be updated
        // only when it encounters the most minimum element,
        // and when it encounters min will be updated by this new minimum.
        // and the now profits will be calculated wrt this new min.
        // because you can sell the coin only when you
        // have bought the coin as this minimum price.
        // Now, there can be multiple min's in the prices[].
        // therefore we also update "profit" only when the current
        // profit is greater than the previous profit.


        // you can not set the min to 0,
        // otherwise it'll calculate profit for 1st element wrt 0.
        int min = prices[0];
        int profit = 0;
        for (int price : prices) {
            min = Math.min(min, price);
            profit = Math.max(profit, price - min);
        }

        return profit;
    }
}