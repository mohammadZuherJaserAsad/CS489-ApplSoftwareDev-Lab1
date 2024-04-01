package edu.miu.cs.cs489appsd.lab1a.productmgmtapp;

import edu.miu.cs.cs489appsd.lab1a.productmgmtapp.model.Product;

import java.time.LocalDate;
import java.util.Arrays;

public class ProductMgmtApp {

    public static void main(String[] args) {
        // Create an array of Product objects using the provided data
        Product[] products = {
                new Product(3128874119L, "Banana", LocalDate.of(2023, 1, 24), 124, 0.55),
                new Product(2927458265L, "Apple", LocalDate.of(2022, 12, 9), 18, 1.09),
                new Product(9189927460L, "Carrot", LocalDate.of(2023, 3, 31), 89, 2.99)
        };

        // Print the products in JSON format
        printProducts(products, "JSON");

        // Print the products in XML format
        printProducts(products, "XML");

        // Print the products in CSV format
        printProducts(products, "CSV");
    }

    // Method to print products in the specified format
    public static void printProducts(Product[] products, String format) {
        // Sort products by name
        Arrays.sort(products, (p1, p2) -> p1.getName().compareTo(p2.getName()));

        // Print products in the specified format
        switch (format) {
            case "JSON":
                System.out.println("JSON-formatted list of all Products:");
                System.out.println("[");
                for (Product product : products) {
                    System.out.println(productToJSON(product));
                }
                System.out.println("]");
                break;
            case "XML":
                System.out.println("XML-formatted list of all Products:");
                System.out.println("<Products>");
                for (Product product : products) {
                    System.out.println(productToXML(product));
                }
                System.out.println("</Products>");
                break;
            case "CSV":
                System.out.println("Comma-Separated Values (CSV)-formatted list of all Products:");
                System.out.println("Product Id,Name,Date Supplied,Quantity In Stock,Unit Price (in US$)");
                for (Product product : products) {
                    System.out.println(productToCSV(product));
                }
                break;
            default:
                System.out.println("Invalid format specified.");
        }
    }

    // Methods to convert product to JSON, XML, and CSV formats
    public static String productToJSON(Product product) {
        return String.format("{\"productId\": %d, \"name\": \"%s\", \"dateSupplied\": \"%s\", \"quantityInStock\": %d, \"unitPrice\": %.2f}",
                product.getProductId(), product.getName(), product.getDateSupplied().toString(), product.getQuantityInStock(), product.getUnitPrice());
    }

    public static String productToXML(Product product) {
        return String.format("<Product><productId>%d</productId><name>%s</name><dateSupplied>%s</dateSupplied><quantityInStock>%d</quantityInStock><unitPrice>%.2f</unitPrice></Product>",
                product.getProductId(), product.getName(), product.getDateSupplied().toString(), product.getQuantityInStock(), product.getUnitPrice());
    }

    public static String productToCSV(Product product) {
        return String.format("%d,%s,%s,%d,%.2f",
                product.getProductId(), product.getName(), product.getDateSupplied().toString(), product.getQuantityInStock(), product.getUnitPrice());
    }
}
