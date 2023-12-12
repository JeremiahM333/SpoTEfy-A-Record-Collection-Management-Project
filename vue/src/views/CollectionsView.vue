<template>
  <div data-bs-spy="scroll" data-bs-target="#navbar-example2" data-bs-root-margin="0px 0px -40%"
    data-bs-smooth-scroll="true" class="collections scrollspy-example bg-body-tertiary" tabindex="0">
    <collection v-for="collection in filteredCollections" v-bind:key="collection.collectionId"
      v-bind:collection="collection" />
  </div>
</template>
  
<script>
import Collection from '../components/Collection.vue';
import CollectionsService from '../services/CollectionsService';
import RecordService from '../services/RecordService';

export default {
  components: {
    Collection
  },
  data() {
    return {
      collections: [],
      records: [],
      isLoading: true
    }
  },
  computed: {
    filteredCollections() {
      let searchCriteria = this.$store.state.searchCriteria;
      let searchRequest = this.$store.state.searchRequest;
      let filteredCollections = [];
      let namesOfFilteredCollections = [];

      if (searchRequest != '') {
        if (searchCriteria == 'Name') {
          filteredCollections = this.collections.filter(collection => collection.collectionName.toLowerCase().includes(searchRequest.toLowerCase()));
        } else {
          this.records.forEach(record => {
            let isPresent = false;
            if (searchCriteria == 'Artist') {
              record.artists.forEach(artist => {
                if (artist.artistName.toLowerCase().includes(searchRequest.toLowerCase())) {
                  isPresent = true
                }
              })
            } else {
              record.genres.forEach(genre => {
                if (genre.genreName.toLowerCase().includes(searchRequest.toLowerCase())) {
                  isPresent = true
                }
              })
            }

            if (isPresent) {
              record.collections.forEach(collection => {
                if (!namesOfFilteredCollections.includes(collection.collectionName)) {
                  namesOfFilteredCollections.push(collection.collectionName);
                  filteredCollections.push(collection)
                }
              })
            }
          })
        }
      } else {
        filteredCollections = this.collections;
      }

      return filteredCollections;
    }
  },
  created() {
    CollectionsService.getCollectionsByUserId(this.$store.state.user.id)
      .then(response => {
        this.collections = response.data;
        this.isLoading = false;
      })
    RecordService.getRecords()
      .then(r => {
        let retrievedRecords = r.data;
        this.records = retrievedRecords.filter(record => record.userId === this.$store.state.user.id)
      })
  }
};
</script>

<style scoped>
.collections {
  display: flex;
  flex-wrap: wrap;
  align-items: flex-start;
  align-content: flex-start;
  padding: 5px 0px 45px 5px;
  z-index: -3;
  background-image: url(../resources/Screenshot-2023-04-12-at-20.54.52.png);
  background-size: cover;
  height: 100%;
}
</style>
