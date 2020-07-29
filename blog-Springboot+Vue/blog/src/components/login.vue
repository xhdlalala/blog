<template>
  <div>
    <div class="container">
      <form v-if="!isShow" class="login-form">
        <h2>登 录</h2>
        <input
          type="text"
          name="username"
          v-model="username"
          placeholder="用户名"
        />
        <input
          type="password"
          name="password"
          v-model="password"
          placeholder="密码"
        />
        <button @click.prevent="handleClick">登录</button>
      </form>
      <div v-else class="shade">
        <div class="card">
          <div class="title">
            {{ tips }}
          </div>
          <button @click="shadeClick">确定</button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
  export default {
    data() {
      return {
        username: "",
        password: "",
        isShow: false,
        tips: ""
      };
    },
    methods: {
      shadeClick() {
        this.isShow = false;
      },
      handleClick() {
        let _this = this;
        if (_this.username != "" && _this.password != "") {
          _this.$http
            .put("http://localhost:8181/user/check/"+_this.username+"/"+_this.password
            ).then(res => {
              console.log(res.data)
              localStorage.setItem("token", res.data);
              if (res.data===true) {
                _this.$router.push({ path: `/release` });
              }
            })
            .catch(res => {
              if (res.data ===false) {
                _this.isShow = true;
                _this.tips = "用户名或密码错误";
              }
            });
        } else {
          _this.isShow = true;
          _this.tips = "用户名或密码不能为空";
        }
      }
    }
  };
</script>

<style scoped>
  html,
  body {
    margin: 0;
    font-family: "PingFang SC", "Microsoft Yahei", sans-serif;
  }

  .container {
    width: 100vw;
    height: 100vh;
    display: flex;
    align-items: center;
    justify-content: center;
    background: url("../assets/images/img1.jpg") fixed no-repeat;
    background-size: cover;
  }
  .container .shade {
    height: 100vh;
    width: 100vw;
    background: rgba(0, 0, 0, 0.5);
    display: flex;
    justify-content: center;
    align-items: center;
  }
  .container .shade .card {
    height: 30vh;
    width: 25vw;
    background-image: linear-gradient(to bottom right, #a89783, #12cae6);
    border-radius: 12px;
    text-shadow: 2px 2px 9px rgba(0, 0, 0, 0.3);
    display: flex;
    align-items: center;
    justify-content: center;
    flex-direction: column;
  }
  .container .shade .card .title {
    color: #f50b51;
    font-weight: 600;
    font-size: 25px;
    margin-bottom: 40px;
  }
  .container .shade .card button {
    color: white;
    font-size: 18px;
    background: #7da59f;
    outline: none;
    border: none;
    height: 4vh;
    cursor: pointer;
    width: 6vw;
    border-radius: 3px;
    /* box-shadow: 2px 2px 2px rgba(255, 255, 255, 0.1); */
  }
  .login-form {
    width: 240px;
    height: 220px;
    display: flex;
    flex-direction: column;
    padding: 40px;
    text-align: center;
    position: relative;
    z-index: 100;
    background: inherit;
    border-radius: 18px;
    box-shadow: 5px 5px 15px #3d5245;
    overflow: hidden; /* 隐藏多余的模糊效果 */
  }

  .login-form::before {
    content: "";
    width: calc(100% + 20px);
    height: calc(100% + 20px);
    position: absolute;
    top: -10px;
    left: -10px;
    overflow: hidden;
    background: inherit;
    box-shadow: inset 0 0 0 200px rgba(255, 255, 255, 0.25);
    filter: blur(6px);
    z-index: -1;
  }

  .login-form h2 {
    font-size: 18px;
    font-weight: 400;
    color: #3d5245;
  }

  .login-form input,
  .login-form button {
    margin: 6px 0;
    height: 36px;
    border: none;
    background-color: rgba(255, 255, 255, 0.3);
    border-radius: 4px;
    padding: 0 14px;
    color: #3d5245;
  }

  .login-form input::placeholder {
    color: #3d5245;
  }

  /* 补充，取消选中高亮蓝框 */
  .login-form button:focus,
  .login-form input:focus {
    outline: 0;
  }

  .login-form button {
    margin-top: 24px;
    background-color: rgba(57, 88, 69, 0.4);
    color: white;
    position: relative;
    overflow: hidden;
    cursor: pointer;
    transition: 0.4s;
  }

  .login-form button:hover {
    background-color: rgba(12, 80, 38, 0.67);
  }

  .login-form button:focus {
    outline: 0;
  }

  .login-form button::before,
  .login-form button::after {
    content: "";
    display: block;
    width: 80px;
    height: 100%;
    background: rgba(179, 255, 210, 0.5);
    opacity: 0.5;
    position: absolute;
    top: 0;
    left: 0;
    transform: skewX(-15deg);
    filter: blur(30px);
    overflow: hidden;
    transform: translateX(-100px);
  }

  .login-form button::after {
    width: 40px;
    background: rgba(179, 255, 210, 0.3);
    left: 60px;
    opacity: 0;
    filter: blur(5px);
  }

  .login-form button:hover::before {
    transition: 1s;
    transform: translateX(320px);
    opacity: 0.7;
  }

  .login-form button:hover::after {
    transition: 1s;
    transform: translateX(320px);
    opacity: 1;
  }
  ::-webkit-input-placeholder {
    color: #3d5245 !important;
  }
</style>
