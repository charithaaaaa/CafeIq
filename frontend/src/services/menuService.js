import axios from "axios";
//Axios is a JavaScript library that sends HTTP requests from React to your Spring Boot backend. Without it react cannot communicate with ur backend


const API = "http://localhost:8080/menu";

export const getMenuItems = () =>
    axios.get(API);

export const addMenuItem = (menu) =>
    axios.post(API, menu);

export const updateMenuItem = (id, menu) =>
    axios.put(`${API}/${id}`, menu);

export const deleteMenuItem = (id) =>
    axios.delete(`${API}/${id}`);

