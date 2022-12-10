<template>
  <view class="container">

    <view class="top">
      <image class="top-bk" src="../../static/bg.png"></image>
      <image class="log" mode="aspectFit" src="../../static/logo.png"></image>
    </view>
    <view class="content">
      <view class="mobile">
        <input class="mobile-input" placeholder="请输入医生用户名" v-model="username">
      </view>
      <view class="password">
        <input class="password-input" type="password" placeholder="请输入密码" v-model="password">
      </view>
      <view class="login-button" @click="confirm">登录</view>
      <view class="tail">
        <view class="right" @click="goRegister">新用户注册</view>
		<view class="docdoc" @click="gologin">切换到用户登陆</view>
      </view>
    </view>
  </view>
</template>

<script>
  // import {
  //   login,
  //   getMyInfo
  // } from "@/utils/request.js"
  import {getUser,saveUser} from "@/utils/storage.js"

  export default {
    data() {
      return {
        username: "",
        password: ""
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
      async confirm() {
        
        if (!this.username) {
          uni.showToast({
            title: "请输入用户名",
            icon:"none"
          });
          return;
        }
        if (!this.password) {
          uni.showToast({
            title: "请输入密码",
            icon:"none"
          });
          return;
        }
        
        const db = uniCloud.database() //代码块为cdb
        let findres = await db.collection("User_Doctor").where({User_Name: this.username,PassWord:this.password}).get()
        console.log("res===",findres);
        if(findres.result.data.length==0){
          uni.showToast({
            title: "用户名或者密码不正确",
            icon:"none"
          });
          return;
        }
        
        saveUser(findres.result.data[0]);
        

        uni.showToast({
          title: "登录成功",
          duration: 2000
        });
        setTimeout(() => {
          uni.switchTab({
            url: "./index"
          })
        }, 2000);
      },
      goRegister() {
        uni.navigateTo({
          url: "./register"
        })
      },
	  gologin() {
	    uni.navigateTo({
	      url: "/pages/index/login"
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
        width: 80px;
        height: 80px;
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
      
      .password-input {
        font-size: 15px;
        padding-left: 60px;
        margin-top: 10px;
        line-height: 40px;
        height: 40px;
        border-bottom: 1px solid #EEEEEE;
        background-size: 20px 20px;
        background-repeat: no-repeat;
        background-position: 20px center;
        background-image: url("/static/password.png");
      
      }
      
      .login-button {
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
        font-size: 16px;

        .left {}

        .right {}
      }
    }


  }
</style>
