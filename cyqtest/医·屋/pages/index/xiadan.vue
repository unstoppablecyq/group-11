<template>
  <view class="uni-container">
    <uni-forms ref="form" labelWidth="100" :value="formData" validate-trigger="submit" err-show-type="toast">

<!--      <uni-forms-item name="username" label="发货驿站">
        <uni-data-picker :localdata="froms" v-model="formData.place_depart"  @change="onchange"
          @nodeclick="onnodeclick">
        </uni-data-picker>
      </uni-forms-item> -->
<!--      <uni-forms-item name="password" label="取货驿站">
        <uni-data-picker :localdata="tos" v-model="formData.place_arrive"  @change="onchangeTo"
          @nodeclick="onnodeclick">
        </uni-data-picker>
      </uni-forms-item> -->
      <uni-forms-item name="type" label="就诊类型">
        <uni-data-picker :localdata="types" v-model="formData.type"  @nodeclick="onnodeclick">
        </uni-data-picker>
      </uni-forms-item>
<!--      <uni-forms-item name="no" label="货物重量">
        <uni-data-picker :localdata="weights" v-model="formData.weight"  @nodeclick="onnodeclick">
        </uni-data-picker>
      </uni-forms-item> -->
      <uni-forms-item name="class" label="就诊时间">
        <uni-data-picker :localdata="sendTimes" v-model="formData.sendTime" 
          @change="onchangeSendTime" @nodeclick="onnodeclick">
        </uni-data-picker>
      </uni-forms-item>
<!--      <uni-forms-item name="class" label="取货时间">
        <uni-data-picker :localdata="toTimes" v-model="formData.toTime" >
        </uni-data-picker>
      </uni-forms-item> -->
    </uni-forms>
    <!-- <button style="width: 100px;" class="uni-button" @click="showDrawer('showRight')">+题目</button> -->
    <view class="bottom">
      <text class="total-price">总价:¥{{totalPrice}}</text>
      <button class="button" type="primary" @click="submit">提交</button>
    </view>
    <uni-drawer ref="showRight" mode="right" :mask-click="true">
      <view class="scroll-view">
        <scroll-view class="scroll-view-box" scroll-y="true">
          <view class="drawers">
            <view class="row-item" @click="clickItem(item)" v-for="(item,i) in list">
              <view class="row-item-header">
                <text class="title">{{item.title}}</text>
                <text class="score">{{item.score}}分</text>
              </view>
              <view class="sel-item" v-for="(it,i) in item.items">
                <text class="name">{{it.name}}</text>
                <text class="title">{{it.title}}</text>
              </view>
            </view>
          </view>
        </scroll-view>
      </view>
    </uni-drawer>
  </view>
</template>

<script>
  import {saveUser,getUser} from '@/utils/storage.js';
  const db = uniCloud.database();
  const dbCollectionName = 'uni';
  import * as utils from "@/utils/utils.js";
  export default {
    data() {
      return {
        formData: {
          "place_depart": "",
          "place_arrive": "",
          "weight": "",
          "type": "",
          "sendTime": "",
          "toTime": ""
        },
        froms: [],
        list: [],
        tos: [],
        types: [{
          text: "视力",
          value: "1",
        }, {
          text: "血压",
          value: "2",
        },{
          text: "核酸",
          value: "3",
        }],
        
        sendTimes: [
			{
			  text: "8:00",
			  value: "8",
			},
			{
			  text: "12:00",
			  value: "12",
			},
			{
			  text: "16:00",
			  value: "16",
			}
		],
        toTimes: [],
        selectLine: null,
        sendTimeObj:null,
      }
    },

    methods: {

      },


      async submitForm(value) {


        if (!this.formData.type) {
          uni.showToast({
            title: "请选择就诊类型",
            icon: "none"
          });
          return;
        }

        if (!this.formData.toTime) {
          uni.showToast({
            title: "请选择取货日期",
            icon: "none"
          });
          return;
        }


        let params = {

		  Patient_id:this.User_Name.id,
	      Doctor_id:"",
          Date: this.formData.type,
		  DiagnosticStatus:0,
		  AuditStatus:false         

        };

        // 使用 clientDB 提交数据
        return db.collection("order").add(params).then((res) => {
          uni.showToast({
            icon: 'none',
            title: '寄件成功'
          })
        }).catch((err) => {
          uni.showModal({
            content: err.message || '请求服务失败',
            showCancel: false
          })
        })
      }
    }
  
</script>

<style lang="less">
  .uni-container {
    padding: 15px;
  }

  .uni-input-border,
  .uni-textarea-border {
    width: 100%;
    font-size: 14px;
    color: #666;
    border: 1px #e5e5e5 solid;
    border-radius: 5px;
    box-sizing: border-box;
  }

  .uni-input-border {
    padding: 0 10px;
    height: 35px;

  }

  .uni-textarea-border {
    padding: 10px;
    height: 80px;
  }


  .cates {
    margin-top: 10px;
    height: 100%;
    background-color: #fff;
    color: #444;
    display: flex;
    flex-direction: row;
    flex-wrap: wrap;

    .cate {
      padding: 2px 10px;
      border-radius: 5px;
      margin: 0px 10px 10px 0px;
      background: #eee;
      cursor: pointer;
      font-size: 15px;
      color: #444;

      &:hover {
        color: #5454ff;
      }

      &.selected {
        background: #5454ff;
        color: #fff;
      }
    }
  }

  .items {
    .row-item {
      display: flex;
      flex-direction: column;
      background-color: #F3f5f6;
      margin: 10px;

      .row-item-header {
        display: flex;
        align-items: center;
        padding: 10px;
        color: #666;
        margin-bottom: 10px;
        border-radius: 10px;

        .title {
          margin-right: 10px;
          flex: 1;
        }

        .score {
          color: #676dff;
          font-weight: bold;
        }
      }

      .sel-item {
        margin-left: 10px;
        margin-right: 10px;
        margin-bottom: 10px;
        display: flex;
        align-items: center;
        padding: 10px;
        color: #666;
        border: 1px solid #ddddff;
        border-radius: 5px;
        margin-bottom: 10px;

        .name {
          margin-right: 10px;
        }

        .title {
          flex: 1;
        }
      }

    }
  }

  .bottom {
    bottom: 0px;
    padding: 10px;
    background-color: #f3f5f8;
    left: 0px;
    right: 0px;
    position: fixed;
    display: flex;
    align-items: center;
    justify-content: space-between;

    .button {
      width: 184px;
      padding: 12px 20px;
      font-size: 14px;
      border-radius: 4px;
      line-height: 1;
      margin: 0;
    }

    .total-price {
      font-weight: bold;
      color: red;
    }
  }
</style>
