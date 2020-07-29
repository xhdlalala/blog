<template>
  <div class="boxparent">
    <div class="box">
      <mavon-editor
        id="box"
        @change="lll"
        @save="save"
        :toolbars="toolbars"
        :ishljs="true"
        :subfield="isSub"
        v-model="content"
      />
      <input type="text" v-model="listtitle" placeholder="标题" />
      <button @click="handleClick">发布</button>
      <button @click="test">test</button>
    </div>
  </div>
</template>

<script>
  import Qs from 'qs.js'
  export default {
    name: "release",
    data() {
      return {
        content: "",
        newhandle: "",
        listtitle: "",
        isSub: true,
        // createDate: this.getDate(),
        toolbars: {
          bold: true, // 粗体
          italic: true, // 斜体
          header: true, // 标题
          underline: true, // 下划线
          mark: true, // 标记
          superscript: true, // 上角标
          quote: true, // 引用
          ol: true, // 有序列表
          ul: true,
          link: true, // 链接
          imagelink: false, // 图片链接
          help: true, // 帮助
          code: true, // code
          // 是否需要分栏
          fullscreen: true, // 全屏编辑
          readmodel: true, // 沉浸式阅读
          /* 1.3.5 */
          undo: true, // 上一步
          trash: true, // 清空
          save: false, // 保存（触发events中的save事件）
          /* 1.4.2 */
          navigation: true, // 导航目录
          preview: true, // 预览
          alignleft: false, // 左对齐
          aligncenter: false, // 居中
          alignright: false // 右对齐
        }
      };
    },
    methods: {
      test(){
        console.log(this)
      },
      lll(value, render) {
        this.newhandle = render;
      },
      save() {
        let token = localStorage.getItem("token");
        const _this=this;
        if (token) {
          this.$http
            .post("http://localhost:8181/article/save/"+_this.title+"/"+_this.content)
            .then(res => {
              alert(res + "发布成功");
              this.$router.push({path : "/blog"})
            });
        } else {
          this.$router.push({ path: "/blog" });
        }
      },
      handleClick() {
        this.save();
      }
    }
  };
</script>

<style scoped>
  * {
    padding: 0;
    margin: 0;
  }
  .boxparent {
    display: flex;
    justify-content: center;
    align-items: center;
  }
  .box {
    width: 75vw;
    height: 100vh;
    display: flex;
    align-items: center;
    justify-content: center;
    border: 1px solid red;
  }
  .boxparent .box #box {
    height: 70vh;
    width: 100vw;
    margin-top: -20vh;
  }
  .boxparent .box button {
    position: absolute;
    top: 82vh;
    background: red;
    border: none;
    outline: none;
    color: antiquewhite;
    font-size: 18px;
    padding: 8px;
    border-radius: 4px;
    width: 6vw;
    left: 50%;
    transform: translateX(-50%);
    z-index: 8;
  }
  .boxparent .box input {
    color: red;
    outline: none;
    border: none;
    height: 40px;
    width: 100px;
    position: absolute;
    top: 10px;
    left: 50%;
    transform: translateX(-50%);
  }
  ::-webkit-input-placeholder {
    color: red;
  }
  .boxparent .box button:hover {
    cursor: pointer;
    color: white;
    font-weight: 500;
  }
</style>

