<template>
    <div data-bs-spy="scroll" data-bs-target="#navbar-example2" data-bs-root-margin="0px 0px -40%"
        data-bs-smooth-scroll="true" class="collection scrollspy-example bg-body-tertiary rounded-2" tabindex="0">
        <record class="record-card" v-for="record in this.records" v-bind:key="record.recordId" v-bind:record="record" />
    </div>
</template>
  
<script>
import Record from '../components/Record.vue'
import RecordService from '../services/RecordService';

export default {
    components: {
        Record
    },
    data() {
        return {
            records: [
                {
                    recordId: 1,
                    albumName: 'test',
                    albumCover: 'https://static.tumblr.com/exbflx8/z13m20ek0/cover.png',
                    releaseDate: 'April 22, 2001'
                },
                {
                    recordId: 2,
                    albumName: 'test',
                    albumCover: 'https://static.tumblr.com/exbflx8/z13m20ek0/cover.png',
                    releaseDate: 'January 3, 2003'
                }
            ],
            isLoading: true
        }
    },
    created() {
        RecordService.getRecordsByCollectionId(this.$store.state.currentCollection)
            .then(response => {
                this.records = response.data;
                this.isLoading = false;
            })
    }
};
</script>

<style scoped>
.collection {
    display: flex;
    flex-wrap: wrap;
    align-items: flex-start;
    align-content: flex-start;
    padding: 5px 0px 0px 5px;
    z-index: -3;
}
</style>