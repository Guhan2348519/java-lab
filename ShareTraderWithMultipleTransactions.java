public class ShareTraderWithMultipleTransactions {

private static int minBuy1 = Integer.MAX_VALUE;
private static int maxSell1 = Integer.MIN_VALUE;
private static int minBuy2 = Integer.MAX_VALUE;
private static int maxSell2 = Integer.MIN_VALUE;
private static int buyPrice1;
private static int sellPrice1;
private static int buyPrice2;
private static int sellPrice2;
private static int profit;
public static int findMaxProfit(int[] prices) {
boolean secondTransactionOccurred = false;
 for (int i = 0; i < prices.length; i++) {
   if (i % 2 == 0) {
     updateMinBuy(prices[i]);
            } 
   else {
   if (updateMaxSell(prices[i])) {
    secondTransactionOccurred = true;
                }
            }
        }

 if (!secondTransactionOccurred) {
 // If second transaction doesn't occur, use values from the first transaction
 buyPrice2 = buyPrice1;
 sellPrice2 = sellPrice1;
        }
 calculateProfit();
 printProfitBreakdown();
  return profit;
    }
private static void updateMinBuy(int price) {
 if (price < minBuy1) {
 minBuy2 = minBuy1;
 minBuy1 = price;
 buyPrice1 = minBuy1;
 } else if (price < minBuy2) {
 minBuy2 = price;
buyPrice2 = minBuy2;
        }
    }
 private static boolean updateMaxSell(int price) {
 if (price > maxSell1) {
    maxSell2 = maxSell1;
    maxSell1 = price;
    sellPrice1 = maxSell1;
   return true;
        } else if (price > maxSell2) {
   maxSell2 = price;
   sellPrice2 = maxSell2;
   return true;
   }
  return false;
    }
    private static void calculateProfit() {
  profit = Math.max(maxSell1 - minBuy1, maxSell2 - minBuy2);
    }
 private static void printProfitBreakdown() {
System.out.println("Transaction 1:");
System.out.println("Buy Price: " + buyPrice1);
System.out.println("Sell Price: " + sellPrice1);
System.out.println("Profit: " + (sellPrice1 - buyPrice1));

System.out.println("\nTransaction 2:");
System.out.println("Buy Price: " + buyPrice2);
System.out.println("Sell Price: " + sellPrice2);
System.out.println("Profit: " + (sellPrice2 - buyPrice2));

System.out.println("\nTotal Profit: " + profit);
    }
public static void main(String[] args) {
int[] prices = {10, 22, 5, 75, 65, 80};
 findMaxProfit(prices);
    }
}
