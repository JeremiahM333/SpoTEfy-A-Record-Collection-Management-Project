

<template>
    <div class="record-card card-deck">
        <div class="card">
            <img class="card-img-top" :src="record.albumCover" alt="Card image cap">
            <div class="card-body">
                <h5 class="card-title">{{ record.albumName }}</h5>
                <!-- <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional
                    content. This content is a little bit longer.</p> -->
            </div>
            <div class="card-footer">
                <small class="text-muted">{{ record.releaseDate }}</small>
            </div>
        </div>
    </div>
</template>
  
<script>
export default {
    props: ['record'],
    data() {
        return {}
    }
};
</script>

<style scoped>
.record-card {
    margin: 5px 5px 5px 5px;
    width: 16%;
}

.card-title {
    text-align: center;
}
</style>