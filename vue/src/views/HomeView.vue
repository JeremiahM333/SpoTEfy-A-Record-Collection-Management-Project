<template>
  <div data-bs-spy="scroll" data-bs-target="#navbar-example2" data-bs-root-margin="0px 0px -40%"
    data-bs-smooth-scroll="true" class="home scrollspy-example bg-body-tertiary rounded-2" tabindex="0">
    <collection class="collection-card" v-for="collection in this.collections" v-bind:key="collection.collectionId"
      v-bind:collection="collection" />
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
      collections: [
        {
          collectionId: 1,
          collectionName: 'test',
          collectionCover: 'https://static.tumblr.com/exbflx8/z13m20ek0/cover.png'
        },
        {
          collectionId: 2,
          collectionName: 'test',
          collectionCover: 'https://static.tumblr.com/exbflx8/z13m20ek0/cover.png'
        },
        {
          collectionId: 3,
          collectionName: 'test',
          collectionCover: 'https://static.tumblr.com/exbflx8/z13m20ek0/cover.png'
        },
        {
          collectionId: 4,
          collectionName: 'test',
          collectionCover: 'https://static.tumblr.com/exbflx8/z13m20ek0/cover.png'
        },
        {
          collectionId: 5,
          collectionName: 'test',
          collectionCover: 'https://static.tumblr.com/exbflx8/z13m20ek0/cover.png'
        },
        {
          collectionId: 6,
          collectionName: 'test',
          collectionCover: 'https://static.tumblr.com/exbflx8/z13m20ek0/cover.png'
        },
        {
          collectionId: 7,
          collectionName: 'test',
          collectionCover: 'https://static.tumblr.com/exbflx8/z13m20ek0/cover.png'
        },
        {
          collectionId: 8,
          collectionName: 'test',
          collectionCover: 'https://static.tumblr.com/exbflx8/z13m20ek0/cover.png'
        },
        {
          collectionId: 9,
          collectionName: 'test',
          collectionCover: 'https://static.tumblr.com/exbflx8/z13m20ek0/cover.png'
        },
      ],
      // isLoading: true
    }
  },
  created() {
    CollectionsService.getCollections()
      .then(response => {
        this.collections = response.date;
        // this.isLoading = false;
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
  padding: 5px 0px 0px 5px;
  z-index: -3;
}
</style>
