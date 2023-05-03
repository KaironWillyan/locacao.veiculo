<script setup lang="ts">
import NavBar from '~/components/NavBar.vue';

</script>

<template>
  <div class="main-container ">
    <div class="upper">
      <h1>Sistema Kairon</h1>
      <NavBar />
    </div>
    <NuxtPage />
  </div>
</template>

<style scoped>
.main-container {
  height: calc(100vh - 88px);
  width: 100vw;
}
</style>