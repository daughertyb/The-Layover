<template>

<div id="app">
    <h2>Google Direction</h2>
        <h2>
        From: <input type="text" v-model="origin">
        To: <input type="text" v-model="destination"><br>
        DirectionMode: <input type="text" v-model="directionMode">
        Waypoint: <input type="text" v-model="waypoint">
 
            </h2>
     
        <iframe 
        width="700px" 
        height="500px" 
        v-bind:src="src()" allowfullscreen
        ></iframe>
     

    
  </div>
  
</template>

<script>export default {
  name: 'App',
  
  data(){

    return{
        directionMode:'driving',
        origin: 'wilmington. delaware',
        destination:'newark, delaware',
        waypoint:'bear, delaware',
           
        url:"https://www.google.com/maps/embed/v1/directions?key=AIzaSyB5uhVBlG2NKfe8pT0rGiTpBkOr2JJjgLg" ,
       
    }

  },
  methods: {
    src:function(){
     return this.url+"&origin="+this.origin+"&destination="+this.destination+"&mode="+this.directionMode+"&waypoints="+this.waypoint;

    }
  }
};

</script>
 

<style>

</style>