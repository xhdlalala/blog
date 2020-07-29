<template>
  <div>
    <section class="main">
      <button v-show="page > 1 ? true : false" id="1" @click="handlClick">
        上一页
      </button>
      <button id="2" @click="handlClick">下一页</button>
    </section>
  </div>
</template>

<script>
  export default {
    name: "pages",
    props: {
      total: {
        type: Number,
        default: 1
      },
      page: {
        type: Number,
        default: 1
      }
    },
    methods: {
      handlClick(e) {
        this.$emit("click", e);
      }
    }
  };
</script>

<style scoped>
  button {
    outline: none;
  }
  button:first-child {
    position: absolute;
    top: 80vh;
    left: 80%;
    transform: translateX(-80%);
    background: none;
    border: none;
    color: #e2d1bb;
    text-shadow: 5px 5px 15px rgba(0, 0, 0, 0.6);
    font-size: 18px;
    font-weight: 600;
  }
  button:last-child {
    position: absolute;
    top: 80vh;
    left: 90%;
    transform: translateX(-90%);
    background: none;
    border: none;
    color: #e2d1bb;
    text-shadow: 5px 5px 15px rgba(0, 0, 0, 0.6);
    font-size: 18px;
    font-weight: 600;
  }

  button:hover {
    cursor: pointer;
    color: white;
  }
</style>

