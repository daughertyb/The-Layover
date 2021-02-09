<template>
  <div class="hello">
    <Header />
    <div class="container mrgnbtm">
          <div class="row">
            <div class="col-md-4">
               <h1> {{travelDirections}} </h1>
                <h1> {{landmarkCoordinates.latitude}} </h1>
                 <h1> {{landmarkCoordinates.longitude}} </h1>
            </div>
          </div>
    </div>
  </div>
</template>
<script>
import cityAPI from "@/services/APIServices.js";
export default {
    data() {
        return {
        travelDirections: {
            origin: "",
            destination: "",
            waypoints: [],
        },
        landmarkCoordinates: {
            latitude: "",
            longitude: "",
        },
    
        };
    },
    created() {
        cityAPI
        .generateTravelRoute()
        .then((response) => {
        this.travelDirections = response.data;
      })
      .catch((error) => {
        if (error.response) {
          ("Sorry, we're unable to generate a travel route for you at this time.");
        }
      });

      cityAPI.getAllLandmarks().then((response) => {
      this.landmarkCoordinates = response.data;
    });
    },
    methods() {

    }
    
}
</script>