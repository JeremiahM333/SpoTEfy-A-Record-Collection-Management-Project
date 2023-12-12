import axios from 'axios';

export default {
    getRecordsByCollectionId(collectionId) {
        return axios.get('/collections/' + collectionId + '/records');
    },

    getRecordsByUserId(userId) {
        return axios.get('/users/' + userId + '/records');
    },

    createRecord(newRecord) {
        return axios.post('/record', newRecord);
    },

    getNumOfRecordsByUserId(userId) {
        return axios.get(`/users/${userId}/records/amount`);
    },

    getRecordByRecordId(recordId) {
        return axios.get(`/records/${recordId}`);
    },

    getRecords() {
        return axios.get('/records');
    }
}
