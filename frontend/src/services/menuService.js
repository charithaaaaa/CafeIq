import axios from "axios";
import { API_BASE_URL } from "../config/api";

//Axios is a JavaScript library that sends HTTP requests from React to your Spring Boot backend. Without it react cannot communicate with ur backend

const API = `${API_BASE_URL}/menu`;

export const getMenuItems = () =>
    axios.get(API);

export const addMenuItem = (menu) =>
    axios.post(API, menu);

export const updateMenuItem = (id, menu) =>
    axios.put(`${API}/${id}`, menu);

export const deleteMenuItem = (id) =>
    axios.delete(`${API}/${id}`);
