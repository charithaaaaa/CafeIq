import axios from "axios";
import { API_BASE_URL } from "../config/api";

const API = `${API_BASE_URL}/sales`;

// Get all sales
export const getAllSales = () => {
  return axios.get(API);
};

// Get sale by ID
export const getSaleById = (id) => {
  return axios.get(`${API}/${id}`);
};

// Add new sale
export const addSale = (sale) => {
  return axios.post(API, sale);
};

// Delete sale
export const deleteSale = (id) => {
  return axios.delete(`${API}/${id}`);
};