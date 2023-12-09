abstract class Robber 
{
abstract int RowHouses(int[] moneyInRowHouses);
abstract int RoundHouses(int[] moneyInRoundHouses);
abstract int SquareHouse(int[] moneyInSquareHouses);
abstract int MultiHouseBuilding(int[] moneyInMultiTypeBuilding);
void RobbingClass() 
{
System.out.println("MScAI&ML");
 }
void MachineLearning() {
System.out.println("I love MachineLearning.");
}
}
class JAVAProfessionalRobber extends Robber {
@Override
int RowHouses(int[] moneyInRowHouses) {
if (moneyInRowHouses.length < 2) 
{
return (moneyInRowHouses.length == 1) ? moneyInRowHouses[0] : 0;
}
int profit1 = moneyInRowHouses[0] + moneyInRowHouses[2];
int profit2 = moneyInRowHouses[0] + moneyInRowHouses[3];
int profit3 = moneyInRowHouses[1] + moneyInRowHouses[3];
return Math.max(Math.max(profit1, profit2), profit3);
}
@Override
int RoundHouses(int[] moneyInRoundHouses) {
if (moneyInRoundHouses.length < 2) 
{
 return (moneyInRoundHouses.length == 1) ? moneyInRoundHouses[0] : 0;
 }
int profit1 = moneyInRoundHouses[0] + moneyInRoundHouses[2];
int profit2 = moneyInRoundHouses[0] + moneyInRoundHouses[3];
int profit3 = moneyInRoundHouses[1] + moneyInRoundHouses[3];
return Math.max(Math.max(profit1, profit2), profit3);
 }
@Override
int SquareHouse(int[] moneyInSquareHouses) {
if (moneyInSquareHouses.length < 2) 
{
return (moneyInSquareHouses.length == 1) ? moneyInSquareHouses[0] : 0;
}
int profit7 = moneyInSquareHouses[0] + moneyInSquareHouses[2]; // Diagonal elements 1 and 3
int profit8 = moneyInSquareHouses[1] + moneyInSquareHouses[3]; // Diagonal elements 2 and 4
return Math.max(profit7, profit8);
}
@Override
int MultiHouseBuilding(int[] moneyInMultiTypeBuilding) {
int profit1 = moneyInMultiTypeBuilding[0] + moneyInMultiTypeBuilding[2]; // Diagonal elements 1 and 3
int profit2 = moneyInMultiTypeBuilding[1] + moneyInMultiTypeBuilding[3]; // Diagonal elements 2 and 4
int profit3 = moneyInMultiTypeBuilding[4] + moneyInMultiTypeBuilding[6]; // Diagonal elements 5 and 7
int profit4 = moneyInMultiTypeBuilding[5] + moneyInMultiTypeBuilding[7]; // Diagonal elements 6 and 8
int profit5 = moneyInMultiTypeBuilding[0] + moneyInMultiTypeBuilding[6]; // Special case 1 and 7
int profit6 = moneyInMultiTypeBuilding[3] + moneyInMultiTypeBuilding[5]; // Special case 4 and 6
return Math.max(Math.max(Math.max(Math.max(profit1, profit2), profit3), profit4), Math.max(profit5, profit6));
}
public static void main(String[] args) {
JAVAProfessionalRobber robber = new JAVAProfessionalRobber();
 robber.RobbingClass();
robber.MachineLearning();
// Test your methods here
 int[] rowHouses = {10, 5, 20, 15};
 int rowHousesProfit = robber.RowHouses(rowHouses);
System.out.println("Row Houses Profit: " + rowHousesProfit);
int[] roundHouses = {10, 5, 20, 15};
int roundHousesProfit = robber.RoundHouses(roundHouses);
System.out.println("Round Houses Profit: " + roundHousesProfit);
int[] squareHouses = {10, 5, 20, 15};
int squareHousesProfit = robber.SquareHouse(squareHouses);
 System.out.println("Square Houses Profit: " + squareHousesProfit);
int[] multiTypeBuilding = {1, 2, 3, 4, 5, 6, 7, 8};
int multiTypeBuildingProfit = robber.MultiHouseBuilding(multiTypeBuilding);
System.out.println("Multi-Type Building Profit: " + multiTypeBuildingProfit);
}
}