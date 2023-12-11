<template>
  <div data-bs-spy="scroll" data-bs-target="#navbar-example2" data-bs-root-margin="0px 0px -40%"
    data-bs-smooth-scroll="true" class="home scrollspy-example bg-body-tertiary" tabindex="0">
    <collection v-for="collection in collections" v-bind:key="collection.collectionId" v-bind:collection="collection" />
  </div>
</template>

<script>
import Collection from '../components/Collection.vue'
import CollectionsService from '../services/CollectionsService'

export default {
  components: {
    Collection
  },
  data() {
    return {
      collections: [],
      isLoading: true
    }
  },
  created() {
    CollectionsService.getPublicCollections()
      .then(response => {
        this.collections = response.data;
        this.isLoading = false;
      })
  }
};

</script>

<style scoped>
.home {
  display: flex;
  flex-wrap: wrap;
  align-items: flex-start;
  align-content: flex-start;
  padding: 5px 0px 45px 5px;
  z-index: -3;
}
</style>
