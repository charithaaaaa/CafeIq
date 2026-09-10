import axios from "axios";

const API_BASE_URL = "http://localhost:8080/analytics";

export const getAnalyticsSummary = () => {
    return axios.get(`${API_BASE_URL}/summary`);
};

export const getRevenueTrend = () => {
    return axios.get(`${API_BASE_URL}/revenue-trend`);
};

export const getTopSellingItems = () => {
    return axios.get(`${API_BASE_URL}/top-items`);
};

export const getCategoryRevenue = () => {
  return axios.get(`${API_BASE_URL}/category-revenue`);
};