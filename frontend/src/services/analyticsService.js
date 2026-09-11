import axios from "axios";
import { API_BASE_URL } from "../config/api";

const API = `${API_BASE_URL}/analytics`;

export const getAnalyticsSummary = () => {
    return axios.get(`${API}/summary`);
};

export const getRevenueTrend = () => {
    return axios.get(`${API}/revenue-trend`);
};

export const getTopSellingItems = () => {
    return axios.get(`${API}/top-items`);
};

export const getCategoryRevenue = () => {
  return axios.get(`${API}/category-revenue`);
};