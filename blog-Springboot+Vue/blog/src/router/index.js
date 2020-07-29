import Vue from "vue";
import VueRouter from "vue-router";

Vue.use(VueRouter);
const originalPush = VueRouter.prototype.push;

VueRouter.prototype.push = function push(location) {
  return originalPush.call(this, location).catch(err => err);
};
const routes = [
  {
    path: "/",
    name: "home",
    component: () => import("../components/home.vue")
  },
  {
    path: "/login",
    name: "login",
    component: () => import("../components/login.vue")
  },
  {
    path: "/blog",
    redirect: "/"
  },
  {
    path: "/introduce",
    name: "introduce",
    component: () => import("../components/introduce.vue")
  },
  {
    path:"/release/:id",
    name:'release',
    component:()=>import('../components/release.vue')
  },
  {
    path:"/release",
    name:'release',
    component:()=>import('../components/release.vue')
  },
  {
    path:"/details/:id",
    name:'details',
    component:()=>import('../components/details.vue')
  },
  {
    path: "/404",
    component: () => import("../components/404.vue")
  },
  {
    path: "*",
    redirect: "/404"
  }
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes
});

export default router;
