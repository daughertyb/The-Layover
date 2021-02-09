<template>
  <div>
    <h1>My Itinerary</h1>

    <div>
      <div class="directions">
        <div class="btn btn-one" v-on:click="getDirections" router-link="/">
          <span> Directions</span>
        </div>
      </div>
    </div>

    <tr v-for="option in $store.state.selectedLandmarks" v-bind:key="option.id">
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
              option.description
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
export default {
  data() {
    return {
      selectedLandmarks: [],
      selectedLandmark: {
        name: "",
        images: "",
        venueType: "",
        description: "",
      },
    };
  },

  methods: {
    selectLandmark(n, i, v, d) {
      this.selectedLandmark.name = n;
      this.selectedLandmark.images = i;
      this.selectedLandmark.venueType = v;
      this.selectedLandmark.description = d;

      this.$store.commit("REMOVELANDMARK", this.selectedLandmark.name);
    },

    getDirections(){
      // drive
      // dont stop
      // just go
    }
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