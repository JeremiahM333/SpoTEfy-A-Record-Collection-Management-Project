<template>
    <div class="card">
        <img :src="collection.collectionCover" class="card-img-top">
        <div class="card-body">
            <h1 class="card-text">{{ collection.collectionName }}</h1>
        </div>
    </div>
    <div>


    </div>
</template>
  
<script>
export default {
    props: ['collection']
};
</script>

<style scoped>
.card {
    width: 16.17%
}
</style>
  