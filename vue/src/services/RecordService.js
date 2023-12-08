import axios from 'axios';

export default {
    getRecordsByCollectionId(collectionId) {
        return axios.get('/collections/' + collectionId + '/records');
    },

    getRecordsByUserId(id) {
        return axios.get('/users/' + id + '/records');
    }
}