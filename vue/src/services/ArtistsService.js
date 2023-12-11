import axios from 'axios';

export default {

    getArtistsByRecordId(recordId) {
        return axios.get(`/records/${recordId}/artists`);
    },

    addRecordToArtists(recordId, artistNames) {
        return axios.post(`/records/${recordId}/artists`, artistNames);
    }

}