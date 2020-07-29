<template>
  <div class="details">
    <Header></Header>
    <div class="edc">
      <div class="edit">
        <div class="title">
          <h3>博客详情</h3>
        </div>
        <div class="detai">
          <mavon-editor
            id="box"
            :defaultOpen="defaultopen"
            :toolbarsFlag="toolbarsFlag"
            :ishljs="true"
            :previewBackground="co"
            :subfield="isSub"
            v-model="content"
          />
        </div>
        <div class="pinglun"></div>
      </div>
    </div>
  </div>
</template>

<script>
  import Header from "./header";
  export default {
    data() {
      return {
        toolbarsFlag: false,
        co: "transparent",
        isSub: false,
        defaultopen: "preview",
        ish: true,
        content: ""
      };
    },
    components: {
      Header
    },
    created() {
      let id = this.$router.currentRoute.params.id;
      this.$http
        .get("http://localhost:8181/article/findById/"+id
          )
        .then(res => {
          this.content = res.data.content;
        });
    }
  };
</script>

<style scoped>
  * {
    scrollbar-arrow-color: rgb(200, 200, 200); /*ok-上下三角箭头*/
    scrollbar-3dlight-color: rgb(200, 200, 200); /*ok-3d滑块左上角高光部分颜色*/
    scrollbar-highlight-color: rgb(200, 200, 200); /*ok-滑块左上角高光部分颜色*/
    scrollbar-shadow-color: rgb(200, 200, 200); /*ok*/
    scrollbar-darkshadow-color: rgb(
      200,
      200,
      200
    ); /*ok-以上都是定义一些阴影高光等3D效果*/
    scrollbar-face-color: rgb(200, 200, 200); /*ok-滑块*/
    scrollbar-track-color: rgb(240, 240, 240); /*ok-滑道*/
  }
  html,
  body {
    padding: 0;
    margin: 0;
    box-sizing: border-box;
  }
  h3 {
    color: #e2d1bb;
    text-shadow: 5px 5px 15px rgba(0, 0, 0, 0.6);
  }
  .details {
    width: 100%;
    min-height: 100vh;
    background-image: url("../assets/images/img1.jpg");
    background-size: cover;
  }
  .details .edc {
    display: flex;
    justify-content: center;
    align-items: center;
    padding-top: 8vh;
  }
  .details .edit {
    margin-top: -5px;
    min-height: 880px;
    width: 35vw;
    background-color: rgba(145, 73, 198, 0.6);
    border-radius: 9px;
    box-shadow: 5px 5px 13px rgba(0, 0, 0, 0.2);
    display: flex;
    justify-content: center;
    align-items: center;
    flex-direction: column;
  }
  .details .edit .title {
    padding-left: 50px;
    align-self: flex-start;
  }
  .details .edit .detai {
    min-height: 800px;
    width: 80%;

    border-radius: 15px;
  }
  .details .edit .detai #box {
    min-height: 80vh;
    width: 100%;
    border-radius: 11px !important;
    background-color: transparent;
  }
  html ::-webkit-scrollbar {
    /*滚动条整体部分，其中的属性有width,height,background,border（就和一个块级元素一样）等。*/
    width: 1px;
    height: 10px;
  }
  html ::-webkit-scrollbar-button {
    /*滚动条两端的按钮。可以用display:none让其不显示，也可以添加背景图片，颜色改变显示效果。*/
    display: none;
  }
  html ::-webkit-scrollbar-track {
    /*外层轨道。可以用display:none让其不显示，也可以添加背景图片，颜色改变显示效果。*/
    display: none;
  }
  html ::-webkit-scrollbar-track-piece {
    /*内层轨道，滚动条中间部分（除去）。*/
    background: rgb(240, 240, 240);
  }
  ::-webkit-scrollbar-thumb {
    /*滚动条里面可以拖动的那部分*/
    background: rgb(200, 200, 200);
  }
  ::-webkit-scrollbar-thumb:hover {
    /*滚动条里面可以拖动的那部分*/
    background: rgb(180, 180, 180);
  }
  ::-webkit-scrollbar-corner {
    /*边角*/
    background: rgb(200, 200, 200);
  }
  ::-webkit-scrollbar-resizer {
    /*定义右下角拖动块的样式*/
    background: rgb(200, 200, 200);
  }
</style>

