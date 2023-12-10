<template>
    
    <div data-bs-spy="scroll" data-bs-target="#navbar-example2" data-bs-root-margin="0px 0px -40%"
        data-bs-smooth-scroll="true" class="library scrollspy-example bg-body-tertiary rounded-2" tabindex="0">
        <record v-for="record in records" v-bind:key="record.recordId" v-bind:record="record" />
    </div>

</template>
  
<script>
import Record from '../components/Record.vue';
import RecordService from '../services/RecordService';


export default {
    components: {
        Record,
    },
    data() {
        return {
            records: []
        }
    },

    created() {
        RecordService.getRecordsByUserId(this.$store.state.user.id)
            .then(response => {
                this.records = response.data;
            })
    }
};
</script>

<style scoped>
.library {
    display: flex;
    flex-wrap: wrap;
    align-items: flex-start;
    align-content: flex-start;
    padding: 5px 0px 45px 5px;
    z-index: -3;
    height: 100%;
    background-image: url(../resources/ezgif.com-gif-maker-10-.jpg);
    background-size: cover;

}


</style>