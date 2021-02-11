<template>
  <div id="app">
  
    <h2>Google Direction</h2>
    
    <div id="map">
    
    <div id="toAndFrom">
      <div id="inputFrom">From:<input  type="text" v-model="origin" /></div>
      <div id="inputTo">To: <input  type="text" v-model="destination" /></div>
      <div id="mode">Mode:<input type="text" v-model="directionMode" /></div>
      
    </div>

    <iframe
      width="700px"
      height="500px"
      v-bind:src="src()"
      allowfullscreen
    ></iframe>
    </div>
    
  </div>
</template>

<script>
export default {
  
  name: "MapDirection",
  data() {
    return {
      directionMode: "driving",
      origin: "newark,DE",
      destination: "Wilmington,DE",

      url:
        "https://www.google.com/maps/embed/v1/directions?key=AIzaSyB5uhVBlG2NKfe8pT0rGiTpBkOr2JJjgLg",
    };
  },
  methods: {
    src: function () {
      return (
        this.url +
        "&origin=" +
        this.origin +
        "&destination=" +
        this.destination +
        "&mode=" +
        this.directionMode
      );
    },
  },
};
</script>
 

<style>


#app {
  display: flex;
  flex-direction: column;
  align-content: center;
  justify-content: center;
  margin: 40px;
  
  
  
}

#map {
  display: flex;
  padding: 10px;
  justify-content: center;
  align-items: center;
  background-color: #AADAFF ;
  width: 900px;
  border: saddlebrown 20px;
  
 
}

#toAndFrom{
  display: flex;
  flex-direction: column;
  justify-content:flex-start;
  align-items:flex-end;
  width: 300px;
  padding: 10px;
  
}

#inputFrom {
  display: flex;
  font-weight: bold;
  padding: 10px;
  
  
    
}
#inputTo {
  display: flex;
  font-weight: bold;
  padding: 10px;
    
}
#mode {
  display: flex;
  font-weight: bold;
  padding: 10px;
}

</style>