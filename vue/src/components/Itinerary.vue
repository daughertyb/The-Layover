<template>
  <div>
    <header>
    <div>
    <h1>My Itinerary</h1>
<<<<<<< HEAD
    <!-- {{ this.selectedLandmark }} -->
    <br>
          <p> Directions</p>
     
  
  
=======
 
     
    
    <section id="startPoint">
>>>>>>> 8e0e04faa2beb41b4bd09833e787b86dfdd43b0c
      <select v-model="name" v-on:change="googleRouteBuilderStart($event)">
        <option :value="''" disabled selected>Starting Location</option>
        <option
          v-for="option in $store.state.selectedLandmarks"
          v-bind:key="option.id"
        >
          {{ option.name }}
        </option>
      </select>

   
    </div>
    </header>
  

<table>
    <tr v-for="option in $store.state.selectedLandmarks" v-bind:key="option.id">
      <h2>{{ option.startPoint }}</h2>

      <h2>{{ option.endPoint }}</h2>
  
        <h2>{{ option.name }}</h2>
    
   

<br>
      <img id="landmark-imgs" :src="option.images" /><p>{{option.description}}</p>

      <div>
        <input
          type="checkbox"
          v-on:change="
            selectLandmark(
              option.name,
              option.images,
              option.venueType,
              option.description,
              option.startPoint,
              option.endPoint,
              option.waypoints
            )
          "
          v-bind:id="option.id"
          v-bind:value="option.id"
        />Remove From Itinerary
      </div>
      <br />
     
    </tr>
</table>
<div  class="mapDirection">
    <MapDirection></MapDirection>
</div>
    <!-- <header>Header</header>
    <div id="main">
      <article>Article</article>
      <nav>Nav</nav>
      <aside>Aside</aside>
    </div>
    <footer>Footer</footer> -->


  </div>
</template>

<script>
import MapDirection from "./ItineraryDirections.vue";
export default {
  components: {
    MapDirection,
  },
  data() {
    return {
      waypoints: [],
      selectedLandmark: {
        name: "",
        images: "",
        venueType: "",
        description: "",
        startPoint: "",
        waypoints: "",
        endPoint: "",
      },
    };
  },

  methods: {
    selectLandmark(n, i, v, d, start, e, w) {
      this.selectedLandmark.name = n;
      this.selectedLandmark.images = i;
      this.selectedLandmark.venueType = v;
      this.selectedLandmark.description = d;
      this.selectedLandmark.startPoint = start;
      this.selectedLandmark.endPoint = e;
      this.selectedLandmark.waypoints = w;

      this.$store.commit("REMOVELANDMARK", this.selectedLandmark.name);
    },

    googleRouteBuilderStart(event) {
      let firstDestination = event.target.value;

      // make a copy of the store.state.selectedLandmarks array
      let landMarksArr = [];
      for (let i = 0; i < this.$store.state.selectedLandmarks.length; i++) {
        landMarksArr.push(this.$store.state.selectedLandmarks[i]);
      }

      let firstDestinationObj = {};
      let firstDestinationObjIndex = -123;

      for (let i = 0; i < landMarksArr.length; i++) {
        if (landMarksArr[i].name === firstDestination) {
          firstDestinationObj = landMarksArr[i];
          firstDestinationObjIndex = i;
        }
      }
      landMarksArr.splice(firstDestinationObjIndex, 1);
      landMarksArr.unshift(firstDestinationObj);

      console.log(landMarksArr);
    },

<<<<<<< HEAD
    googleRouteBuilder() {
      for (let i = 0; i < this.$store.state.selectLandmark.length; i++) {
          waypoints.push(this.$store.state.selectLandmark.waypoints);
      }
=======
>>>>>>> 8e0e04faa2beb41b4bd09833e787b86dfdd43b0c
    },

    getDirections() {
      // this.$store.commit('ADDSELECTEDLANDMARKS', this.selectedLandmarks);
      this.$router.push("/itinerary-directions");
      // drive
      // dont stop
      // just go
    },
  
};
</script>
<style scoped>
#venueType {
  font-weight: 500;
}

#landmark-imgs {
  padding-bottom: 20px;
  height: 200px;
  width: 200px;
  border-radius: 20%;

}

p {
   display:flex;
}

tr {
  display: flex;
}

.results {
  margin-top: 30px;
}

.mapDirection {
  display: flex;
  justify-content: center;
  border-radius: 15%;
}

table {
display: flex;
}

/* * {
  box-sizing: border-box;
}
body {
  display: flex;
  min-height: 100vh;
  flex-direction: column;
  margin: 0;
}

#directions{
font-size: 2rem;
}

#main {
  display: flex;
  flex: 1;
}
#main > article {
  flex: 1;
}
#main > nav,
#main > aside {
  flex: 0 0 20vw;
  background: beige;
}
#main > nav {
  order: -1;
}
header,
footer {
  background: yellowgreen;
  height: 20vh;
}
header,
footer,
article,
nav,
aside {
  padding: 1em;
} */
</style>