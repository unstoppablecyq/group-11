<template>
	<view class="container">
		<!-- <view class="top">
			<image class="top-image" src="../../static/userzone.jpeg"/>
		</view> -->
		<view class="header">
			<image class="head-img" @click="gotologin()" mode="aspectFit" src="../../static/head.png"/>
			<text class="nickname" @click="changeinfo()">{{mine.User_Name}}</text>
		</view>
		<view class="menus">

			<view class="menu-item" @click="gotoOrder()">
				<image class="icon" src="../../static/tabs/friend.png"/>
				<text class="nickname" >订单中心</text>
        <image class="zhankai" src="../../static/zhankai.png"></image>
			</view>
      <view class="menu-item" @click="gotoSetting()">
      	<image class="icon" src="../../static/setting.png"/>
      	<text>设置</text>
        <image class="zhankai" src="../../static/zhankai.png"></image>
      </view>
		</view> 
		</view>
	</view>
</template>

<script>
	import {saveUser,getUser} from '@/utils/storage.js';
	
	export default {
		data() {
			return {
				mine:{}
			}
		},
		onShow() {
      this.mine = getUser();
      if(!this.mine){
        uni.navigateTo({
          url:"../index/login"
        })
        return;
      }
		uni.showShareMenu({
			withShareTicket: true,
			menus:["shareAppMessage","shareTimeline"]
			})
		},
		created(){
			
		},
		methods: {
		gotologin(){
			uni.switchTab({
				url:"/pages/index/login"
				})
			},
		gotoOrder(){
			uni.switchTab({
				url:"./orderlist"
				})
			},
		gotoSetting(){
			uni.navigateTo({
				url:"./setting"
				})
			},
		changeinfo(){
			uni.navigateTo({
				url:"/pages/index/change"
				})
			}
		}
	}
</script>

<style lang="scss" scoped>
	.container{
		background-color: #EEEEEE;
		height: 100%;
		.top{
			width: 100%;
			height: 50vw;
			.top-image{
				width: 100%;
				height: 100%;
			}
		}
		.header{
			background-color: #FFFFFF;
			padding: 10px;
			display: flex;
			flex-direction: row;
			align-items: center;
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
		.menus{
			display: flex;
			margin: 10px 0px;
			background-color: #FFFFFF;
			padding: 15px 10px;
			display: flex;
			flex-direction: column;
			align-items: center;
			.menu-item{
        width: 100%;
				flex: 1;
				display: flex;
				flex-direction: row;
				align-items: center;
				justify-content: center;
        padding: 10px 0px;
				.icon{
					width: 30px;
					height: 30px;
				}
				text{
          flex: 1;
					margin-top: 5px;
					font-size: 14px;
					line-height: 20px;
					color: #666666;
          margin-left: 5px;
				}
        .zhankai{
          width: 20px;
          height: 20px;
        }
			}
			
		}
		.services{
			display: flex;
			margin: 10px;
			background-color: #FFFFFF;
			padding: 5px 10px;
			flex-direction: column;
			border-radius: 5px;
			.caption{
				font-weight: bold;
				color: #000000;
				line-height: 50px;
			}
			.services-wrapper{
				display: flex;
				flex-direction: row;
				align-items: flex-start;
        justify-content: flex-start;
				margin-bottom: 10px;
				view{
					flex: 1;
					display: flex;
					flex-direction: column;
					align-items: center;
					justify-content: center;
					.icon{
						width: 30px;
						height: 30px;
					}
					text{
						margin-top: 5px;
						font-size: 14px;
						line-height: 20px;
						color: #666666;
					}
				}
			}
			
			
		}
		
	}
</style>
