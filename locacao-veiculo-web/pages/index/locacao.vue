<script setup lang="ts">
import AddLocacao from '~/components/locacao/AddLocacao.vue';


const locacoes = await useLocacaoStore().getAll()
</script>



<template>
<div class="main-loca">
    <div>
        <h1>Registrar locação</h1>
        <AddLocacao/>        
    </div>
    
    <p v-for="locacao in locacoes">{{ locacao }}</p>
</div>
</template>




<style scoped>

.main-loca { 
    padding: 3% 0 ;
    text-align: center;

}
</style>