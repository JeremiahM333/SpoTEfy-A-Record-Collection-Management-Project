<template>
<<<<<<< HEAD
  <div class="home">
    <h1>Home</h1>
    <p>Welcome to SpoTEfy</p>
=======
  <div data-bs-spy="scroll" data-bs-target="#navbar-example2" data-bs-root-margin="0px 0px -40%"
    data-bs-smooth-scroll="true" class="home scrollspy-example bg-body-tertiary rounded-2" tabindex="0">
    <collection class="collection-card" v-for="collection in this.collections" v-bind:key="collection.collectionId"
      v-bind:collection="collection" />
>>>>>>> 859f23e61dd2e017175d1b47877c67dbd4c9f752
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
          collectionName: 'test',
          collectionCover: 'https://static.tumblr.com/exbflx8/z13m20ek0/cover.png'
        },
        {
          collectionName: 'test',
          collectionCover: 'https://static.tumblr.com/exbflx8/z13m20ek0/cover.png'
        },
        {
          collectionName: 'test',
          collectionCover: 'https://static.tumblr.com/exbflx8/z13m20ek0/cover.png'
        },
        {
          collectionName: 'test',
          collectionCover: 'https://static.tumblr.com/exbflx8/z13m20ek0/cover.png'
        },
        {
          collectionName: 'test',
          collectionCover: 'https://static.tumblr.com/exbflx8/z13m20ek0/cover.png'
        },
        {
          collectionName: 'test',
          collectionCover: 'https://static.tumblr.com/exbflx8/z13m20ek0/cover.png'
        },
        {
          collectionName: 'test',
          collectionCover: 'https://static.tumblr.com/exbflx8/z13m20ek0/cover.png'
        },
        {
          collectionName: 'test',
          collectionCover: 'https://static.tumblr.com/exbflx8/z13m20ek0/cover.png'
        },
        {
          collectionName: 'test',
          collectionCover: 'https://static.tumblr.com/exbflx8/z13m20ek0/cover.png'
        },
        {
          collectionName: 'test',
          collectionCover: 'https://static.tumblr.com/exbflx8/z13m20ek0/cover.png'
        },
        {
          collectionName: 'test',
          collectionCover: 'https://static.tumblr.com/exbflx8/z13m20ek0/cover.png'
        },
        {
          collectionName: 'test',
          collectionCover: 'https://static.tumblr.com/exbflx8/z13m20ek0/cover.png'
        },
        {
          collectionName: 'test',
          collectionCover: 'https://static.tumblr.com/exbflx8/z13m20ek0/cover.png'
        },
        {
          collectionName: 'test',
          collectionCover: 'https://static.tumblr.com/exbflx8/z13m20ek0/cover.png'
        },
        {
          collectionName: 'test',
          collectionCover: 'https://static.tumblr.com/exbflx8/z13m20ek0/cover.png'
        },
        {
          collectionName: 'test',
          collectionCover: 'https://static.tumblr.com/exbflx8/z13m20ek0/cover.png'
        },
        {
          collectionName: 'test',
          collectionCover: 'https://static.tumblr.com/exbflx8/z13m20ek0/cover.png'
        },
        {
          collectionName: 'test',
          collectionCover: 'https://static.tumblr.com/exbflx8/z13m20ek0/cover.png'
        },

      ],
      isLoading: true
    }
  },
  created() {
    CollectionsService.getCollections()
      .then(response => {
        this.collections = response.date;
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
  padding: 5px 0px 0px 5px;
  z-index: -3;
}
</style>
