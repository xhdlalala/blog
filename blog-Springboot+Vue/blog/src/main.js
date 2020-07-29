import Vue from 'vue'
import App from './App'
import router from './router'
import store from "./store";

import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';

import VueResource from "vue-resource";
import mavonEditor from "mavon-editor";
import "mavon-editor/dist/css/index.css";
import aob from "../src/btoa/btoa"
import Qs from "qs.js";
Vue.prototype.$aob=aob;
Vue.use(mavonEditor)
Vue.use(VueResource)

import axios from 'axios'
Vue.prototype.$ajax='axios'

Vue.config.productionTip = false

Vue.use(router);
Vue.use(ElementUI);
Vue.use(axios)
/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  render: h => h(App)
}).$mount("#app");
