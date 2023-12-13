<template>
    <div class="collection-card">
        <router-link :to="{ name: 'records', params: { collectionId: collection.collectionId } }"
            @click="setCurrentCollectionId(collection.collectionId), changeLocation('Collection Details')" class="router-link-custom">
            <div class="card text-center">
                <img :src="collectionCover" class="card-img-top" id="card-picture" @error="replaceWithDefault()">
                <div class="card-body" id="title-body">
                    <h4 class="card-text">{{ collection.collectionName }}</h4>
                </div>
            </div>
        </router-link>
    </div>

    <div>


    </div>
</template>
  
<script>
export default {
    props: ['collection'],
    data() {
        return {
            defaultCoverArt: 'https://cdn3.iconfinder.com/data/icons/ios-edge-glyph-1/25/Album-Collection-512.png',
            useDefaultCoverArt: false
        }
    },
    computed: {
        collectionCover() {
            return this.collection.collectionCover === null || this.useDefaultCoverArt ? this.defaultCoverArt : this.collection.collectionCover;
        }
    },
    methods: {
        setCurrentCollectionId(collectionId) {
            this.$store.commit("SET_CURRENT_COLLECTION", collectionId);
        },
        replaceWithDefault() {
            this.useDefaultCoverArt = true;
        },
        changeLocation(location) {
            this.$store.commit("SET_LOCATION", location);
        }
    }
};
</script>

<style scoped>
.collection-card {
    margin: 5px 5px 5px 5px;
    width: 16%;
    opacity: 90%;
    border-radius: 1.5rem;
    

}

.card-text {
    text-align: center;
    text-decoration: none;
    text-transform: none;
    min-height: 6rem;
    max-height: 6rem;
    
}

#card-picture {
    max-height: 15rem;
    min-height: 15rem;
    
}

#title-body {
    align-items: center;
}

.router-link-custom {
    text-decoration: none;
    color: inherit;
}
</style>
  