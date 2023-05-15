<script setup lang="ts" >
import AddOperador from '~/components/operador/AddOperador.vue';

const operadores = await useOperadorStore().getAll()
 
</script>

<template>
    <div class="main-ope">
        <div class="cad-ope">
            <h1>Registrar Operador</h1>
            <AddOperador />
        </div>
    
        <div class="exi-op">
            <p>operadores</p>
            <p v-for="operador in operadores">{{ operador }}</p>
    
        </div>
    </div> 
</template>

<style scoped>
 .main-ope{
   display: flex;
   flex-wrap: wrap;
   margin: 10px;
}

.cad-ope{
    flex: 30%;
    padding: 20px;
}

.exi-ope{
    flex:60%;
    padding: 20px;
}
</style>