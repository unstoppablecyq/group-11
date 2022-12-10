<template>
	<view class="container">
		<view class="menus">
			<!-- <view class="row"  @click="gotoSetting()">
				<text class="nickname" >头像</text>
        <image style="width: 50px;height: 50px;" :src="mine.headimg || '../../static/images/headimg.jpg'"></image>
			</view> 
			<view class="row"  @click="gotoGuanzhu()">
				<text class="nickname" >昵称</text>
        <text>{{mine.nickname}}</text>
			</view> -->
      <!-- <view class="row"  @click="gotoNickname()">
      	<text class="nickname" >修改昵称</text>
        <image class="zhankai" src="../../static/images/zhankai.png"></image>
      </view> -->
		</view>
    <view class="button" style="margin-top: 20px;"  @click="logout()">
    	退出登录
    </view>
    <!-- <view class="version">
    	当前版本:1.0.3
    </view>
    <view class="agreement">
    	<text   @click="gotoAgreement()">《用户协议》</text>
    </view> -->
	</view>
</template>

<script>
	import {saveUser,getUser,clear} from '@/utils/storage.js';
	
	export default {
		data() {
			return {
				mine:{}
			}
		},
		onShow() {
			
		},
		created(){
			
			this.mine = getUser();
			
		},
		methods: {
      gotoAgreement(){
        uni.redirectTo({
          url: "/pages/webview/webview?url=https://www.xiaowanwu.cn/safe/agreement"
        })
      },
      back(){
        clear();
				uni.switchTab({
					url:"../mine/mine"
				})
			},
			logout(){
        clear();
				uni.navigateTo({
					url:"../index/login"
				})
			},
      gotoBank(){
        uni.navigateTo({
        	url:"./bank"
        })
      },
      gotoLoginPassword(){
        uni.navigateTo({
        	url:"./loginPassword"
        })
      },
      gotoPayPassword(){
        uni.navigateTo({
        	url:"./payPassword"
        })
      },
      gotoMobile(){
        uni.navigateTo({
        	url:"./mobileManager"
        })
      },
      gotoNickname(){
        uni.navigateTo({
        	url:"./nicknameManager"
        })
      },
		}
	}
</script>

<style lang="scss" scoped>
	.container{
		background-color: #FFFFFF;
		height: 100%;
    box-sizing: border-box;
		.top{
			width: 100%;
			height: 60vw;
      position:relative;
			.top-image{
        position: absolute;
				width: 100%;
				height: 100%;
			}
      .header{
        width: 100%;
        height: 100%;
      	background-color: #FFFFFF;
      	padding: 10px;
      	display: flex;
      	flex-direction: row;
      	align-items: center;
      	border-radius: 5px;
      	.head-img{
      		width: 80px;
      		height: 80px;
      		border-radius: 5px;
      	}
      	.nickname{
      		padding-left: 10px;
      		color: #333;
      	}
      }
		}
		
		.menus{
			display: flex;
			background-color: #FFFFFF;
			display: flex;
			flex-direction: column;
			align-items: flex-start;
			border-radius: 5px;
      margin-top: -20px;
      border-radius: 20px;
      z-index: 1;
      position: relative;
      padding: 5px 0px;
			.row{
				flex: 1;
				display: flex;
				flex-direction: row;
				align-items: center;
				justify-content: space-between;
        padding: 15px 15px;
        width: 100%;
        border-bottom: 1px solid #F6F6F6;
				.icon{
					width: 30px;
					height: 30px;
				}
				text{
          margin-left: 10px;
					margin-top: 5px;
					font-size: 14px;
					line-height: 20px;
					color: #666666;
				}
        .zhankai{
        	width: 15px;
        	height: 15px;
        }
			}
		}
    
    .button{
      text-align: center;
      margin: 10px 15px;
      width: calc(100% - 30px);
      box-sizing: border-box;
      background-color: #F5F6F9;
      border-radius: 5px;
      height: 40px;
      line-height: 40px;
      color: #4D4D4D;
    }
    .version{
      font-size: 13px;
      color: #333333;
      padding-left: 20px;
    }
    .agreement{
      text-align: center;
      color: #FF4309;
    }
		
	}
</style>
