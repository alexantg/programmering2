<template id="observation-detail">
    <div v-if="observation" class="detail-observation-container">

        <h1>{{observation.name}}</h1>
        <img v-if="observation.pictureUrl" class="cover-image" v-bind:src="observation.pictureUrl">
        <img v-else class="cover-image" src="https://upload.wikimedia.org/wikipedia/commons/thumb/d/d9/Icon-round-Question_mark.svg/480px-Icon-round-Question_mark.svg.png">
        <p>
           <p> <a class="button" :href="`/api/observations/${observation.name}/delete`">Delete</a>
        <br>
        <br>
        <p>
            This observation were made at {{observation.localDate}}. The animal(s) discovered where given the name
            {{animal.name}}, but it is actually called {{animal.scientificName}}. It was spotted {{observation.number}} of these
            <br>
            <br>
            <br>
            <a class="button" :href="`/observations/${observation.name.trim()}/animal`">Read more about this animal</a>

            <br>
            <br>
        </p>
        <p>
          The great discovery where made at the planet {{planet.name}}. This planet is roughly {{planet.radius}} km in
            radius. The location consists of: {{location.biomlistAsString}}

        </p>
        <p>
            Here is what the disvoverer had to say: {{observation.notes}}
        </p>
    </div>

</template>
<script>
    Vue.component("observation-detail", {
        template: "#observation-detail",
        data: () => ({
            observation: null,
            animal: null,
            location: null,
            planet:null
        }),
        created() {
            const observationId = this.$javalin.pathParams["observation-id"];
            const locationId= this.$javalin.pathParams["location-id"];

            console.log(observationId);
            fetch(`/api/observations/${observationId}`)
                .then(res => res.json())
                .then(res => {
                    this.observation= res;
                    this.location= this.observation.location;
                    this.animal= this.observation.animal
                })
                .catch(() => alert("EROR WHILE FETCHING OBSERVATION"));
             fetch(`/api/observations/${observationId}/${locationId}/planet`)
                 .then(res => res.json())
                 .then(res =>this.planet= res)
                 .catch(() => alert("EROR WHILE FETCHING PLANET"));
        }
    });
</script>
<style>
    ul{
        color:white;
    }
    div.detail-observation-container > p {
        max-width: 30em;
    }
    div.detail-observation-container{
        padding-top: 10px;
        overflow: hidden;
        width: 500px;
        background-color: white;
        color: black;
        margin: 0 auto;
        border: 1px solid black;
        opacity: 0.96;
        text-align: center;
        -webkit-box-shadow: 10px 10px 5px 0px rgba(0,0,0,0.25);
        -moz-box-shadow: 10px 10px 5px 0px rgba(0,0,0,0.25);
        box-shadow: 10px 10px 5px 0px rgba(0,0,0,0.25);
    }

    img.cover-image {
        height: 150px;
        width: 150px;
        padding-bottom: 20px;
    }

    .button {
        padding: 10px;
        margin: 10px;
        border: 1px solid white;
        color: white;
        border-radius: 15px;
    }

    button a{
        color: white;
        text-decoration: none;
        font-weight: bold;
    }

    .button:hover{
        border: 2px solid white;
    }

</style>