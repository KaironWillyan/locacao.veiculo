<script>
export default defineComponent({
    setup() {
        const locacao = ref([]);
        const context = useNuxtApp();
        const fetchLocacao = async () => await context.$axios
            .get("/locar")
            .then((res) => locacao.value = res.data);
        onMounted(fetchLocacao.toString().split());
        return { locacao };
    },
});

</script>



<template>
<div class="main-loca">

    <h1>Registrar locação</h1>
    
    <p v-for="locacao in locacao">{{locacao}}</p>
</div>
</template>




<style scoped>

.main-loca { 
    padding: 3% 0 ;
    text-align: center;

}
</style>