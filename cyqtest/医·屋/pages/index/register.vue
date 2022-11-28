<template>
  <view class="container">
    <view class="top">
      <image class="top-bk" src="../../static/bg.png"></image>
      <image class="log" mode="aspectFit" src="../../static/logo.png"></image>
    </view>

    <view class="content">
      <view class="mobile">
        <input class="mobile-input" placeholder="请输入用户名" v-model="User_Name">
      </view>
      <view class="vcode">
        <input class="vcode-input" type="password" placeholder="请输入密码" v-model="PassWord">
        <!-- <view class="vcode-button" @click="clickGetCode" v-if="cutdown === 60">获取验证码</view> -->
        <!-- <view class="vcode-button" v-else>{{cutdown}}秒</view> -->
      </view>

      <view class="vcode">
        <input class="vcode-input" type="password" placeholder="请确认密码" v-model="cPassWord">
        <!-- <view class="vcode-button" @click="clickGetCode" v-if="cutdown === 60">获取验证码</view> -->
        <!-- <view class="vcode-button" v-else>{{cutdown}}秒</view> -->
      </view>
      <view class="confirm-button" @click="confirm">确认</view>
      <view class="tail">
        <view class="right" @click="goLogin">已注册,去登录?</view>
      </view>
    </view>
  </view>
</template>

<script>
  // // import {
  // //   getSmsCode,
  // //   register
  // // } from "@/utils/request.js"
  export default {
    data() {
      return {
        User_Name: "11",
        PassWord: "111",
        cPassWord: "111",
      }
    },
    components: {

    },
    onLoad() {

    },
    onShow() {

    },
    computed: {

    },
    methods: {
      //确认
      // radioChange(evt){
      //   this.type = evt.detail.value;
      // },
      async confirm() {

        if (!this.User_Name) {
          uni.showToast({
            title: "请输入用户名",
            icon: "none"
          });
          return;
        }
        if (!this.PassWord) {
          uni.showToast({
            title: "请输入密码",
            icon: "none"
          });
          return;
        }
        if (this.PassWord != this.cPassWord) {
          uni.showToast({
            title: "二次输入密码不一致",
            icon: "none"
          });
          return;
        }
        


        const db = uniCloud.database() //代码块为cdb
        let findres = await db.collection("User_Patient").where({
          User_Name: this.User_Name
        }).get()
        console.log("res===", findres);
        if (findres.result.data.length >= 1) {
          uni.showToast({
            title: "你的用户名已经被注册",
            icon: "none"
          });
          return;
        }

        let res = await db.collection("User_Patient").add({
          User_Name: this.User_Name,
          PassWord: this.PassWord,
		  PhoneNumber:"",
          Address:"",
		  Sex:0,
		  Active:false,
        })
        console.log("res===", res);
        if (res.result.code == 0) {
          uni.showToast({
            title: "注册成功",
            duration: 2000,
          });
          setTimeout(() => {
            uni.navigateTo({
              url: "./login"
            })
          }, 2000)
        }

      },
      goLogin() {
        uni.navigateTo({
          url: "./login"
        })
      }
    }
  }
</script>

<style lang="scss" scoped>
  .container {
    .top {
      width: 100%;
      height: 60vw;
      display: flex;
      align-items: center;
      justify-content: center;
      position: relative;

      .top-bk {
        width: 100%;
        height: 100%;
        position: absolute;
        left: 0px;
        top: 0px;
      }

      .log {
        width: 120px;
        height: 120px;
        left: 0px;
        top: 0px;
      }
    }

    .content {
      background-color: #fff;
      margin-top: -20px;
      border-top-left-radius: 20px;
      border-top-right-radius: 20px;
      position: relative;
      padding-top: 50px;
      padding-left: 20px;
      padding-right: 20px;

      .mobile-input {
        font-size: 15px;
        padding-left: 60px;
        line-height: 40px;
        height: 40px;
        border-bottom: 1px solid #EEEEEE;
        background-size: 20px 20px;
        background-repeat: no-repeat;
        background-position: 20px center;
        background-image: url("/static/mobile.png");
      }

      .vcode {
        display: flex;
        flex-direction: row;
        border-bottom: 1px solid #EEEEEE;
        align-items: center;
        justify-content: space-between;
        padding-right: 10px;

        .vcode-input {
          font-size: 15px;
          padding-left: 60px;
          margin-top: 10px;
          line-height: 40px;
          height: 40px;
          background-size: 20px 20px;
          background-repeat: no-repeat;
          background-position: 20px center;
          background-image: url("/static/password.png");
        }

        .vcode-button {
          padding: 5px 10px;
          line-height: 22px;
          color: #666;
          border: 1px solid #666;
        }
      }




      .confirm-button {
        margin: 40px 10px 0px 10px;
        background-color: rgb(60, 100, 170);
        border-radius: 50px;
        line-height: 50px;
        height: 50px;
        text-align: center;
        font-size: 13px;
        color: #FFFFFF;
      }

      .tail {
        display: flex;
        flex-direction: row;
        justify-content: space-between;
        align-items: center;
        padding: 10px 20px;
        color: #aaa;
        font-size: 14px;

        .agree-radio {
          width: 20px;
          height: 20px;
          margin-right: 10px;
        }

        .right {
          flex: 1;
          text-align: center;
        }
      }
    }

  }
</style>
