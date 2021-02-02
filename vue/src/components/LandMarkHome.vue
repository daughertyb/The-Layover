<template>
    <div>
        
        {{landmark}}
        
        
        
      



    </div>


  
</template>

<script>
import Landmark from "@/services/AuthService.js"
export default {
    data(){
        return {
            landmark: []
        }
    },



created(){
    Landmark.allLandmark().then(response => {
        this.landmark = response.data;
    })
}
}
</script>


<style>

</style>