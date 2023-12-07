import axios from 'axios';

export default {

    getRecordsByCollectionId(collectionId) {
        return axios.get('/records/' + collectionId);
    }

    getRecordsByUserId(userId) {
        return axios.get('/records/' + userId);
    }

}