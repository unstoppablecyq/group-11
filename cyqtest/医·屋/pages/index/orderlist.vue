<template>
  <view class="container">
    <view>
      <view class="item" :title="item.title" :clickable="true" @click="clickItem(item)" v-for="(item,i) in list">
        <view class="title"><text>{{item.place_depart}}///{{item.place_arrive}}</text></view>
        <view class="tail">
          <text class="teacher">下单时间:20221111{{item.sendTime}}</text>
		  <text class="time">订单审核状态:未审核{{item.price}}</text>
          <text class="time">治疗时间:未诊断{{item.toTime}}</text>
        </view>
        <view class="tail" style="justify-content: flex-end;flex-direction: row;">
          <text class="time" style="color: #888;font-size: 13px;">下单时间:{{item.createtime}}</text>
        </view>
      </view>
    </view>
	<view>
	  <view class="item" :title="item.title" :clickable="true" @click="clickItem(item)" v-for="(item,i) in list">
	    <view class="title"><text>{{item.place_depart}}///{{item.place_arrive}}</text></view>
	    <view class="tail">
	      <text class="teacher">下单时间:20221119{{item.sendTime}}</text>
		  <text class="time">订单审核状态:已审核{{item.price}}</text>
	      <text class="time">治疗时间:已诊断{{item.toTime}}</text>
	    </view>
	    <view class="tail" style="justify-content: flex-end;flex-direction: row;">
	      <text class="time" style="color: #888;font-size: 13px;">下单时间:{{item.createtime}}</text>
	    </view>
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
        list: []
      }
    },
    onShow() {
      this.user = getUser();
      // if (!getUser()) {
      //   uni.navigateTo({
      //     url: "./login"
      //   })
      // } else {
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
        this.loadData();
      // }
    },
    methods: {
      clickItem(item) {
        console.log("item===", item);
        uni.navigateTo({
          url: "../kecheng/detail?id=" + item.kechengid
        });
      },
      async loadData() {
        const db = uniCloud.database() //代码块为cdb
        let findres = await db.collection("Order").where({}).get()
        this.list = findres.result.data;
      },
      handleLoad(data, ended, pagination) {
        console.log("data===", data);
        this.dataList = data;
        // this.todayIn = this.getData(data,moment().startOf('day').valueOf(),1);

        // `data` 当前查询结果
        // `ended` 是否有更多数据
        // `pagination` 分页信息 HBuilderX 3.1.5+ 支持
      },
      //获取数据
      getData(data, endDate, type) {
        let fs = data.filter((item) => {
          console.log(item.create_time, endDate)

          return item.create_time >= endDate && (type === 1 ? item.Balance > 0 : item.Balance < 0)
        });
        console.log("fs", fs)
        let value = fs.reduce((total, item) => {
          return total + parseFloat(item.Balance)
        }, 0)
        return value
      },
      add() {
        uni.navigateTo({
          url: '/pages/kecheng/add'
        })
      }
    }
  }
</script>

<style lang="less">
  .container {
    background-color: #fff;
    height: 100%;
  }

  .item {
    display: flex;
    flex-direction: column;
    padding: 0px 10px 0px 0px;
    background-color: #fff;
    margin: 10px;
    border-bottom: 1px solid #eee;
    padding: 10px 0px;
    align-items: flex-start;
    font-size: 15px;
    .title{
      font-weight: bold;
    }
    .tail {
      margin-top: 0px;
      width: 100%;
      display: flex;
      flex-direction: column;
      color: #666;
      line-height: 30px;
      justify-content: space-between;
    }
  }

  .add-button {
    background-color: #5465ff;
    color: #fff;
    text-align: center;
    border-radius: 5px;
    padding: 5px 10px;
    width: 60px;
    font-size: 13px;
    margin-bottom: 10px;
    margin-right: 10px;
  }
</style>
