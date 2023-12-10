import axios from 'axios';

export default {

    getArtistsByRecordId(recordId) {
        return axios.get(`/records/${recordId}/artists`);
    }

}