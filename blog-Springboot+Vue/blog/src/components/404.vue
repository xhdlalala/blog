<template>
  <div></div>
</template>

<script>
  export default {
    created() {
      const oScript = document.createElement("script");
      const oScript2 = document.createElement("script");
      oScript.type = "text/javascript";
      oScript2.type = "text/javascript";
      oScript2.src = oScript.src =
        "http://qzonestyle.gtimg.cn/qzone/hybrid/app/404/search_children.js";
      oScript2.charset = oScript.charset = "utf-8";
      oScript.HomePageUrl = oScript2.homePageUrl = "http://106.13.75.163/";
      oScript.HomePageName = oScript2.homePageName = "返回主页";
      document.body.appendChild(oScript);
      document.body.appendChild(oScript2);
    }
  };
</script>

<style scoped></style>
