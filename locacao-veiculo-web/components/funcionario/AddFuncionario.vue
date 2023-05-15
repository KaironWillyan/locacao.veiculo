<script setup lang="ts">
import { funcionarioDto } from '~/models/Dto/funcionarioDto';

const storeFuncionario = useFuncionariorStore()
const storeSetor = await useSetorStore().getAll();

let data = ref ({
nome:  "",  
cpf:     "",
telefone:"",
tipoCnh: "",
setor:   {},
} as funcionarioDto);

async function addFuncionario(){
  await storeFuncionario
    .createFuncionario({
      setor: data.value.setor,
      nome: data.value.nome,
      cpf: data.value.cpf,
      tipoCnh: data.value.tipoCnh,
      telefone: data.value.telefone,
    })
}
</script>

<template>
  <form>
    <div class="mb-3">
      <label class="form-label">Nome</label>
      <input type="text" @keyup.enter="addFuncionario" v-model="data.nome" class="form-control" aria-describedby="emailHelp">
    </div>
    <div class="mb-3">
      <label class="form-label">cpf</label>
      <input @keyup.enter="addFuncionario" v-model="data.cpf" type="text" class="form-control">
    </div>
    <div class="mb-3">
      <label class="form-label">telefone</label>
      <input @keyup.enter="addFuncionario" v-model="data.telefone" type="text" class="form-control">
    </div>
    <div class="mb-3">
      <label class="form-label">tipo cnh</label>
      <input @keyup.enter="addFuncionario" v-model="data.tipoCnh" type="text" class="form-control">
    </div>
    <div class="mb-3">
      <label class="form-label">setor</label>
      <select v-model="data.setor" @keyup.enter="addFuncionario" class="form-select form-select-sm" aria-label=".form-select-sm example">
          <option selected>Selecione o setor</option>
          <option v-for="setor in storeSetor"> {{setor.nome}}</option>
      </select>
    </div>
    <button @keyup.enter="addFuncionario" @click="addFuncionario" type="button" class="btn btn-primary">Cadastrar</button>
  </form>
</template> 