<template>
  <!-- <div id="register" class="text-center">
    <form v-on:submit.prevent="register">
      <h1>Create Account</h1>
      <div role="alert" v-if="registrationErrors">
        {{ registrationErrorMsg }}
      </div>
      <div class="form-input-group">
        <label for="username">Username</label>
        <input type="text" id="username" v-model="user.username" required autofocus />
      </div>
      <div class="form-input-group">
        <label for="password">Password</label>
        <input type="password" id="password" v-model="user.password" required />
      </div>
      <div class="form-input-group">
        <label for="confirmPassword">Confirm Password</label>
        <input type="password" id="confirmPassword" v-model="user.confirmPassword" required />
      </div>
      <button type="submit">Create Account</button>
      <p><router-link v-bind:to="{ name: 'login' }">Already have an account? Log in.</router-link></p>
    </form>
  </div> -->

  <!-- <div v-if="isLoading" class="text-center">
    <div class="container justify-content-end">
      <h1>SpoTEfy</h1>
      <div class="loading">
        <img src="../resources/giphy.gif">


      </div>
    </div>
  </div> -->

  <div id="main-page">

    <nav class="navbar navbar-dark bg-dark">
      <div class="container-fluid">

      </div>
    </nav>
    <div class="container" id="form-margin">
      <form :on-submit.prevent="regist">

        <h1 class="text-center" id="form-header">Create Account</h1>
        <div class="alert alert-danger" role="alert" v-if="registrationErrors">
          {{ registrationErrorMsg }}
        </div>
        <!-- <div class="alert alert-danger" role="alert">
          Invalid username and password!
        </div> -->
        <div class="mb-3">
          <label for="displayName" class="form-label">Display Name</label>
          <input type="text" class="form-control" id="displayName" aria-describedby="displayName" v-model="user.username" required autofocus >
        </div>
        <div class="mb-3">
          <label for="userEmail" class="form-label">Email address</label>
          <input type="email" class="form-control" id="userEmail" aria-describedby="emailHelp" v-model="user.emailAddress" required autofocus>
          <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
        </div>
        <div class="mb-3">
          <label for="password" class="form-label">Password</label>
          <input type="password" class="form-control" id="password" v-model="user.password" required  >
        </div>
        <div class="mb-3">
          <label for="confirmPassword" class="form-label">Confirm Password</label>
          <input type="password" class="form-control" id="confirmPassword"  v-model="user.confirmPassword" required>
        </div>
        <div class="mb-3">
        <select class="form-select" aria-label="Membership Tier" v-model="user.membershipTier">
            <option selected>Membership Tier</option>
            <option value="basic">Basic</option>
            <option value="premium">Premium</option>
      </select>
    </div>
      
        <button type="submit" class="btn btn-primary" id="submit-btn">Create Account</button>

       

      </form>
    </div>
  </div>
</template>

<script>
import authService from '../services/AuthService';

export default {
  data() {
    return {
      user: {
        username: '',
        password: '',
        confirmPassword: '',
        role: 'user',
        membershipTier: 'basic',
      },
      registrationErrors: false,
      registrationErrorMsg: 'There were problems registering this user.',
    };
  },
  methods: {
    register() {
      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = 'Password & Confirm Password do not match.';
      } else {
        authService
          .register(this.user)
          .then((response) => {
            if (response.status == 201) {
              this.$router.push({
                path: '/login',
                query: { registration: 'success' },
              });
            }
          })
          .catch((error) => {
            const response = error.response;
            this.registrationErrors = true;
            if (response.status === 400) {
              this.registrationErrorMsg = 'Bad Request: Validation Errors';
            }
          });
      }
    },
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = 'There were problems registering this user.';
    },
  },
};
</script>

<style scoped>

#form-margin {
  
  margin-top: 5rem;
  background-color: rgba(0, 0, 0, 0.5);
  color: white;
  border-radius: 1.5rem;
}

#main-page {
  background-image: url("../resources/pexels-miguel-á-padriñán-5764283.jpg");
  background-size: cover;
  height: 100vh
}

.form-input-group {
  margin-bottom: 1rem;
}

/* #main-page {
  background-image: url("../resources/vinyl-records_istock.jpg");
  background-size: cover;
  height: 100vh;
} */

.form-text {
  color: white;
}

.form-text {
  color:white;
}

#form-header {
  padding: 1rem;
}

#submit-btn {
  margin-bottom: 2rem;
  background-color: #E5B80B;
  border-color: #E5B80B;
  
}

#submit-btn:hover {
  background-color: #c09b09;
  border-color: white;
}


</style>
