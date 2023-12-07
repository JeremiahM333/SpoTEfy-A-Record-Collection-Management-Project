import axios from 'axios';

export default {

    getLibrary(userId) {
        return axios.get(`/records/${userId}`);
    }

}
