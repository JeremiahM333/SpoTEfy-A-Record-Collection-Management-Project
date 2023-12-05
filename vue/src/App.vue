<template>
<<<<<<< HEAD
  <div class="container">
    <div v-bind:class="notificationClass" v-show="notification" v-on:click="clearNotification">
      {{ notification?.message }}
    </div>
  </div>
  <div id="capstone-app">



    <router-view />
=======
  <div id="home-page">
    <!-- bootsstrap nav bar -->
    <nav id="header" class="navbar navbar-expand-lg navbar-light bg-dark">
      <a id="page-title" class="header-piece navbar-brand text-white" href="#">ΣpoTEfy</a>
      <nav class="header-piece navbar navbar-light">
        <form id="search-bar" class="form-inline">
          <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
          <button class="search-btn btn my-2 my-sm-0" type="submit">Search</button>
        </form>
      </nav>
      <div class="header-piece">
        <button type="button" id="sign-up-btn" class="btn btn-primary btn-lg">Sign Up</button>
        <button type="button" id="login-btn" class="btn btn-secondary btn-lg">Login</button>
      </div>
    </nav>

    <div id="nav-bar" class="d-flex flex-column flex-shrink-0 p-3 text-white bg-dark">
      <hr>
      <ul class="nav flex-column mb-auto">
        <li class="nav-item">
          <router-link to="/" class="home-btn nav-link active" aria-current="page">
            <svg class="bi me-2" width="16" height="16">
              <use xlink:href="#home"></use>
            </svg>
            Home
          </router-link>
        </li>
        <li>
          <router-link :to="{ name: 'library', params: { userId: getUserId() } }" class="nav-btn nav-link">
            <svg class="bi me-2" width="16" height="16">
              <use xlink:href="#speedometer2"></use>
            </svg>
            Personal Library
          </router-link>
        </li>
        <li>
          <router-link :to="{ name: 'collections', params: { userId: getUserId() } }" class="nav-btn nav-link">
            <svg class="bi me-2" width="16" height="16">
              <use xlink:href="#table"></use>
            </svg>
            Personal Collections
          </router-link>
        </li>
        <li>
          <router-link to="/" class="nav-btn nav-link">
            <svg class="bi me-2" width="16" height="16">
              <use xlink:href="#grid"></use>
            </svg>
            Add Collection
          </router-link>
        </li>
        <li>
          <router-link to="/" class="nav-btn nav-link">
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
      <!-- <div id="nav">
        <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
        <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
      </div> -->
      <router-view />
    </div>

    <footer id="footer" class="bg-dark">

    </footer>
>>>>>>> 859f23e61dd2e017175d1b47877c67dbd4c9f752
  </div>
</template>

<script>
<<<<<<< HEAD

export default {

  computed: {

    notification() {
      return this.$store.notification;
    },
    notificationClass() {
      return {
        'status-message': true,
        error: this.notification?.type?.toLowerCase() === 'error',
        success: this.notification?.type?.toLowerCase() === 'success'
      };
    },
  },
  methods: {
    clearNotification() {
      this.$store.commit('CLEAR_NOTIFICATION');
    },
  }
}

</script>
=======
export default {
  data() {
    return {};
  },
  methods: {
    getUserId() {
      return this.$store.state.user.userId;
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
  height: 80px;
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
  background-color: #E5B80B;
  border-radius: 0.375rem;
  color: white;
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
</style>

<style>
#app {
  height: 100vh;
}
</style>
>>>>>>> 859f23e61dd2e017175d1b47877c67dbd4c9f752
