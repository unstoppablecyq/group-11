// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue, { onMounted } from 'vue'
import App from '@/App.vue'
import router from '@/router/index'
import ElementUI from 'element-ui'

import axios from 'axios'
import VueAxios from 'vue-axios'

import 'element-ui/lib/theme-chalk/index.css'
import '@/assets/main.css'


import store from '@/store/index'
import tool from './utils/tools.js'

Vue.use(tool)
Vue.use(ElementUI)
Vue.config.productionTip = false

Vue.use(VueAxios, axios)

/* eslint-disable no-new */
new Vue({
    el: '#app',
    router ,
    store ,
    components: { App },
    template: '<App/>'
})
