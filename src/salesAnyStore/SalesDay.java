package salesAnyStore;

import java.util.Arrays;
import java.util.Scanner;

public class SalesDay {
	private double[] dailySales;

	// Constructor to initialize daily sales array
	public SalesDay() {
		this.dailySales = new double[7];
	}

	// Method to add daily sale amount for a specific day
	public void addSale(int dayIndex, double saleAmount) {
		if (dayIndex < 0 || dayIndex >= 7) {
			throw new IllegalArgumentException("Invalid day index. It should be between 0 and 6.");
		}
		if (saleAmount < 0) {
			throw new IllegalArgumentException("Sale amount cannot be negative.");
		}
		this.dailySales[dayIndex] += saleAmount;
	}

	// Method to get total sales for the week
//	public double calculateTotalSales() {
//		return Arrays.stream(this.dailySales).sum();
//	}
	public double calculateTotalSales() {
		double totalSales = 0;
		for (double sale : this.dailySales) {
			totalSales += sale;
		}
		return totalSales;
	}

	// Method to get average daily sales
	public double calculateAverageDailySales() {
		return calculateTotalSales() / 7;
	}

	// Method to find the day with the highest sales
	public int findBestSalesDay() {
		double maxSales = Double.MIN_VALUE;
		int bestDay = -1;
		for (int i = 0; i < 7; i++) {
			if (this.dailySales[i] > maxSales) {
				maxSales = this.dailySales[i];
				bestDay = i;
			}
		}
		return bestDay;
	}

	// Method to find the day with the lowest sales
	public int findWorstSalesDay() {
		double minSales = Double.MAX_VALUE;
		int worstDay = -1;
		for (int i = 0; i < 7; i++) {
			if (this.dailySales[i] < minSales) {
				minSales = this.dailySales[i];
				worstDay = i;
			}
		}
		return worstDay;
	}

	// Method to display sales
	public void displaySalesReport() {
		System.out.println("Total Sales: $" + calculateTotalSales());
		System.out.println("Average Daily Sales: $" + calculateAverageDailySales());
		int bestDay = findBestSalesDay();
		int worstDay = findWorstSalesDay();
		System.out.println("Best Sales Day: Day " + (bestDay + 1) + " with sales $" + this.dailySales[bestDay]);
		System.out.println("Worst Sales Day: Day " + (worstDay + 1) + " with sales $" + this.dailySales[worstDay]);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		SalesDay salesDay = new SalesDay();
		SalesAnalyzer salesAnalyzer = new SalesAnalyzer(salesDay);

		for (int i = 0; i < 7; i++) {
			System.out.print("Enter sales amount for day " + (i + 1) + ": ");
			double saleAmount = scanner.nextDouble();
			salesAnalyzer.addSale(i, saleAmount);
		}

		scanner.close();

		salesAnalyzer.displaySalesReport();
	}
}