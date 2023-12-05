import axios from 'axios';

export default {

    getCollections() {
        return axios.get('/collections');
    }

}