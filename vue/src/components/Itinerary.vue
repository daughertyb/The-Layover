<template>
  <div>
    <h1>My Itinerary</h1>
    {{this.selectedLandmark}}
    <div>
      <div class="directions">
        <div
          class="btn btn-one"
          v-on:click="getDirections"
          router-link="/itinerary-directions"
        >
          <span> Directions</span>
        </div>
      </div>
    </div>
    <section id="startPoint">
      <select v-model="name" v-on:change="googleRouteBuilderStart($event)">
        <option :value="''" disabled selected>Starting Location</option>
        <option
          v-for="option in $store.state.selectedLandmarks"
          v-bind:key="option.id"      
        >
          {{ option.name }}
        </option>
      </select>

      <select>
        <option :value="''" disabled selected>End Location</option>
        <option
          v-for="option in $store.state.selectedLandmarks"
          v-bind:key="option.id"
        >
          {{ option.name }}
        </option>
      </select>
    </section>

    <tr v-for="option in $store.state.selectedLandmarks" v-bind:key="option.id">
      <h2>{{ option.startPoint }}</h2>

      <h2>{{ option.endPoint }}</h2>

      <div class="results">
        <h2>{{ option.name }}</h2>
      </div>

      <div id="venueType">
        <br />
        {{ option.venueType }}
      </div>
      <br />
      <img id="landmark-imgs" :src="option.images" />


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
              option.endPoint
            )
          "
          v-bind:id="option.id"
          v-bind:value="option.id"
        />Remove From Itinerary
      </div>
      <br />
      <div id="landmark-description">
        {{ option.description }}
      </div>
    </tr>
    <MapDirection ></MapDirection>

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
import MapDirection from "./ItineraryDirections.vue"
export default {
   components: {
    MapDirection
  },
  data() {
    return {
      selectedLandmark: {
        name: "",
        images: "",
        venueType: "",
        description: "",
        startPoint: "",
        endPoint: "",
      },
    };
  },

  methods: {
    selectLandmark(n, i, v, d, start, e) {
      this.selectedLandmark.name = n;
      this.selectedLandmark.images = i;
      this.selectedLandmark.venueType = v;
      this.selectedLandmark.description = d;
      this.selectedLandmark.startPoint = start;
      this.selectedLandmark.endPoint = e;

      this.$store.commit("REMOVELANDMARK", this.selectedLandmark.name);
    },

    googleRouteBuilderStart(event) {
      let firstDestination = event.target.value;

      // make a copy of the store.state.selectedLandmarks array
      let landMarksArr = [];
      for (let i=0; i < this.$store.state.selectedLandmarks.length; i++) {
        landMarksArr.push(this.$store.state.selectedLandmarks[i]);
      }

      let firstDestinationObj = {};
      let firstDestinationObjIndex = -123;

      for (let i=0; i < landMarksArr.length; i++) {

        if (landMarksArr[i].name === firstDestination) {
          firstDestinationObj = landMarksArr[i];
          firstDestinationObjIndex = i;
        }
      } 

      landMarksArr.splice(firstDestinationObjIndex, 1);
      landMarksArr.unshift(firstDestinationObj);

      console.log(landMarksArr);



      // for (let i=0; i < this.$store.state.selectedLandmarks.length; i++) {
      //   if (this.$store.state.selectedLandmarks[i].name == value) {
      //     this.$store.state.selectedLandmarks.unshift(this.$store.state.selectedLandmarks[i]);
      //   }
      // }
    },

    getDirections() {
      // this.$store.commit('ADDSELECTEDLANDMARKS', this.selectedLandmarks);
      this.$router.push("/itinerary-directions");
      // drive
      // dont stop
      // just go
    },
  },
};
</script>

<style scoped>
#venueType {
  font-weight: 500;
}

#landmark-imgs {
  padding-bottom: 20px;
  padding-left: 32%;
}

.results {
  margin-top: 30px;
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