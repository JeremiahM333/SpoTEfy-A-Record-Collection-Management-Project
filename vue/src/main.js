import { createApp } from 'vue';
import CapstoneApp from './App.vue';
import { createStore } from './store';
import router from './router';
import axios from 'axios';
import "bootstrap/dist/css/bootstrap.min.css";
import "bootstrap";


// TODO: Double check set up cloudinary
/* sets the base URL for server API communication with axios */
axios.defaults.baseURL = import.meta.env.VITE_REMOTE_API;

/* Cloudinary */
// import { v2 as cloudinary } from 'cloudinary';

// cloudinary.config({
//   cloud_name: 'your_cloud_name',  // Replace with your Cloudinary cloud name
//   api_key: 'your_api_key',        // Replace with your Cloudinary API key
//   api_secret: 'your_api_secret'    // Replace with your Cloudinary API secret
// });

// Optionally, you can attach the Cloudinary instance to the app for global access
const app = createApp(CapstoneApp);
// app.config.globalProperties.$cloudinary = cloudinary;
/* Cloudinary */

/*
 * The authorization header is set for axios when you login, but what happens when 
 * you come back or the page is refreshed? When that happens, you need to check 
 * for the token in local storage, and if it exists, you should set the header 
 * so that it will be attached to each request.
 */
let currentToken = localStorage.getItem('token');
let currentUser = JSON.parse(localStorage.getItem('user'));

if (currentToken) {
  // Set token in axios requests
  axios.defaults.headers.common['Authorization'] = `Bearer ${currentToken}`;
}

// Create the Vuex store passing in the stored credentials
const store = createStore(currentToken, currentUser);

app.use(store);
app.use(router);
app.mount('#app');
