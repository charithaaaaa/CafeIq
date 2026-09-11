import axios from "axios";
import { API_BASE_URL } from "../config/api";

const API = `${API_BASE_URL}/inventory`;

export const getInventory = () =>
    axios.get(API);

export const updateInventory = (id, inventory) =>
    axios.put(`${API}/${id}`, inventory);