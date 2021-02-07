<template id="animal-detail">

    <div v-if="animal" class="detail-observation-container">

        <h1>{{animal.name}} the {{animal.scientificName}}</h1>
        <img v-if="observation.pictureUrl" class="cover-image" v-bind:src="observation.pictureUrl">
        <img v-else class="cover-image" src="https://upload.wikimedia.org/wikipedia/commons/thumb/d/d9/Icon-round-Question_mark.svg/480px-Icon-round-Question_mark.svg.png">
        {{console.log(animal.numberofLegs)}}
        <p>This animal actually has {{animal.numberofLegs}} legs! Can you believe that</p>

        <p v-if="animal.type==='amphibian'">
            The animal observed is an Amphibian. <span v-if="animal.hasTale">It actually has a tale, who would have figured</span>
            <span v-else>This guy does not have a tale, probably for the best</span>
            <br>
            <br>
           Habitat: {{animal.habitat}}!
        </p>

        <p v-if="animal.type==='invertebrate'">
            The animal observed is an Invertebrate. It measures about {{animal.length}} meters in length! <span v-if="animal.livesAtSea">{{animal.name}} lives at sea, so it
        it safe to say it probably likes water</span> <span v-else>{{animal.name}} does not live at sea, probably not a good swimmer</span>
        </p>

        <p v-if="animal.type==='bird'">
            The animal observed is a Bird. This bird weighs about {{animal.weight}} kilograms, and reaches a top speed of {{animal.topSpeedKmh}} km/h!
            <span v-if="animal.canFly">The magnificent bird can fly, and it does so really well</span>
            <span v-else>The poor thing cant fly, but sure makes up for it in other areas</span>
        </p>

    </div>

</template>

<script>
    Vue.component("animal-detail",{
        template: "#animal-detail",

        data:() =>({
            animal: null,
            observation: null
        }),

        created(){

            const observationId = this.$javalin.pathParams["observation-id"];

            fetch(`/api/observations/${observationId}/animal`)
                .then(res =>res.json())
                .then(res => this.animal = res)
                .catch(() =>alert("Feil"))

            fetch(`/api/observations/${observationId}`)
                    .then(res => res.json())
                    .then(res => this.observation= res)
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