import axios from "axios";

const API = "http://localhost:8080/inventory";

export const getInventory = () =>
    axios.get(API);

export const updateInventory = (id, inventory) =>
    axios.put(`${API}/${id}`, inventory);