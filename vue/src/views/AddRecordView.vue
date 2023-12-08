<template>
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
     
</template>

<script>
    export default {
        
    }
</script>

<style scoped>

</style>