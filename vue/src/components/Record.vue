

<template>
    <div class="record-card card-deck">
        <router-link :to="{ name: 'recordDetail', params: { recordId: record.recordId } }"
            @click="setCurrentRecordId(record.recordId)" class="router-link-custom">
            <div class="card">
                <img class="card-img-top" id="record-picture" :src="recordCover" @error="replaceWithDefault()">
                <div class="card-body">
                    <h5 class="card-title">{{ record.albumName }}</h5>
                    <!-- <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional
                    content. This content is a little bit longer.</p> -->
                </div>
                <div class="card-footer">
                    <small class="text-muted">{{ record.releaseDate }}</small>
                </div>
            </div>
        </router-link>
    </div>
</template>
  
<script>
import RecordDetailView from '../views/RecordDetailView.vue';

export default {
    props: ['record'],
    data() {
        return {
            defaultCoverArt: 'https://static.tumblr.com/exbflx8/z13m20ek0/cover.png',
            useDefaultCoverArt: false
        }
    },
    computed: {
        recordCover() {
            return this.record.albumCover === null || this.useDefaultCoverArt ? this.defaultCoverArt : this.record.albumCover;
        }
    },
    methods: {
        replaceWithDefault() {
            this.useDefaultCoverArt = true;
        },
        setCurrentRecordId(recordId) {
            this.$store.commit("SET_CURRENT_RECORD", recordId);
        }
    }
};
</script>

<style scoped>
.record-card {
    margin: 5px 5px 5px 5px;
    width: 16%;
    background-color: rgba(255, 255, 255, .5);
    opacity: 90%;
    border-radius: 1.5rem;
}

.card-body {
    min-height: 5.5rem;
    max-height: 5.5rem;
    display: flex;
    justify-content: center;
    align-items: center;
}

.card-title {
    text-align: center;

}

.router-link-custom {
    text-decoration: none;
    color: inherit;
}

#record-picture {
    max-height: 15rem;
    min-height: 15rem;
}
</style>