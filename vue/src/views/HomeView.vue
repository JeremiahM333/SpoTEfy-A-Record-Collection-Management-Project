<template>
  <div class="home">
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
  /* background-image: image(src="https://static.vecteezy.com/system/resources/previews/007/049/501/original/4-point-star-geometric-seamless-pattern-modern-vintage-random-red-green-color-design-on-cream-background-use-for-fabric-textile-interior-decoration-elements-upholstery-wrapping-free-vector.jpg"); */
  position: relative;
  top: 0px;
  width: 100%;
  height: 100%;
  z-index: -2;
  display: flex;
  flex-wrap: wrap;
  align-items: flex-start;
  align-content: flex-start;
  padding: 10px 0px 0px 10px;
  column-gap: 5px;
  row-gap: 10px;
}
</style>
