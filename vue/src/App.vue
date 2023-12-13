<template>
  <div id="home-page">
    <!-- bootsstrap nav bar -->
    <nav id="header" class="navbar navbar-expand-lg navbar-light bg-dark">
      <a id="page-title" class="header-piece navbar-brand text-white" href="#"><img src="./resources/Screenshot 2023-12-13 105903.png" id="logoPicture"/>SpoTEfy</a>
      
      <nav class="header-piece navbar navbar-light" id="search-component">
        <select class="form-select" aria-label="Default select example" id="search-criteria" v-model="searchCriteria"
          @change="setSearchCriteria()">
          <option value="Name">Collection Name</option>
          <option value="Genre">Genre</option>
          <option value="Artist">Artist</option>
        </select>
        <form id="search-bar" class="form-inline">
          <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search"
            v-model="searchRequest">
          <button class="search-btn btn my-2 my-sm-0" id="button-search" type="button" @click.prevent="setSearchRequest()">Search</button>
        </form>
      </nav>

      <div class="header-piece">
        <router-link v-show="!isAuthenticated" type="button" id="sign-up-btn" class="btn btn-primary btn-lg"
          v-bind:to="{ name: 'register' }">Sign
          Up</router-link>
        <h2 v-if="isAuthenticated" id="displayName">{{ $store.state.user.username }}</h2>

        <router-link v-if="!isAuthenticated" :to="{ name: 'login' }" class="btn btn-secondary btn-lg">Login </router-link>
        <router-link v-if="isAuthenticated" :to="{ name: 'logout' }" class="logout btn btn-secondary btn-lg">Log Out
        </router-link>
      </div>
    </nav>

    <div id="nav-bar" class="d-flex flex-column flex-shrink-0 p-3 text-white bg-dark">
      <hr>
      <h2 id="locationName">{{ currentLocation }}</h2>
      <hr>
      <ul class="nav flex-column mb-auto">
        <li class="nav-item">
          <router-link to="/" class="home-btn nav-link" :class="{active: $route.path === '/'}" @click="changeLocation('Home')">
            <svg class="bi me-2" width="16" height="16">
              <use xlink:href="#home"></use>
            </svg>
            Home
          </router-link>
        </li>
        <li v-if="isAuthenticated">
          <router-link :to="{ name: 'library', params: { userId: getUserId() } }" class="home-btn nav-link" :class="{active: $route.name === 'library'}"
            v-on:click="changeLocation('Personal Library')">
            <svg class="bi me-2" width="16" height="16">
              <use xlink:href="#library"></use> 
              <!-- possible change back to whatever was here before -->
            </svg>
            Personal Library
          </router-link>
        </li>
        <li v-if="isAuthenticated">
          <router-link :to="{ name: 'collections', params: { userId: getUserId() } }" class="home-btn nav-link" :class="{active: $route.name === 'collections'}"
            @click="changeLocation('Personal Collections')">
            <svg class="bi me-2" width="16" height="16">
              <use xlink:href="#table"></use>
            </svg>
            Personal Collections
          </router-link>
        </li>
        <li v-if="isAuthenticated">
          <router-link :to="{ name: 'addCollection' }" class="home-btn nav-link"
            :class="{ disactive: !canAddMoreCollections, active: $route.name === 'addCollection' }" @click="changeLocation('Add Collection')">
            <svg class="bi me-2" width="16" height="16">
              <use xlink:href="#grid"></use>
            </svg>
            Add Collection
          </router-link>
        </li>
        <li v-if="isAuthenticated">
          <router-link :to="{ name: 'addrecord' }" class="home-btn nav-link" :class="{ disactive: !canAddMoreRecords, active: $route.name === 'addrecord' } "
            @click="changeLocation('Add Record')">
            <svg class="bi me-2" width="16" height="16">
              <use xlink:href="#people-circle"></use>
            </svg>
            Add Record
          </router-link>
        </li>
      </ul>
      <hr>
      <!-- <div class="dropdown">
        <a href="#" class="d-flex align-items-center text-white text-decoration-none dropdown-toggle" id="dropdownUser1"
          data-bs-toggle="dropdown" aria-expanded="false">
          <img src="https://github.com/mdo.png" alt="" width="32" height="32" class="rounded-circle me-2">
          <strong>mdo</strong>
        </a>
        <ul class="dropdown-menu dropdown-menu-dark text-small shadow" aria-labelledby="dropdownUser1">
          <li><a class="dropdown-item" href="#">New project...</a></li>
          <li><a class="dropdown-item" href="#">Settings</a></li>
          <li><a class="dropdown-item" href="#">Profile</a></li>
          <li>
            <hr class="dropdown-divider">
          </li>
          <li><a class="dropdown-item" href="#">Sign out</a></li>
        </ul>
      </div> -->
    </div>

    <div id="router-view">
      <router-view />
    </div>

    <footer id="footer" class="bg-dark footer">
      <p>© SpoTEfy 2023</p>
    </footer>

  </div>
</template>

<script>
import CollectionsService from './services/CollectionsService';
import RecordService from './services/RecordService';

export default {
  data() {
    return {
      numOfCollections: -1,
      numOfRecords: -1,
      searchCriteria: 'Name',
      searchRequest: ''
    };
  },
  computed: {
    isAuthenticated() {
      return this.$store.state.token !== '';
    },
    canAddMoreCollections() {
      return (this.$store.state.user.membershipTier === 'premium' || this.getNumOfCollections() < 1);
    },
    canAddMoreRecords() {
      return (this.$store.state.user.membershipTier === 'premium' || this.getNumOfRecords() < 25);
    },
    currentLocation() {
      return this.$store.state.location;
    }
  },
  methods: {
    getUserId() {
      return this.$store.state.user.id;
    },
    logOut() {
      this.$store.commit('LOGOUT');
    },
    getNumOfCollections() {
      CollectionsService.getNumOfCollectionsByUserId(this.getUserId()).then(r => { this.numOfCollections = r.data });
      return this.numOfCollections;
    },
    getNumOfRecords() {
      RecordService.getNumOfRecordsByUserId(this.getUserId()).then(r => { this.numOfRecords = r.data });
      return this.numOfRecords;
    },
    changeLocation(location) {
      this.$store.commit("SET_LOCATION", location);
    },
    setSearchCriteria() {
      this.$store.commit('SET_SEARCH_CRITERIA', this.searchCriteria);
    },
    setSearchRequest() {
      this.$store.commit('SET_SEARCH_REQUEST', this.searchRequest)
    }
  }
}
</script>

<style scoped>
#home-page {
  display: grid;
  grid-template-columns: 16% 84%;
  grid-template-areas:
    "header header"
    "nav router-view"
    "footer footer"
  ;
  grid-template-rows: 80px auto 40px;
  height: 100%;
}

#header {
  position: fixed;
  top: 0px;
  width: 100%;
  height: cover;
  overflow-x: hidden;
  display: flex;
  justify-content: space-between;
  grid-area: header;
  z-index: 3;
}

#page-title {
  justify-content: center;
  font-size: x-large;
  font-weight: bolder;
}

#search-bar {
  display: flex;
  width: 65%;
}

#search-component {
  width: 25%;
  display: flex;
  flex-wrap: nowrap;
}

#search-criteria {
  width: 35%;
}

.header-piece {
  width: 16%;
  display: flex;
}

#sign-up-btn,
#login-btn {
  width: 35%;
  margin-right: 10%;
}

#nav-bar {
  /* width: 100%; */
  grid-area: nav;
  position: fixed;
  width: 16%;
  top: 80px;
  bottom: 40px;
  left: 0px;
  
}

#router-view {
  grid-area: router-view;
}

#footer {
  position: fixed;
  bottom: 0px;
  width: 100%;
  height: 40px;
  overflow-x: hidden;
  grid-area: footer;
  z-index: 3;
}

#sign-up-btn {
  background-color: #E5B80B;
  border-color: #E5B80B;
}

#sign-up-btn:hover {
  background-color: #c09b09;
  border-color: white;
}

#login-btn:hover {
  border-color: white;
  background-color: #c09b09;
}

.search-btn {
  border-color: #E5B80B;
  color: #E5B80B;
}

.search-btn:hover {
  background-color: #E5B80B;
  color: white;
}

.home-btn {
  color: white;
}

.active {
  background-color: #E5B80B;
  border-radius: 0.375rem;
}
.home-btn:hover {
  background-color: #c09b09;
  color: white;
}

.nav-btn {
  color: white;
}

.nav-btn:hover {
  color: #E5B80B;
}

.btn-secondary {
  background-color: #E5B80B;
}

.btn-secondary:hover {
  background-color: #c09b09;
  border-color: white;
}

.footer {
  color: white;

}

.footer p {
  margin-left: 1rem;
}
</style>

<style>
#app {
  height: 100vh;
}

#displayName {
  color: white;
  position: fixed;
  top: 20px;
  right: 10.5%;
}

.logout {
  margin-left: 45%;
}

.disactive {
  pointer-events: none;
  opacity: 40%;
}

#locationName {
  text-align: center;
  font-size: 30px;
}

#search-bar {
 padding: 0.5rem;
}

#button-search {
  margin: 0.5rem;
}

#logoPicture {
  max-height: 3rem;
  max-width: 3rem;
  border-radius: .5rem;
  margin-right: 1rem;
  filter: brightness(110%) saturate(150%) hue-rotate(0deg);
}


</style>
