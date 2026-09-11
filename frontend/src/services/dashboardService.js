import axios from "axios";
import { API_BASE_URL } from "../config/api";

const API = `${API_BASE_URL}/dashboard`;

export const getTodaySummary = () =>
  axios.get(`${API}/today-summary`);

export const getRevenueTrend = () =>
  axios.get(`${API}/revenue-trend`);

export const getPaymentAnalytics = () =>
  axios.get(`${API}/payment-analytics`);

export const getCategoryRevenue = () =>
  axios.get(`${API}/category-revenue`);

export const getTopSellingItems = () =>
  axios.get(`${API}/top-selling`);

export const getLowStockItems = () =>
  axios.get(`${API}/low-stock`);

export const getRecentSales = () =>
  axios.get(`${API}/recent-sales`);


