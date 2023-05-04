import {createStore} from 'vuex';
export default defineNuxtPlugin((nuxtApp) => {
    return {
        provide: {
            vuex: createStore({
                state() {
                    return {
                        count: 0,
                    };
                },
                mutations: {
                    increment(state){
                        state.count++;
                    },
                },
            })
        }
    }
})