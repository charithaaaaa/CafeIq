package com.cafeiq.service;

import com.cafeiq.dto.CategoryRevenueDTO;
import com.cafeiq.dto.TopItemDTO;
import com.cafeiq.repository.SalesRepository;
import com.cafeiq.repository.InventoryRepository;
import com.cafeiq.repository.CafeOperatingDayRepository;


import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusinessAdvisorService {

   private final SalesRepository salesRepository;
private final InventoryRepository inventoryRepository;
private final CafeOperatingDayRepository cafeOperatingDayRepository;
private final GeminiService geminiService;

   public BusinessAdvisorService(
        SalesRepository salesRepository,
        InventoryRepository inventoryRepository,
        CafeOperatingDayRepository cafeOperatingDayRepository,
        GeminiService geminiService) {

    this.salesRepository = salesRepository;
    this.inventoryRepository = inventoryRepository;
    this.cafeOperatingDayRepository = cafeOperatingDayRepository;
    this.geminiService = geminiService;
}


    public String getAdvice(String question) {

        // =====================================================
        // TODAY
        // =====================================================

        Double todayRevenue =
                salesRepository.getTodayRevenue();

        Long todayOrders =
                salesRepository.getTodayOrders();

        Long todayItemsSold =
                salesRepository.getTodayItemsSold();

        List<Object[]> todayTopItems =
                salesRepository.getTodayTopSellingItems();


        // =====================================================
        // LAST 7 COMPLETED DAYS
        // =====================================================

        Double last7DaysRevenue =
                salesRepository.getLast7DaysRevenue();

        Long last7DaysOrders =
                salesRepository.getLast7DaysOrders();


        // =====================================================
        // PREVIOUS 7 COMPLETED DAYS
        // =====================================================

        Double previous7DaysRevenue =
                salesRepository.getPrevious7DaysRevenue();

        Long previous7DaysOrders =
                salesRepository.getPrevious7DaysOrders();

        // =====================================================
// OPERATING DAY / CLOSURE DATA
// =====================================================

Long last7ClosedDays =
        cafeOperatingDayRepository.getClosedDaysCountLast7Days();

Long previous7ClosedDays =
        cafeOperatingDayRepository.getClosedDaysCountPrevious7Days();

List<java.sql.Date> last7ClosedDates =
        cafeOperatingDayRepository.getClosedDatesLast7Days();

long last7OpenDays = 7 - last7ClosedDays;
long previous7OpenDays = 7 - previous7ClosedDays;
double last7RevenuePerOpenDay =
        last7OpenDays > 0
                ? last7DaysRevenue / last7OpenDays
                : 0;

double previous7RevenuePerOpenDay =
        previous7OpenDays > 0
                ? previous7DaysRevenue / previous7OpenDays
                : 0;

double last7OrdersPerOpenDay =
        last7OpenDays > 0
                ? (double) last7DaysOrders / last7OpenDays
                : 0;

double previous7OrdersPerOpenDay =
        previous7OpenDays > 0
                ? (double) previous7DaysOrders / previous7OpenDays
                : 0;


        // =====================================================
        // RECENT ITEM PERFORMANCE
        // =====================================================

        List<Object[]> recentItemPerformance =
        salesRepository.getRecentItemPerformance();


// =====================================================
// INVENTORY
// =====================================================

List<Object[]> inventoryData =
        inventoryRepository.getInventoryForBusinessAdvisor();


        // =====================================================
        // ALL-TIME DATA
        // =====================================================

        Double totalRevenue =
                salesRepository.getTotalRevenue();

        Long totalOrders =
                salesRepository.getTotalOrders();

        Long totalItemsSold =
                salesRepository.getTotalItemsSold();

        List<TopItemDTO> allTimeTopItems =
                salesRepository.getTopSellingItems();

        List<CategoryRevenueDTO> categories =
                salesRepository.getCategoryRevenue();


        // =====================================================
        // BUILD CAFE DATA
        // =====================================================

        StringBuilder cafeData = new StringBuilder();


        // =====================================================
        // TODAY
        // =====================================================

        cafeData.append("TODAY\n");

        cafeData.append("Revenue: ₹")
                .append(todayRevenue)
                .append("\n");

        cafeData.append("Orders: ")
                .append(todayOrders)
                .append("\n");

        cafeData.append("Items Sold: ")
                .append(todayItemsSold)
                .append("\n");


        cafeData.append("Top Selling Items Today:\n");

        if (todayTopItems.isEmpty()) {

            cafeData.append("- No sales recorded today\n");

        } else {

            for (Object[] row : todayTopItems) {

                cafeData.append("- ")
                        .append(row[0])
                        .append(": ")
                        .append(row[1])
                        .append(" units\n");
            }
        }


        // =====================================================
        // LAST 7 DAYS
        // =====================================================

        cafeData.append("\nLAST 7 COMPLETED DAYS\n");

        cafeData.append("Revenue: ₹")
                .append(last7DaysRevenue)
                .append("\n");

        cafeData.append("Orders: ")
                .append(last7DaysOrders)
                .append("\n");

        cafeData.append("Open Days: ")
        .append(last7OpenDays)
        .append("\n");

cafeData.append("Closed Days: ")
        .append(last7ClosedDays)
        .append("\n");

cafeData.append("Closed Dates: ");
cafeData.append("Revenue Per Open Day: ₹")
        .append(String.format("%.2f", last7RevenuePerOpenDay))
        .append("\n");

cafeData.append("Orders Per Open Day: ")
        .append(String.format("%.2f", last7OrdersPerOpenDay))
        .append("\n");

if (last7ClosedDates.isEmpty()) {

    cafeData.append("None\n");

} else {

    for (int i = 0; i < last7ClosedDates.size(); i++) {

        cafeData.append(last7ClosedDates.get(i));

        if (i < last7ClosedDates.size() - 1) {
            cafeData.append(", ");
        }
    }

    cafeData.append("\n");
}


        // =====================================================
        // PREVIOUS 7 DAYS
        // =====================================================

        cafeData.append("\nPREVIOUS 7 COMPLETED DAYS\n");

        cafeData.append("Revenue: ₹")
                .append(previous7DaysRevenue)
                .append("\n");

        cafeData.append("Orders: ")
                .append(previous7DaysOrders)
                .append("\n");
        cafeData.append("Open Days: ")
        .append(previous7OpenDays)
        .append("\n");

cafeData.append("Closed Days: ")
        .append(previous7ClosedDays)
        .append("\n");

        cafeData.append("Revenue Per Open Day: ₹")
        .append(String.format("%.2f", previous7RevenuePerOpenDay))
        .append("\n");

cafeData.append("Orders Per Open Day: ")
        .append(String.format("%.2f", previous7OrdersPerOpenDay))
        .append("\n");


        // =====================================================
// RECENT ITEM PERFORMANCE
// =====================================================


cafeData.append("\nRECENT ITEM PERFORMANCE\n");
cafeData.append(
        "Format: Product | Last 7 Completed Days | Previous 7 Completed Days | Change\n"
);

if (recentItemPerformance.isEmpty()) {

    cafeData.append("- No recent item performance data\n");

} else {

    for (Object[] row : recentItemPerformance) {

        String itemName = row[0].toString();

        long last7 = ((Number) row[1]).longValue();
        long previous7 = ((Number) row[2]).longValue();

        long change = last7 - previous7;

        cafeData.append("- ")
                .append(itemName)
                .append(" | ")
                .append(last7)
                .append(" | ")
                .append(previous7)
                .append(" | ");

        if (change > 0) {
            cafeData.append("+");
        }

        cafeData.append(change)
                .append("\n");
    }
}
// =====================================================
// INVENTORY STATUS
// =====================================================

cafeData.append("\nINVENTORY STATUS\n");

cafeData.append(
        "Format: Product | Current Stock | Minimum Stock\n"
);

if (inventoryData.isEmpty()) {

    cafeData.append("- No inventory data available\n");

} else {

    for (Object[] row : inventoryData) {

        cafeData.append("- ")
                .append(row[0])
                .append(" | ")
                .append(row[1])
                .append(" | ")
                .append(row[2])
                .append("\n");
    }
}


        


        // =====================================================
        // ALL TIME
        // =====================================================

        cafeData.append("\nALL-TIME DATA\n");

        cafeData.append("Revenue: ₹")
                .append(totalRevenue)
                .append("\n");

        cafeData.append("Orders: ")
                .append(totalOrders)
                .append("\n");

        cafeData.append("Items Sold: ")
                .append(totalItemsSold)
                .append("\n");


        cafeData.append("\nAll-Time Top Selling Items:\n");

        for (TopItemDTO item : allTimeTopItems) {

            cafeData.append("- ")
                    .append(item.getItemName())
                    .append(": ")
                    .append(item.getQuantitySold())
                    .append(" units\n");
        }


        cafeData.append("\nAll-Time Category Revenue:\n");

        for (CategoryRevenueDTO category : categories) {

            cafeData.append("- ")
                    .append(category.getCategoryName())
                    .append(": ₹")
                    .append(category.getRevenue())
                    .append("\n");
        }


        // =====================================================
        // PROMPT
        // =====================================================

        String prompt = """
        You are CafeIQ's Business Advisor.

        You help a cafe owner make practical business decisions
        using the cafe's actual data.

        IMPORTANT RULES:

        1. Use only the CafeIQ data provided below when making
           factual claims about this cafe.

        2. Never invent products, prices, sales figures,
           percentages, inventory levels, profit margins
           or customer behavior.

        3. Pay close attention to the time period of each
           piece of data.

           TODAY means today only.

           LAST 7 COMPLETED DAYS means the seven full days
           immediately before today.

           PREVIOUS 7 COMPLETED DAYS means the seven full days
           before the last seven completed days.

           ALL-TIME DATA represents the entire sales history.

        4. Never describe all-time data as today's or
           this week's performance.

        5. When useful, compare the LAST 7 COMPLETED DAYS
           with the PREVIOUS 7 COMPLETED DAYS.

        6. RECENT ITEM PERFORMANCE contains:
           Product | Last 7 Completed Days |
           Previous 7 Completed Days | Change.

        7. Use RECENT ITEM PERFORMANCE when discussing whether
           a product is improving, declining or stable.

        8. A positive Change means recent sales increased.
           A negative Change means recent sales decreased.
           A Change of 0 means sales were stable.

        9. A product with 0 units in one period genuinely had
           zero recorded sales in that period. Do not describe
           it as missing from a list.

        10. Do not guess why a product increased or decreased.
            Only give a reason if the provided CafeIQ data
            supports that reason.

        11. If there is not enough data to answer the owner's
            question accurately, clearly explain what information
            is missing.

        12. When giving a recommendation, explain briefly which
            CafeIQ data supports that recommendation.

        13. Speak naturally, like an experienced cafe manager
            talking to the owner.

        14. Give practical and concise advice.

        15. Avoid corporate jargon and overly technical language.

        16. Never use AI-related phrases such as
            "train of thought", "prompting",
            "based on my training", or similar language.

        17. If you use ALL-TIME DATA to answer a question
            about today or recent performance, clearly describe
            it as historical data.

        18. INVENTORY STATUS contains:
                Product | Current Stock | Minimum Stock.

        19. If Current Stock is less than or equal to Minimum Stock,
                treat the product as low stock.

        20. Do not recommend aggressively promoting a low-stock product.

        21. When a product's recent sales are declining and its current
        stock is well above minimum stock, consider that combination
        when suggesting promotions or ways to move inventory.

        22. Do not claim that inventory caused a sales increase or decline
                unless the provided data supports that conclusion.
        23. OPEN DAYS and CLOSED DAYS describe the cafe's operating
        status during each 7-day calendar period.

        24. A CLOSED day means the cafe was not operating. Do not
        interpret zero sales on a CLOSED day as poor performance
        or weak customer demand.

        25. When comparing LAST 7 COMPLETED DAYS with PREVIOUS 7
        COMPLETED DAYS, consider differences in the number of
        OPEN DAYS before concluding that business improved or declined.

        26. If one period had fewer OPEN DAYS than the other, clearly
        mention this when explaining differences in total revenue
        or total orders.

        27. Do not assume that a day with no sales was CLOSED unless
        the CafeIQ data explicitly identifies that date as CLOSED.

        28. Do not claim that a closure caused a specific amount of
        lost revenue, because CafeIQ does not know what revenue
        would have been if the cafe had been open.

        ----------------------------

        CAFEIQ DATA

        %s

        ----------------------------

        OWNER'S QUESTION

        %s

        ----------------------------

        Give the owner a helpful answer based only on the
        available CafeIQ data.
        """.formatted(
                cafeData.toString(),
                question
        );
        return geminiService.askGemini(prompt);
    }
}