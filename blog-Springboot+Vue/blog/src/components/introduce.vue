<template>
  <div>
    <Header></Header>
    <section class="container">
      <div class="card">
        <div class="card-image"></div>
        <div class="card-text">
          <h2>Web Lfg</h2>
          <p>
            扎实的Java编程基础，熟悉常用的Java开源框架和Web开发技术，熟悉MySQL、Redis数据库的管理及开发；
            掌握常用的数据结构和基本算法，掌握面向对象的思想和设计模式；
            熟悉linux开发环境，掌握一种脚本语言的使用，拥有良好的编程规范；
            熟悉使用git，使用maven、Gladle项目构建工具；
            熟悉Tomcat、Docker等容器的配置和部署； 。
          </p>
        </div>
        <div class="card-stats">
          <div class="stat">
            <div class="value">+</div>
            <div class="type"><span>关 注</span></div>
          </div>
        </div>
      </div>
    </section>
    <section>
      <div class="box">
        <div class="track" v-for="item in danmuA" :key="item.index">
          <div :class="['child', item.lei]">{{ item.danmu }}</div>
        </div>
      </div>
    </section>
  </div>
</template>

<script>
  import Header from "./header";
  export default {
    name: "introduce",
    data() {
      return {
        // danmuA: [
        //   {
        //     index: 1,
        //     danmu: "真的好帅啊！！！爱死你了",
        //     lei: "child-1"
        //   },
        //   {
        //     index: 2,
        //     danmu: "加油！加油！",
        //     lei: "child-2"
        //   },
        //   {
        //     index: 3,
        //     danmu: "莫愁前路无知己，天下谁人不识君",
        //     lei: "child-3"
        //   },
        //   {
        //     index: 4,
        //     danmu: "相逢何必曾相识！！！爱死你了",
        //     lei: "child-1"
        //   },
        //   {
        //     index: 5,
        //     danmu: "加油！真的很棒，谢谢你！",
        //     lei: "child-2"
        //   },
        //   {
        //     index: 6,
        //     danmu: "你真的很棒！！！",
        //     lei: "child-3"
        //   },
        //   {
        //     index: 7,
        //     danmu: "真的好帅啊！！！爱死你了",
        //     lei: "child-1"
        //   },
        //   {
        //     index: 8,
        //     danmu: "加油！加油！",
        //     lei: "child-2"
        //   },
        //   {
        //     index: 9,
        //     danmu: "莫愁前路无知己，天下谁人不识君",
        //     lei: "child-3"
        //   },
        //   {
        //     index: 10,
        //     danmu: "相逢何必曾相识！！！爱死你了",
        //     lei: "child-4"
        //   },
        //   {
        //     index: 11,
        //     danmu: "加油！真的很棒，谢谢你！",
        //     lei: "child-5"
        //   },
        //   {
        //     index: 12,
        //     danmu: "你真的很棒！！！",
        //     lei: "child-6"
        //   },
        //   {
        //     index: 13,
        //     danmu: "真的好帅啊！！！爱死你了",
        //     lei: "child-1"
        //   },
        //   {
        //     index: 14,
        //     danmu: "加油！加油！",
        //     lei: "child-2"
        //   },
        //   {
        //     index: 15,
        //     danmu: "莫愁前路无知己，天下谁人不识君",
        //     lei: "child-3"
        //   },
        //   {
        //     index: 16,
        //     danmu: "相逢何必曾相识！！！爱死你了",
        //     lei: "child-1"
        //   },
        //   {
        //     index: 17,
        //     danmu: "加油！真的很棒，谢谢你！",
        //     lei: "child-2"
        //   },
        //   {
        //     index: 18,
        //     danmu: "你真的很棒！！！",
        //     lei: "child-3"
        //   }
        // ]
      };
    },
    components: {
      Header
    }
  };
</script>

<style scoped>
  * {
    margin: 0;
    padding: 0;
  }
  .container {
    width: 100vw;
    height: 100vh;
    background-image: url("../assets/images/img2.jpg");
    background-size: cover;
    display: flex;
    justify-content: center;
    align-items: center;
    overflow: hidden;
  }

  .card {
    display: grid;
    grid-template-columns: 600px;
    grid-template-rows: 210px 210px 210px;
    grid-template-areas: "image" "text" "stats";
    font-family: roboto;
    border-radius: 18px;
    background: white;
    box-shadow: 5px 5px 15px rgba(0, 0, 0, 0.9);
    text-align: center;
    transition: 0.5s ease;
    cursor: pointer;
    z-index: 2;
  }
  .card-image {
    grid-area: image;
    background: url("../assets/images/img1.jpg");
    border-top-left-radius: 15px;
    border-top-right-radius: 15px;
    background-size: cover;
  }
  .card-text {
    grid-area: text;
    margin: 25px;
    overflow: hidden;
  }
  .card-text .date {
    color: rgb(255, 7, 110);
    font-size: 13px;
  }
  .card-text p {
    color: grey;
    font-weight: 300;
    font-size: 15px;
  }
  .card-text h2 {
    margin-top: 0px;
    font-size: 28px;
  }
  .card-stats {
    grid-area: stats;
    display: grid;
    grid-template-columns: 1fr;
    grid-template-rows: 1fr;
    border-bottom-left-radius: 15px;
    border-bottom-right-radius: 15px;
    background: rgb(255, 7, 110);
  }
  .card-stats .stat {
    display: flex;
    align-items: center;
    justify-content: center;
    flex-direction: column;
    padding: 10px;
    color: white;
  }
  .card-stats .type {
    font-size: 11px;
    font-weight: 300;
    text-transform: uppercase;
  }
  .card-stats .type span {
    font-size: 15px;
    font-weight: 400;
  }
  .card-stats .value {
    font-size: 22px;
    font-weight: 500;
  }
  .card:hover {
    transform: scale(1.2);
    grid-template-columns: 308px;
    grid-template-rows: 270px 218px 80px;
    box-shadow: 5px 5px 15px rgba(0, 0, 0, 0.6);
    opacity: 0.4;
  }
  .box {
    width: 100vw;
    /* height: 100vh; */
    /* background: rgba(0, 0, 0, 0.1); */
    margin: 100px auto 0;
    overflow: hidden;
    position: absolute;
    top: 0;
    left: 0;
    font-size: 25px;
    z-index: 1;
  }
  .track {
    height: 40px;
    line-height: 40px;
    margin-bottom: 5px;
  }
  .child {
    line-height: 20px;
    margin-bottom: 10px;
  }

  .child-1 {
    color: brown;
    transform: translateX(1920px);
    animation: scrollTo linear 7s infinite;
  }

  .child-2 {
    color: rgb(127, 197, 35);
    transform: translateX(1920px);
    animation: scrollTo linear 9s infinite;
  }

  .child-3 {
    color: coral;
    transform: translateX(1920px);
    animation: scrollTo linear 8s infinite;
  }
  .child-4 {
    color: red;
    transform: translateX(1920px);
    animation: scrollTo linear 12s infinite;
  }
  .child-5 {
    color: yellow;
    transform: translateX(1920px);
    animation: scrollTo linear 6s infinite;
  }
  .child-6 {
    color: white;
    transform: translateX(1920px);
    animation: scrollTo linear 11s infinite;
  }
  @keyframes scrollTo {
    to {
      transform: translateX(-100px);
    }
  }
  @media screen and (max-width: 768px) {
    .box {
      display: none;
      z-index: -1;
    }
  }
</style>

