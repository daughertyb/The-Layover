<template>
  <div id="app">
    <div id="nav">
    
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link> |
      <router-link v-bind:to="{ name: 'allCities' }">All Cities</router-link>
    </div>
    <router-view />
  </div>
</template>
