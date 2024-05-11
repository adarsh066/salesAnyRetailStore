package salesAnyStore;

public class SalesAnalyzer {
	private SalesDay salesData;

	// Constructor to initialize SalesDay object
	public SalesAnalyzer(SalesDay salesData) {
		this.salesData = salesData;
	}

	// Method to add daily sale amount for a specific day
	public void addSale(int dayIndex, double saleAmount) {
		this.salesData.addSale(dayIndex, saleAmount);
	}

	// Method to get total sales for the month
	public double calculateTotalSales() {
		return this.salesData.calculateTotalSales();
	}

	// Method to get average daily sales
	public double calculateAverageDailySales() {
		return this.salesData.calculateAverageDailySales();
	}

	// Method to find the day with the highest sales
	public int findBestSalesDay() {
		return this.salesData.findBestSalesDay();
	}

	// Method to find the day with the lowest sales
	public int findWorstSalesDay() {
		return this.salesData.findWorstSalesDay();
	}

	// Method to display sales report
	public void displaySalesReport() {
		this.salesData.displaySalesReport();
	}
}
