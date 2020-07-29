<template>
  <div>
    <nav>
      <div class="logo">个人博客</div>
      <div class="search" v-if="Search">
        <input type="text" v-model="value" placeholder="搜索" />
      </div>
      <ul @click="handleClick" class="nav-menu isShow">
        <li id="/">博客</li>
        <li id="/introduce">关于我</li>
        <li id="/code">代码仓库</li>
        <li id="/write">写博客</li>
        <li v-if="isToken" id="out">登出</li>
      </ul>
      <div @click="handleToggle" class="burger">
        <div class="top-line"></div>
        <div class="middle-line"></div>
        <div class="bottom-line"></div>
      </div>
    </nav>
  </div>
</template>

<script>
  export default {
    name: "Header",
    props: {
      Search: {
        type: Boolean,
        default: false
      }
    },
    data() {
      return {
        isShow: true,
        isToken: false,
        value: ""
      };
    },
    created() {
      let token = localStorage.getItem("token");
      if (token) {
        this.isToken = true;
      }
    },
    methods: {
      handleToggle() {
        if (this.isShow) {
          document
            .getElementsByClassName("nav-menu")[0]
            .classList.remove("isShow");
        } else {
          document.getElementsByClassName("nav-menu")[0].classList.add("isShow");
        }
        this.isShow = !this.isShow;
      },
      handleClick(e) {
        let token = localStorage.getItem("token");
        console.log(e.target);
        switch (e.target.id) {
          case "/":
            this.$router.push({ path: "/blog" });
            break;
          case "/introduce":
            this.$router.push("/introduce");
            break;
          case "/code":
            window.location.href = "https://gitee.com/xhdkeepreal";
            break;
          case "/write":
            if (token) {
              this.$router.push({ path: `/release/${3}` });
            } else {
              this.$router.push("/login");
            }

            break;
          case "out":
            localStorage.clear();
        }
      }
    }
  };
</script>

<style scoped>
  * {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
    font-family: "PingFang SC", "Microsoft Yahei", sans-serif;
  }

  nav {
    position: absolute;
    top: 0;
    left: 0;
    right: 0;
    display: flex;
    align-items: center;
    justify-content: space-between;
    padding: 0 5vw;
    height: 60px;
    background-image: linear-gradient(to top left, #a89783, #12cae6);
    /* background-color: rgba(65,81,101,0.4); */
    /* background-color: rgba(255, 255, 255, 0.1); */
    /* border: rgba(65,81,101,0.4) */
  }
  .logo {
    font-size: 24px;
    font-weight: 600;
    color: #dadbdd;
    flex: 1;
  }
  .nav-menu {
    flex: 1;
    display: flex;
    align-items: center;
    justify-content: space-between;
    max-width: 350px;
  }
  .nav-menu li {
    list-style: none;
    color: #fff8e5;

    text-shadow: 1px 1px 2px black;
    font-weight: 440;
    font-size: 18px;
    transition: 0.3s;
  }
  .nav-menu li:hover {
    transform: scale(1.2);
    color: white;
    font-weight: 500;
    cursor: pointer;
  }
  .search {
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
  .burger div {
    width: 25px;
    height: 3px;
    background-color: #dadbdd;
    margin: 4px;
  }
  .burger {
    display: none;
  }
  /* 响应式 */
  @media screen and (max-width: 768px) {
    .isShow {
      display: none !important;
    }
    nav {
      position: fixed;
      z-index: 100000000;
    }
    .nav-menu {
      position: fixed;
      top: 60px;
      right: 0;
      bottom: 0;
      width: 50vw;
      height: calc(100vh - 60px);
      background-color: rgba(0, 0, 0, 0.8);
      flex-direction: column;
      align-items: center;
      justify-content: flex-start;
      transition: 0.4s ease-in-out;
      z-index: 100000000;
    }
    .search {
      position: absolute;
      top: 60px;
      right: 0;
      height: 40px;
      width: 50vw;
      display: none;
    }
    .search input {
      outline: none;
      background: rgba(255, 255, 255, 0.3);
      border: none;
      width: 170px;
      line-height: 2.2;
      color: rgba(255, 255, 255, 0.9);
      font-weight: 300;
      font-size: 14px;
      border-radius: 15px;
      padding: 0 15px;
      z-index: 4;
    }
    ::-webkit-input-placeholder {
      /* color:#ffff; */
      color: rgba(142, 153, 125, 0.9);
      font-size: 15px;
      font-weight: 400;
      text-align: center;
    }
    .search input:focus {
      color: #dadbdd;
    }
    .nav-menu li {
      margin: 1.5vh;
      font-size: 18px;
      font-weight: 400;
      color: rgba(255, 255, 255, 0.7);
      transition: 0.5s;
    }
    .nav-menu li:hover {
      color: rgba(255, 255, 255, 1);
      transform: scale(1.2);
    }
    .nav-menu :first-child {
      margin-top: 60px;
    }
    .burger {
      display: block;
    }
  }
</style>
