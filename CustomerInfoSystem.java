import java.util.Scanner; 
import java.util.ArrayList; 
import java.util.HashMap; 
import java.util.HashSet; 
import java.util.TreeSet; 
class CustomerInfoSystem { 
private static ArrayList<CustomerInformation> customerInformationList = new ArrayList<>(); private static HashMap<String, CustomerInformation> customerInformationMap = new HashMap<>(); private static ArrayList<ProductInformation> productInformationList = new ArrayList<>(); private static HashMap<String, ProductInformation> productInformationMap = new HashMap<>(); private static ArrayList<OrderInformation> orderInformationList = new ArrayList<>(); 
private static TreeSet<OrderInformation> orderInformationTreeSet = new TreeSet<>((order1, order2) ->  order1.getId().compareTo(order2.getId())); 
public static void main(String[] args) {
Scanner scanner = new Scanner(System.in); 
 int userChoice; 
 do { 
 System.out.println("\nOrdering System");  System.out.println("1. Add Customer Information");  System.out.println("2. Add Product Information");  System.out.println("3. Add Order Information");  System.out.println("4. Update Customer Information");  System.out.println("5. Retrieve Customer Information");  System.out.println("6. Modify Product Information");  System.out.println("7. Place Order Information");  System.out.println("8. Modify Order Information");  System.out.println("9. Generate Billing Information");  System.out.println("10. Exit"); 
System.out.print("Enter your choice: "); 
userChoice = scanner.nextInt(); 
switch (userChoice) { 
case 1: 
addCustomerInformation(scanner); 
break; 
case 2: 
addProductInformation(scanner); 
break; 
case 3: 
addOrderInformation(scanner); 
break; 
case 4:
updateCustomerInformation(scanner); 
break; 
case 5: 
retrieveCustomerInformation(scanner); 
break; 
case 6: 
modifyProductInformation(scanner); 
break; 
case 7: 
placeOrderInformation(scanner); 
break; 
case 8: 
modifyOrderInformation(scanner); 
break; 
case 9: 
generateBillingInformation(); 
break; 
case 10: 
System.out.println("Exiting..."); 
System.exit(0); 
break; 
default: 
System.out.println("Invalid choice. Please enter a valid option."); break; 
} 
} while (userChoice != 0); 
scanner.close();
 } 
private static void addCustomerInformation(Scanner scanner) { 
System.out.print("Enter customer name: "); 
String customerName = scanner.next(); 
System.out.print("Enter customer email: "); 
String customerEmail = scanner.next(); 
System.out.print("Enter customer address: "); 
String customerAddress = scanner.next(); 
System.out.print("Enter customer phone number: "); 
String customerPhoneNumber = scanner.next(); 
CustomerInformation newCustomerInformation = new CustomerInformation(customerName,  customerPhoneNumber, customerAddress, customerEmail); 
customerInformationList.add(newCustomerInformation); 
customerInformationMap.put(newCustomerInformation.getEmail(), newCustomerInformation); System.out.println("Customer information added successfully."); 
 } 
private static void addProductInformation(Scanner scanner) { 
System.out.print("Enter product ID: "); 
String productID = scanner.next(); 
System.out.print("Enter product name: "); 
String productName = scanner.next(); 
System.out.print("Enter product price: "); 
double productPrice = scanner.nextDouble(); 
System.out.print("Enter product quantity: "); 
int productQuantity = scanner.nextInt(); 
ProductInformation newProductInformation = new ProductInformation(productID, productName,  productPrice, productQuantity);
productInformationList.add(newProductInformation); 
productInformationMap.put(newProductInformation.getId(), newProductInformation); System.out.println("Product information added successfully."); 
 } 
private static void addOrderInformation(Scanner scanner) { 
System.out.print("Enter order ID: "); 
String orderID = scanner.next(); 
System.out.print("Enter customer name for the order: "); 
String orderCustomerName = scanner.next(); 
System.out.print("Enter product ID for the order: "); 
String orderProductID = scanner.next(); 
System.out.print("Enter order quantity: "); 
int orderQuantity = scanner.nextInt(); 
ProductInformation orderedProductInformation = productInformationMap.get(orderProductID); if (orderedProductInformation != null) { 
double orderPrice = orderedProductInformation.getPrice() * orderQuantity; 
OrderInformation newOrderInformation = new OrderInformation(orderID, orderCustomerName,  orderProductID, orderQuantity, orderPrice); 
orderInformationList.add(newOrderInformation); 
orderInformationTreeSet.add(newOrderInformation); 
System.out.println("Order information added successfully."); 
} else { 
System.out.println("Error: Product information not found for the given ID."); } 
} 
private static void updateCustomerInformation(Scanner scanner) {
System.out.print("Enter customer email to update information: "); String updateCustomerEmail = scanner.next(); 
CustomerInformation existingCustomerInformation =  
customerInformationMap.get(updateCustomerEmail); 
if (existingCustomerInformation != null) { 
System.out.print("Enter new customer name: "); 
String newCustomerName = scanner.next(); 
System.out.print("Enter new customer address: "); 
String newCustomerAddress = scanner.next(); 
System.out.print("Enter new customer phone number: "); 
String newCustomerPhoneNumber = scanner.next(); 
existingCustomerInformation.setName(newCustomerName); existingCustomerInformation.setAddress(newCustomerAddress); existingCustomerInformation.setPhoneNumber(newCustomerPhoneNumber); System.out.println("Customer information updated successfully."); } else { 
System.out.println("Customer information not found."); 
} 
} 
private static void retrieveCustomerInformation(Scanner scanner) { System.out.print("Enter customer email to retrieve information: "); String retrieveCustomerEmail = scanner.next(); 
CustomerInformation retrievedCustomerInformation =  
customerInformationMap.get(retrieveCustomerEmail); 
if (retrievedCustomerInformation != null) { 
System.out.println("Customer Information:"); 
System.out.println("Name: " + retrievedCustomerInformation.getName());
System.out.println("Address: " + retrievedCustomerInformation.getAddress()); System.out.println("Phone Number: " + retrievedCustomerInformation.getPhoneNumber()); } else { 
System.out.println("Customer information not found."); 
} 
} 
private static void modifyProductInformation(Scanner scanner) { 
System.out.print("Enter product ID to modify information: "); 
String modifyProductID = scanner.next(); 
ProductInformation existingProductInformation = productInformationMap.get(modifyProductID); if (existingProductInformation != null) { 
System.out.print("Enter new product name: "); 
String modifiedProductName = scanner.next(); 
System.out.print("Enter new product price: "); 
double modifiedProductPrice = scanner.nextDouble(); 
System.out.print("Enter new product quantity: "); 
int modifiedProductQuantity = scanner.nextInt(); 
existingProductInformation.setName(modifiedProductName); 
existingProductInformation.setPrice(modifiedProductPrice); 
existingProductInformation.setQuantity(modifiedProductQuantity); 
System.out.println("Product information modified successfully."); 
} else { 
System.out.println("Product information not found."); 
 } 
 } 
private static void placeOrderInformation(Scanner scanner) { 
System.out.println("Enter order ID: ");
String orderID = scanner.next(); 
System.out.println("Enter customer name for the order: "); 
String orderCustomerName = scanner.next(); 
System.out.println("Enter product ID for the order: "); 
String orderProductID = scanner.next(); 
System.out.println("Enter order quantity: "); 
int orderQuantity = scanner.nextInt(); 
OrderInformation newOrderInformation = new OrderInformation(orderID, orderCustomerName,  orderProductID, orderQuantity, 
productInformationMap.get(orderProductID).getPrice() * orderQuantity); orderInformationList.add(newOrderInformation); 
orderInformationTreeSet.add(newOrderInformation); 
System.out.println("Order information placed successfully."); 
 } 
private static void modifyOrderInformation(Scanner scanner) { 
System.out.print("Enter order ID to modify: "); 
String modifyOrderID = scanner.next(); 
OrderInformation existingOrderInformation = getOrderById(modifyOrderID); if (existingOrderInformation != null) { 
System.out.print("Enter new order quantity: "); 
int newQuantity = scanner.nextInt(); 
existingOrderInformation.setQuantity(newQuantity); 
existingOrderInformation.setTotalPrice(existingOrderInformation.getQuantity() *  productInformationMap.get(existingOrderInformation.getProductID()).getPrice()); 
System.out.println("Order information modified successfully."); 
} else { 
System.out.println("Order information not found.");
} 
} 
private static OrderInformation getOrderById(String orderId) { for (OrderInformation orderInformation : orderInformationList) { if (orderInformation.getId().equals(orderId)) { 
return orderInformation; 
} 
} 
return null; 
} 
 private static void generateBillingInformation() { 
System.out.println(" Billing Information "); 
for (OrderInformation orderInformation : orderInformationTreeSet) { System.out.println("Order ID: " + orderInformation.getId()); 
System.out.println("Customer Name: " + orderInformation.getCustomerName()); 
ProductInformation orderedProductInformation =  
productInformationMap.get(orderInformation.getProductID()); if (orderedProductInformation != null) { 
System.out.println("Product ID: " + orderedProductInformation.getId()); System.out.println("Product Name: " + orderedProductInformation.getName()); System.out.println("Quantity: " + orderInformation.getQuantity()); System.out.println("Price per Unit: Rs" + orderedProductInformation.getPrice()); System.out.println("Total Price: Rs" + orderInformation.getTotalPrice()); System.out.println("------------------------"); 
} else { 
System.out.println("Error: Product information not found for the order."); }
} 
 } 
} 
class CustomerInformation { 
private String CustomerName; 
private String EmailAddress; 
private String PostalAddress; 
private String PhoneNumber; 
public CustomerInformation(String CustomerName, String PhoneNumber, String PostalAddress, String  EmailAddress) { 
this.CustomerName = CustomerName; 
this.PhoneNumber = PhoneNumber; 
this.PostalAddress = PostalAddress; 
this.EmailAddress = EmailAddress; 
} 
public String getName() { 
return CustomerName; 
} 
public String getEmail() { 
return EmailAddress; 
} 
public String getAddress() { 
return PostalAddress; 
} 
public String getPhoneNumber() { 
return PhoneNumber; 
 }
public void setName(String CustomerName) { 
this.CustomerName = CustomerName; 
 } 
public void setEmail(String EmailAddress) { 
this.EmailAddress = EmailAddress; 
 } 
public void setAddress(String PostalAddress) { 
this.PostalAddress = PostalAddress; 
 } 
public void setPhoneNumber(String PhoneNumber) { 
this.PhoneNumber = PhoneNumber; 
} 
} 
class ProductInformation { 
private String Identification; 
private String ProductName; 
private double UnitPrice; 
private int Quantity; 
public ProductInformation(String Identification, String ProductName, double UnitPrice, int Quantity) { this.Identification = Identification; 
this.ProductName = ProductName; 
this.UnitPrice = UnitPrice; 
this.Quantity = Quantity; 
 } 
public String getId() { 
return Identification;
 } 
public String getName() { 
return ProductName; 
 } 
public double getPrice() { 
return UnitPrice; 
} 
public int getQuantity() { 
return Quantity; 
} 
public void setId(String Identification) { this.Identification = Identification; } 
public void setName(String ProductName) { this.ProductName = ProductName; } 
public void setPrice(double UnitPrice) { this.UnitPrice = UnitPrice; 
} 
public void setQuantity(int Quantity) { this.Quantity = Quantity; 
} 
} 
class OrderInformation { 
private String OrderIdentification; private String CustomerFullName; private String ProductIdentification;
private int OrderQuantity; 
private double TotalCost; 
public OrderInformation(String OrderIdentification, String CustomerFullName, String  ProductIdentification, int OrderQuantity, double TotalCost) { 
this.OrderIdentification = OrderIdentification; 
this.CustomerFullName = CustomerFullName; 
this.ProductIdentification = ProductIdentification; 
this.OrderQuantity = OrderQuantity; 
this.TotalCost = TotalCost; 
} 
public String getId() { 
return OrderIdentification; 
 } 
public String getCustomerName() { 
return CustomerFullName; 
 } 
public String getProductID() { 
return ProductIdentification; 
 } 
 public int getQuantity() { 
 return OrderQuantity; 
 } 
public double getTotalPrice() { 
return TotalCost; 
 } 
public void setQuantity(int OrderQuantity) {
this.OrderQuantity = OrderQuantity;  } 
public void setTotalPrice(double TotalCost) { this.TotalCost = TotalCost; 
 } 
}
