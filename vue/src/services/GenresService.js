import axios from 'axios';

export default {

    getGenresByRecordId(recordId) {
        return axios.get(`/records/${recordId}/genres`);
    },

    addGenresToRecord(recordId, genreNames) {
        return axios.post(`/records/${recordId}/genres`, genreNames);
    }

}