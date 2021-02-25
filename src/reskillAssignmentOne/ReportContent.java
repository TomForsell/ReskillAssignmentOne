package reskillAssignmentOne;

public class ReportContent {
    private ServiceSales reportService;
    private String mostProfitableOrder;
    //displayMostProfitableOrder
    private Order order;

    public ReportContent() {
        this.reportService = new ServiceSales();
        this.order = reportService.findMaxOrder();

        this.mostProfitableOrder = (order.toString() +  "\nProfit for this order:"  + order.getProfitForOrder());
    }
}