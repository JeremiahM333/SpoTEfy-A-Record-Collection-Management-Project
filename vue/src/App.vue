<template>
  <div id="home-page">
    <!-- bootsstrap nav bar -->
    <nav id="header" class="navbar navbar-expand-lg navbar-light bg-dark">
      <a id="page-title" class="header-piece navbar-brand text-white" href="#">ΣpoTEfy</a>
      <nav class="header-piece navbar navbar-light">
        <form id="search-bar" class="form-inline">
          <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
          <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
      </nav>
      <div class="header-piece">
        <button type="button" id="sign-up-btn" class="btn btn-primary btn-lg">Sign Up</button>
        <button type="button" id="login-btn" class="btn btn-secondary btn-lg">Login</button>
      </div>
    </nav>

    <div id="nav-bar" class="d-flex flex-column flex-shrink-0 p-3 text-white bg-dark">
      <hr>
      <ul class="nav nav-pills flex-column mb-auto">
        <li class="nav-item">
          <a href="#" class="nav-link active" aria-current="page">
            <svg class="bi me-2" width="16" height="16">
              <use xlink:href="#home"></use>
            </svg>
            Home
          </a>
        </li>
        <li>
          <a href="#" class="nav-link text-white">
            <svg class="bi me-2" width="16" height="16">
              <use xlink:href="#speedometer2"></use>
            </svg>
            Dashboard
          </a>
        </li>
        <li>
          <a href="#" class="nav-link text-white">
            <svg class="bi me-2" width="16" height="16">
              <use xlink:href="#table"></use>
            </svg>
            Orders
          </a>
        </li>
        <li>
          <a href="#" class="nav-link text-white">
            <svg class="bi me-2" width="16" height="16">
              <use xlink:href="#grid"></use>
            </svg>
            Products
          </a>
        </li>
        <li>
          <a href="#" class="nav-link text-white">
            <svg class="bi me-2" width="16" height="16">
              <use xlink:href="#people-circle"></use>
            </svg>
            Customers
          </a>
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

    <div id="capstone-app">
      <!-- <div id="nav">
        <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
        <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
      </div> -->
      <router-view />
    </div>

    <footer id="footer" class="bg-dark">

    </footer>
  </div>
</template>

<style scoped>
#home-page {
  display: grid;
  grid-template-columns: 16% 84%;
  grid-template-areas:
    "header header"
    "nav capstone-app"
    "footer footer"
  ;
  grid-template-rows: 80px auto 40px;
  height: 100%;
}

#header {
  display: flex;
  justify-content: space-between;
  grid-area: header;
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
  width: 100%;
  grid-area: nav;
}

#capstone-app {
  grid-area: capstone-app;
}

#footer {
  grid-area: footer;
}
</style>

<style>
#app {
  height: 100vh;
}
</style>