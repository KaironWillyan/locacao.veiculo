<script >

export default defineComponent({
    setup() {
        const operador = ref([]);
        const context = useNuxtApp();

        const fetchOperador = async () => 
        await context.$axios
         .get("/operador")
         .then((res) => operador.value = res.data);
        
        onMounted(fetchOperador);
        return {operador}
    }
});

</script>

<template>
    <div>
        <nuxt-link to="/">Home</nuxt-link>

        <h1>operador</h1>
        <p>{{operador}}</p>
        
    </div>
</template>