<template>
  <div id="app">
    <h2>Google Direction</h2>

    <div id="map">
      <div id="toAndFrom">
        <div id="inputFrom">
          From:<input
            v-bind:from="originLandmark()"
            type="text"
            v-model="origin"
          />
        </div>
        <div id="inputTo">
          To:
          <input
            v-bind:to="destinationLandmark()"
            type="text"
            v-model="destination"
          />
        </div>
        <div id="mode">
          Mode:<input
            type="text"
            v-model="directionMode"
            v-bind:waypoints="addWaypoint()"
          />
        </div>
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
  props: ["landmarkmap"],

  name: "MapDirection",
  data() {
    return {
      directionMode: "driving",
      origin: "",
      destination: "",
      waypoints: "",

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

    originLandmark() {
      this.origin = this.$store.state.selectedLandmarks[0].coordinate;
    },
    destinationLandmark() {
      this.destination = this.$store.state.selectedLandmarks[
        this.$store.state.selectedLandmarks.length - 1
      ].coordinate;
    },

    addWaypoint() {
      if (this.$store.state.selectedLandmarks.length > 2) {
        for (
          let i = 1;
          i < this.$store.state.selectedLandmarks.length - 1;
          i++
        ) {
          this.url =
            this.url +
            "&waypoints=" +
            this.$store.state.selectedLandmarks[i].coordinate;
        }
      }
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
  background-color: #aadaff;
  width: 900px;
  border: saddlebrown 20px;
}

#toAndFrom {
  display: flex;
  flex-direction: column;
  justify-content: flex-start;
  align-items: flex-end;
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