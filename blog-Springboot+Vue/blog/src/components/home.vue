<template>
  <div class="body">
    <section class="container">
      <Header ref="search"></Header>
    </section>
    <section class="main">
      <List @click="refresh" :list="count"></List>
      <Pages v-show="false" @click="pageClick" :page="pagess"></Pages>
    </section>
  </div>
</template>

<script>
  import Header from "../components/header";
  import List from "../components/list";
  import Pages from "../components/pages";
  export default {
    name: "home",
    data() {
      return {
        count: [],
        num: 1,
        pagess: 1,
        value: ""
      };
    },
    components: {
      Header,
      List,
      Pages
    },
    methods: {
      refresh() {
        this.$http.get("http://localhost:8181/article/findAll", {}).then(res => {
          console.log(res)
          this.count = res.data;
        });
      },
      pageClick(e) {
        if (e.target.id == "2") {
          this.num++;
        } else {
          this.num--;
        }
        this.$http
          .get("/api/list", {
            params: {
              page: this.num
            }
          })
          .then(res => {
            this.count = res.data;
          });
      }
    },
    created() {
      this.refresh();
    }
  };
</script>

<style scoped>
  html {
    margin: 0;
    padding: 0;
  }
  .container {
    width: 100vw;
    min-height: 100vh;
    background-image: url("../assets/images/back.jpg");
    background-size: cover;
  }
  h1 {
    cursor: pointer;
  }
  .main {
    position: absolute;
    transform: translateX(-50%);
    left: 50%;
    top: 90px;
  }
</style>

