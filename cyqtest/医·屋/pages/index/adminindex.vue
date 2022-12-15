<template>
  <view class="container">
    <swiper style="height:40vw;width: calc(100vw - 40px);overflow:hidden;position: relative;margin: 20px 20px 20px 20px;" :autoplay="true" ref="mySwiper">
      <swiper-item :key="i" v-for="(item,i) in banners"> 
      <image style="width:100%;height:100%;object-fit:cover;border-radius: 10px;"
          :src="item.image" /></swiper-item>
    </swiper>
    <view class="buttons">
      <view class="ji-button" @click="jijian">
        <image class="icon" src="../../static/jijian.png" />
        <text>审核</text>
      </view>
      <view class="qu-button" @click="qujian">
        <image class="icon" src="../../static/qujian.png" />
        <text>查询</text>
      </view>
    </view>

  </view>
</template>

<script>
  import {
    getUser
  } from "@/utils/storage.js"
  export default {
    data() {
      return {
        list: [],
        banners: [{
            image: "/static/banner1.png",
          },
          {
            image:  "/static/banner2.png",
          },
          {
            image:  "/static/banner3.png",
          }
        ],
      }
    },
    onShow() {
      this.user = getUser();
      if (!getUser()) {
        uni.navigateTo({
          url: "./login"
        })
      } else {
        // if (this.user.type == "1") {
        //   uni.setTabBarItem({
        //     index: 1,
        //     visible: false
        //   })
        // } else {
        //   uni.setTabBarItem({
        //     index: 1,
        //     visible: true
        //   })
        // }
      }
    },
    methods: {
      jijian(item) {
        console.log("item===", item);
        uni.navigateTo({
          url: "/pages/index/xiadan"
        });
      },
      qujian(item) {
        console.log("item===", item);
        uni.switchTab({
          url: "/pages/index/orderlist"
        });
      },
      
    }
  }
</script>

<style lang="less">
  .container {
    background-color: #fff;
    height: 100%;
    display: flex;
    flex-direction: column;
    align-items: center;
    width: 100%;

    .buttons {
      display: flex;
      justify-content: center;

      .ji-button {
        width: 40vw;
        height: 20vw;
        background-color: #5465ff;
        color: #fff;
        display: flex;
        justify-content: center;
        align-items: center;
        border-radius: 5px;
        font-size: 13px;
        margin-bottom: 10px;
        margin-right: 10px;
        .icon{
          width: 50px;
          height: 50px;
          margin-right: 10px;
        }
      }

      .qu-button {
        width: 40vw;
        background-color: #5465ff;
        color: #fff;
        text-align: center;
        border-radius: 5px;
        display: flex;
        justify-content: center;
        align-items: center;
        font-size: 13px;
        margin-bottom: 10px;
        margin-right: 10px;
        .icon{
          width: 50px;
          height: 50px;
          margin-right: 10px;
        }
      }
    }

  }
</style>
