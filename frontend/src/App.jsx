import { BrowserRouter, Routes, Route, Navigate } from "react-router-dom";

import Dashboard from "./pages/Dashboard";
import Menu from "./pages/Menu";
import Inventory from "./pages/Inventory";
import Sales from "./pages/Sales";
import Analytics from "./pages/Analytics";
import AIInsights from "./pages/AIInsights";
import BusinessAdvisor from "./pages/BusinessAdvisor";
import TrendAnalyzer from "./pages/TrendAnalyzer";
import DecisionMaker from "./pages/DecisionMaker";
import MarketingAssistant from "./pages/MarketingAssistant";
import ProfitAdvisor from "./pages/ProfitAdvisor";
import CustomerBehavior from "./pages/CustomerBehavior";

function App() {
  return (
    <BrowserRouter>

      <Routes>

        {/* Default */}
        <Route
          path="/"
          element={<Navigate to="/dashboard" replace />}
        />

        {/* Dashboard */}
        <Route
          path="/dashboard"
          element={<Dashboard />}
        />

        {/* Menu */}
        <Route
          path="/menu"
          element={<Menu />}
        />

        {/* Inventory */}
        <Route
          path="/inventory"
          element={<Inventory />}
        />

        {/* Sales */}
        <Route
          path="/sales"
          element={<Sales />}
        />

        {/* Analytics */}
        <Route
          path="/analytics"
          element={<Analytics />}
        />

        {/* AI Insights */}
        <Route
          path="/ai-insights"
          element={<AIInsights />}
        />

        {/* Business Advisor */}
        <Route
          path="/ai-insights/business-advisor"
          element={<BusinessAdvisor />}
        />
        <Route
  path="/ai-insights/trend-analyzer"
  element={<TrendAnalyzer />}
/>
<Route
  path="/ai-insights/decision-maker"
  element={<DecisionMaker />}
/>

<Route
  path="/ai-insights/marketing-assistant"
  element={<MarketingAssistant />}
/>

<Route
  path="/ai-insights/profit-advisor"
  element={<ProfitAdvisor />}
/>

<Route
  path="/ai-insights/customer-behavior"
  element={<CustomerBehavior />}
/>

      </Routes>

    </BrowserRouter>
  );
}

export default App;