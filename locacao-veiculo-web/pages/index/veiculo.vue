<script setup lang="ts">
import AddVeiculo from '~/components/veiculo/AddVeiculo.vue';
    const veiculos = await useVeiculoStore().getAll()
</script>

<template>
    <div class="main-vei d-flex">
        
        <div class="cad-vei">
            <h1>Registrar Veículo</h1>
            <AddVeiculo />
        </div>

        <div class="exi-vei" >
            <h1>Veiculo</h1>
            <p v-for="veiculo in veiculos">{{veiculo}}</p>
        </div>
        
    </div>
</template>

<style scoped>
 .main-vei{
   display: flex;
   flex-wrap: wrap;
}

.cad-vei{
    flex: 30%;
    padding: 20px;
}

.exi-vei{
    flex:60%;
    padding: 20px;
}
</style>