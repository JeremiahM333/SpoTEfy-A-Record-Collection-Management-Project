<template>
    <!-- <div>
        <h1>{{ record.albumName }}</h1>
    </div>
    <div>
        <img src={{ record.albumCover }} />
    </div>
    <div>
        <p>{{ record.releaseDate }}</p>
    </div>
    <div>
        <h2>{{ record.mediaType }}</h2>
    </div> -->
    <!-- <div>
        <h2>{{ }}</h2>
    </div>
    // artist in the div above
    <div>
        <h3>{{ }}</h3>
    </div>
    // genre is the div above
    <div>
        <p></p>
    </div>
    // add notes div for record detail (this is a separate card) -->

    <div class="container">

        <!-- <div class="card">
            <div class="card-body">
                <h5 class="card-title">{{ record.albumName }}</h5>
            </div>
            <img class="card-img-top" :src="record.albumCover" @error="replaceWithDefault()">
            <div class="card-footer">
                <small class="text-muted">{{ record.releaseDate }}</small>
            </div>
        </div> -->

        <div class="card" style="width: 18rem;">
            <img class="card-img-top" :src="record.albumCover" @error="replaceWithDefault()">
            <div class="card-body">
                <h5 class="card-title">{{ record.albumName }}</h5>
            </div>
            <ul class="list-group list-group-flush">
                <li class="list-group-item">Artist</li>
                <li class="list-group-item">Genre</li>
                <li class="list-group-item">{{ record.releaseDate }}</li>
                <p class="card-text">This will be the notes section for the card.</p>
            </ul>
            <div class="dropdown">
                <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton1"
                    data-bs-toggle="dropdown" aria-expanded="false">
                    Choose Collection
                </button>
                <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
                    <li><a class="dropdown-item" href="#">Collection1</a></li>
                    <li><a class="dropdown-item" href="#">Collection2</a></li>
                    <li><a class="dropdown-item" href="#">Collection3</a></li>
                </ul>
            </div>
            <div class="card-body">
                <button type="button" class="btn btn-secondary btn-lg" disabled>Add to Collection</button>
                <button type="button" class="btn btn-secondary btn-lg" disabled>Edit Record Notes</button>
                <button type="button" class="btn btn-secondary btn-lg" disabled>Exit Detail View</button>
            </div>
            
        </div>

    </div>
</template>


<script>

import RecordService from '../services/RecordService';

export default {
    data() {
        return {
            record: [],
        }
    },
    created() {
        RecordService.getRecordByRecordId(this.$store.state.currentRecord)
            .then(response => {
                this.record = response.data;
            })
    }


}

</script>



<style scoped></style>