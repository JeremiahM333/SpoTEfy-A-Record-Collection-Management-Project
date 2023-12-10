import axios from 'axios';

export default {

    getGenresByRecordId(recordId) {
        return axios.get(`/records/${recordId}/genres`);
    }

}