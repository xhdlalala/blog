<template>
  <div>
    <div class="search">
      <input type="text" v-model="value" placeholder="搜索" />
    </div>
    <h3>博客总览</h3>
    <div
      v-for="item in listBy(list,value)"
      :key="item.id"
      @click="handleClick(item.id)"
      class="show-blogs"
    >
      <div class="title">{{ item.title }}</div>
      <div class="detail" v-html="ss + item.content"></div>
      <div class="readme">
        <div class="date">{{ item.createDate | formate }}</div>
        <div v-if="token" @click="deleteClick(item.id)" class="delete">
          delete
        </div>
        <div @click="handleClick(item._id)" class="more">{{ more }}</div>
      </div>
    </div>
  </div>
</template>

<script>
  export default {
    name: "list",
    data() {
      return {
        ss: "&nbsp&nbsp&nbsp",
        more: "详情...",
        token: false,
        value: ""
      };
    },
    props: {
      list: {
        type: Array
      }
    },
    created() {
      let token = localStorage.getItem("token");
      if (token) {
        this.token = true;
      }
    },
    filters: {
      formate: function(value) {
        return value.substring(0, 10);
      }
    },
    methods: {
      listBy(lists, value) {
        return lists.filter(item => {
          return item.title.match(value);
        });
      },
      handleClick(id) {
        this.$router.push({ path: `/details/${id}` });
      },
      deleteClick(id, e) {
        this.$emit("click", e);
        this.$http.post("/api/list/delete", {
          params: {
            id: id
          }
        });
      }
    }
  };
</script>

<style scoped>
  .search {
    margin-top: -74px;
    margin-bottom: 106px;
    flex: 2;
    display: flex;
    align-items: center;
    justify-content: center;
  }
  .search input {
    margin-left: -84px;
    outline: none;
    background: #f9f2d5;
    border: none;
    width: 600px;
    line-height: 2.2;
    color: #fff8e5;
    text-shadow: 1px 1px 2px black;
    font-weight: 400;
    font-size: 16px;
    border-radius: 15px;
    padding: 0 15px;
  }
  ::-webkit-input-placeholder {
    /* color:#ffff; */
    color: #49b7c1;
    font-size: 15px;
    font-weight: 400;
    text-shadow: none;
  }
  .search input:focus {
    color: #dadbdd;
  }
  .show-blogs {
    height: 18vh;
    width: 43vw;
    background-image: linear-gradient(to bottom right, #a89783, #12cae6);
    overflow: hidden;
    border-radius: 10px;
    box-shadow: 5px 5px 15px rgba(0, 0, 0, 0.6);
    margin: 40px 0;
    transition: 0.3s;
    display: flex;
    align-items: center;
    justify-content: center;
    flex-direction: column;
  }
  h3 {
    color: #e2d1bb;
    text-shadow: 5px 5px 15px rgba(0, 0, 0, 0.6);
  }
  .show-blogs:hover {
    transform: scale(1.1);
  }
  .show-blogs .title {
    color: #fff8e5;
    padding-top: 10px;
    padding-right: 25px;
    padding-left: 25px;
    text-shadow: 1px 1px 2px black;
    font-weight: 400;
    font-size: 25px;
    flex: 1;
  }
  .show-blogs .detail {
    margin-top: -11px;
    line-height: 1.5;
    padding: 0 20px;
    /* border: 1px solid red; */
    display: -webkit-box;
    -webkit-box-orient: vertical;
    -webkit-line-clamp: 3;
    overflow: hidden;
    color: #fff8e5;

    font-weight: 440;
    font-size: 16px;
  }
  .show-blogs .readme {
    flex: 1;
    color: #ebc660;
    display: flex;
    align-items: center;
    justify-content: center;
    font-size: 14px;
  }
  .readme .date {
    margin-right: -38vw;
  }
  .readme .date:hover {
    color: white;
  }
  .readme .more:hover {
    cursor: pointer;
    color: white;
  }
  .delete {
    color: red;
    font-weight: 600;
    font-size: 18px;
    position: absolute;
    left: 20vw;
    cursor: pointer;
    height: 40px;
    width: 60px;
    background: white;
    border-radius: 10px;
    text-shadow: 3px 3px 5px rgba(0, 0, 0, 0.3);
    box-shadow: 3px 3px 6px rgba(0, 0, 0, 0.4);
  }
  @media screen and (max-width: 768px) {
    .search {
      display: none;
    }
    .show-blogs {
      width: 71vw;
      height: 18vh;
    }
    .show-blogs .title {
      font-size: 18px;
    }
    .show-blogs .detail {
      font-size: 14px;
    }
  }
</style>

