<template>
  <view class="uni-container">
    <uni-forms ref="form" labelWidth="100" :value="formData" validate-trigger="submit" err-show-type="toast">

      <uni-forms-item name="username" label="发货驿站">
        <uni-data-picker :localdata="froms" v-model="formData.place_depart" popup-title="请选择发货驿站" @change="onchange"
          @nodeclick="onnodeclick">
        </uni-data-picker>
      </uni-forms-item>
      <uni-forms-item name="password" label="取货驿站">
        <uni-data-picker :localdata="tos" v-model="formData.place_arrive" popup-title="请选择取货驿站" @change="onchangeTo"
          @nodeclick="onnodeclick">
        </uni-data-picker>
      </uni-forms-item>
      <uni-forms-item name="type" label="货品类型">
        <uni-data-picker :localdata="types" v-model="formData.type" popup-title="请选择货品类型" @nodeclick="onnodeclick">
        </uni-data-picker>
      </uni-forms-item>
      <uni-forms-item name="no" label="货物重量">
        <uni-data-picker :localdata="weights" v-model="formData.weight" popup-title="请选择货物重量" @nodeclick="onnodeclick">
        </uni-data-picker>
      </uni-forms-item>
      <uni-forms-item name="class" label="投递时间">
        <uni-data-picker :localdata="sendTimes" v-model="formData.sendTime" popup-title="请选择送货日期"
          @change="onchangeSendTime" @nodeclick="onnodeclick">
        </uni-data-picker>
      </uni-forms-item>
      <uni-forms-item name="class" label="取货时间">
        <uni-data-picker :localdata="toTimes" v-model="formData.toTime" popup-title="请选择取货日期">
        </uni-data-picker>
      </uni-forms-item>
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
  // const db = uniCloud.database();
  // const dbCollectionName = 'uni';
  // import * as utils from "@/utils/utils.js";
  // export default {
  //   data() {
  //     return {
  //       formData: {
  //         "place_depart": "",
  //         "place_arrive": "",
  //         "weight": "",
  //         "type": "",
  //         "sendTime": "",
  //         "toTime": ""
  //       },
  //       froms: [],
  //       list: [],
  //       tos: [],
  //       types: [{
  //         text: "普通日用品",
  //         value: "1",
  //       }, {
  //         text: "特殊物流",
  //         value: "2",
  //       }],
  //       weights: [{
  //         text: "1kg",
  //         value: "1",
  //       }, {
  //         text: "2kg",
  //         value: "2",
  //       }, {
  //         text: "3kg",
  //         value: "3",
  //       }, {
  //         text: "4kg",
  //         value: "4",
  //       }, {
  //         text: "5kg",
  //         value: "5",
  //       }, {
  //         text: "6kg",
  //         value: "6",
  //       }],
  //       sendTimes: [],
  //       toTimes: [],
  //       selectLine: null,
  //       sendTimeObj:null,
  //     }
  //   },
  //   computed: {
  //     totalPrice: function() {
  //       if (this.selectLine && this.formData.weight) {
  //         return this.selectLine.price * this.formData.weight;
  //       }
  //       return 0;
  //     }
  //   },
  //   onReady() {},
  //   onLoad() {
  //     this.loadData();

  //   },
  //   methods: {
  //     async loadData() {
  //       const db = uniCloud.database() //代码块为cdb
  //       let findres = await db.collection("based-price").where({}).get()

  //       this.list = findres.result.data;
  //       let keys = {};
  //       this.list.map(item => item.place_depart).forEach((item) => {
  //         keys[item] = 0;
  //       });

  //       this.froms = Object.keys(keys).map((item) => {
  //         return {
  //           text: item,
  //           value: item
  //         }
  //       })
  //     },
  //     onnodeclick(value) {
        
  //     },
      
  //     onchange(value) {
  //       console.log("value2222===", value);

  //       let keys = {};
  //       let vs = this.list.filter(item => item.place_depart === value.detail.value[0].text);
  //       console.log("vs===", vs, value.detail.value.text);

  //       vs.forEach((item) => {
  //         keys[item.place_arrive] = 0;
  //       });


  //       this.tos = Object.keys(keys).map((item) => {
  //         return {
  //           text: item,
  //           value: item
  //         }
  //       })

  //     },

  //     onchangeTo(value) {
  //       this.selectLine = this.list.find(item => item.place_depart === this.formData.place_depart && item
  //         .place_arrive === value.detail.value[0].text);

  //       let time = this.selectLine.time;
  //       let now = utils.formatDate(new Date(), "HH:mm");
        
  //       this.sendTimes = time.filter((item) => {
  //         let t = Object.keys(item)[0];
  //         if(t=="weight"){
  //           t = Object.keys(item)[1];
  //         }
  //         let secondsT = t.split(":")[0]*60+t.split(":")[1]*1;
  //         let secondsNow = now.split(":")[0]*60+now.split(":")[1]*1;
          
  //         console.log("now===", secondsT, secondsNow);
          
  //         return secondsT > secondsNow;
  //       }).map(it => {
  //         let t = Object.keys(it)[0];
  //         if(t=="weight"){
  //           t = Object.keys(it)[1];
  //         }
  //         return {
  //           text: t,
  //           value: t
  //         }
  //       })

  //       console.log("this.selectLine===", this.selectLine, this.sendTimes);

  //       // this.sendTimes = time.map(it => ({
  //       //   text: Object.keys(it)[0],
  //       //   value: Object.keys(it)[0]
  //       // }))
  //     },

  //     async onchangeSendTime(value) {
  //       let t = value.detail.value[0].text;

  //       let find = this.selectLine.time.find(it => {
  //         return Object.keys(it)[0] === t || Object.keys(it)[1] === t
  //       });
  //       this.toTimes = find[t].map(it => ({
  //         text: it,
  //         value: it
  //       }));
  //       let totalWeight = await this.getTotalWeight(t);
  //       console.log("totalWeight",totalWeight,find);
  //       this.sendTimeObj = find;
  //       if(totalWeight>=find.weight){
  //         uni.showToast({
  //           title:"当前时间快递已满,请换其他时间段",
  //           icon:"none"
  //         })
  //         this.formData.sendTime = "";
  //       }
        
  //     },
      
  //     // 获取已经寄件的订单重量
  //     async getTotalWeight(time){
  //       const db = uniCloud.database() //代码块为cdb
  //       let findres = await db.collection("dingdan").where({
  //         "place_depart":this.formData.place_depart,
  //         "place_arrive":this.formData.place_arrive,
  //         "sendTime":time
  //       }).get()
  //       console.log("getTotalWeight",findres.result.data,time);
        
  //       let totalWeight = findres.result.data.reduce((total, item) => {
  //         return total + item.weight
  //       }, 0);
  //       return totalWeight;
  //     },

  //     /**
  //      * 验证表单并提交
  //      */
  //     submit() {
  //       uni.showLoading({
  //         mask: true
  //       })
  //       this.$refs.form.validate().then((res) => {
  //         return this.submitForm(res)
  //       }).catch(() => {}).finally(() => {
  //         uni.hideLoading()
  //       })
  //     },

  //     /**
  //      * 提交表单
  //      */
  //     async submitForm(value) {
  //       if (!this.formData.place_depart) {
  //         uni.showToast({
  //           title: "请输入发货驿站",
  //           icon: "none"
  //         });
  //         return;
  //       }
  //       if (!this.formData.place_arrive) {
  //         uni.showToast({
  //           title: "请输入取货驿站",
  //           icon: "none"
  //         });
  //         return;
  //       }

  //       if (!this.formData.type) {
  //         uni.showToast({
  //           title: "请选择货品类型",
  //           icon: "none"
  //         });
  //         return;
  //       }
  //       if (!this.formData.weight) {
  //         uni.showToast({
  //           title: "请选择货物类型",
  //           icon: "none"
  //         });
  //         return;
  //       }
  //       if (!this.formData.sendTime) {
  //         uni.showToast({
  //           title: "请选择送货日期",
  //           icon: "none"
  //         });
  //         return;
  //       }
  //       if (!this.formData.toTime) {
  //         uni.showToast({
  //           title: "请选择取货日期",
  //           icon: "none"
  //         });
  //         return;
  //       }
        
  //       let totalWeight = await this.getTotalWeight(this.formData.sendTime);
        
  //       if((totalWeight)>=this.sendTimeObj.weight){
  //         uni.showToast({
  //           title:"当前时间快递已满,请换其他时间段",
  //           icon:"none"
  //         })
  //         this.formData.sendTime = "";
  //         return;
  //       }else if((totalWeight+this.formData.weight)>this.sendTimeObj.weight){
  //         uni.showToast({
  //           title:"请减少快递重量,或者请换其他时间段",
  //           icon:"none"
  //         })
  //         return;
  //       }
        
        

  //       let params = {
  //         place_depart: this.formData.place_depart,
  //         place_arrive: this.formData.place_arrive,
  //         type: this.formData.type,
  //         weight: parseInt(this.formData.weight),
  //         sendTime: this.formData.sendTime,
  //         toTime: this.formData.toTime,
  //         price: this.totalPrice,
  //         createtime: utils.formatDate(new Date(),"yyyy-MM-dd HH:mm:ss")
  //       };

  //       // 使用 clientDB 提交数据
  //       return db.collection("dingdan").add(params).then((res) => {
  //         uni.showToast({
  //           icon: 'none',
  //           title: '寄件成功'
  //         })
  //       }).catch((err) => {
  //         uni.showModal({
  //           content: err.message || '请求服务失败',
  //           showCancel: false
  //         })
  //       })
  //     }
  //   }
  // }
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
