<template>
<view class="container">
    <view class="content">
	<view class="head">修改信息</view>
	<view class="vcode">
	  <input class="vcode-input" type="char"  v-model="User_Name">用户名：{{change.User_Name}}<input>
	</view>
      <view class="vcode">
        <input class="vcode-input" type="password" placeholder="请输入修改密码" v-model="PassWord">
      </view>
	  <view class="pnum">
	    <input class="vcode-input" type="char" placeholder="请输入修改联系方式" v-model="PhoneNumber">
	  </view>
	  <view class="address">
	    <input class="vcode-input" type="char" placeholder="请输入修改地址" v-model="Address">
	  </view>
	  
	  <br>
      <view class="confirm-button" @click="confirm">确认</view>
    </view>
	
  </view>
</template>

<script>
	import {saveUser,getUser} from '@/utils/storage.js';
	
	export default {
		data() {
			return {
				
			}
		},
		
		onShow() {
		this.change = getUser();
		},
	methods: {
		
		async confirm() {
		
		  if (!this.PassWord) {
		    uni.showToast({
		      title: "请输入密码",
		      icon: "none"
		    });
		    return;
		  }
		  if (!this.PhoneNumber) {
		    uni.showToast({
		      title: "请输入联系方式",
		      icon: "none"
		    });
		    return;
		  }
		  if (!this.Address) {
		    uni.showToast({
		      title: "请输入地址",
		      icon: "none"
		    });
		    return;
		  }	
		
		//连数据库
		const db = uniCloud.database(); //代码块为cdb

		let findres = await db.collection("User_Patient").where({
		  User_Name: this.User_Name
		}).get()
		console.log("res===", findres);
		
		//更新操作，上传修改信息
		let res = await db.collection("User_Patient").update({
		  //User_Name: this.User_Name,
		  PassWord: this.PassWord,
		  PhoneNumber:this.PhoneNumber,
		  Address:this.Address,
		  Sex:0,
		  Active:false,
		})
		console.log("res===", res);
		if (res.result.code == 0) {
		  uni.showToast({
		    title: "修改成功",
		    duration: 2000,
		  });
		  setTimeout(() => {
		    uni.navigateTo({
		      url: "./mine"
		    })
		  }, 2000)
		}		
		
		
	}
}}
</script>

<style>

</style>
