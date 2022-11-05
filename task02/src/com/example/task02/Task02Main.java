package com.example.task02;

public class Task02Main {

    private static final Item ITEM1 = new Item("Product 1", 10);
    private static final Item ITEM2 = new Item("Product 2", 20);
    private static final Item ITEM3 = new Item("Product 3", 30);
    private static final Item ITEM4 = new Item("Product 4", 40);
    private static final Item ITEM5 = new Item("Product 5", 50);
    private static final Item ITEM6 = new Item("Product 6", 60);

    public static void main(String[] args) {
        DiscountBill bl = new DiscountBill(50);
        bl.add(ITEM5, 3);
        System.out.println(bl.getPrice());
        System.out.println(bl.getAbsoluteDiscount());
    }
}