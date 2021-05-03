import axios from 'axios';

export const api = axios.create({
    baseURL: 'https://fatec-fight-service.herokuapp.com'
})