<template id="moon-detail">

    <div>
    <div  class="detail-moon-container">
        {{console.log(this.moon)}}
        <h1>{{moon.name}}</h1>
        <img class="detail" v-bind:src="moon.pictureUrl" />
        <p>The mass of {{moon.name}} is {{moon.mass}} kg, it has a radius of {{moon.radius}} km</p>
        <p>It uses about {{moon.orbitalPeriod}} days to spin around its planet</p>
    </div>
    </div>

</template>


<script>
    Vue.component("moon-detail", {
        template: "#moon-detail",

        data: () => ({
            moon: null,
        }),
        created() {
            const planetSystemId = this.$javalin.pathParams["planet-system-id"];
            console.log("Planet system id: " + planetSystemId);
            const planetId = this.$javalin.pathParams["planet-id"];
            const moonId = this.$javalin.pathParams["moon-id"];

            fetch(`/api/planet-systems/${planetSystemId}/planets/${planetId}/moons/${moonId}`)
                .then(res => res.json())
                .then(res => this.moon = res)
                .catch(() => alert("Error while fetching planet"));
        }

    });
</script>

<style>

    ul{
        color:white;
    }
    div.detail-moon-container > p {
        max-width: 30em;
    }
    div.detail-moon-container{
        padding-top: 10px;
        overflow: hidden;
        width: 500px;
        background-color: #000000;
        color: white;
        margin: 0 auto;
        opacity: 0.96;
        text-align: center;
        -webkit-box-shadow: 10px 10px 5px 0px rgba(0,0,0,0.25);
        -moz-box-shadow: 10px 10px 5px 0px rgba(0,0,0,0.25);
        box-shadow: 10px 10px 5px 0px rgba(0,0,0,0.25);
    }

    img.detail{
        height: 120px;
        width: 120px;
        padding-bottom: 20px;
    }


</style>