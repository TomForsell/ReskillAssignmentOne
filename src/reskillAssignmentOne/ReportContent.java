package reskillAssignmentOne;

public class ReportContent {
    private ServiceSales reportService;
    private String mostProfitableOrder;
    //displayMostProfitableOrder
    private Order order;


    public ReportContent(ServiceSales reportService) {
        this.order = reportService.findMaxOrder();
        this.mostProfitableOrder = ("\nMost Profitable order, OrderID:" + order.getOrderId() +" with profit:" + order.getProfitForOrder());
    }

    public String getMostProfitableOrder() {
        return mostProfitableOrder;
    }
}