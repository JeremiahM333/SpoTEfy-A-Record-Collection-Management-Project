import axios from 'axios';

export default {

    getCollections() {
        return axios.get('/collections');
    }, 

    createCollection(collection) {
        return axios.post('/collections');
    }


}