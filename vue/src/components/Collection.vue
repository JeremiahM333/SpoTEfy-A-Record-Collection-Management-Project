<template>
    <div class="collection-card">
        <router-link :to="{ name: 'records', params: { collectionId: collection.collectionId } }">
            <div class="card">
                <img :src="collection.collectionCover" class="card-img-top">
                <div class="card-body">
                    <h1 class="card-text">{{ collection.collectionName }}</h1>
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
        return {}
    }
};
</script>

<style scoped>
.collection-card {
    margin: 5px 5px 5px 5px;
    width: 16%;
}

.card-text {
    text-align: center;
    text-decoration: none;
    text-transform: none;
}
</style>
  