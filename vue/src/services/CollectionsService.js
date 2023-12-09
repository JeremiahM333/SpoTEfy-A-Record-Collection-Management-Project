import axios from 'axios';

export default {

    getPublicCollections() {
        return axios.get('/collections');
    },

    getCollectionsByUserId(userId) {
        return axios.get('/users/' + userId + '/collections');
    },

    createCollection(collection) {
        return axios.post('/collections', collection);
    },

    getNumOfCollectionsByUserId(userId) {
        return axios.get(`/users/${userId}/collections/amount`);
    }, 

    addRecordToCollection(collectionId) {
        return axios.post(`collections/${collectionId}/records`);
    }
}