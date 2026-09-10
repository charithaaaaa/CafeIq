import axios from "axios";

const API = "http://localhost:8080/sales";

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