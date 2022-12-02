import Vue from 'vue'
import Vuex from 'vuex'

import pic_default from '@/assets/image/pic_default.jpeg'
import pic_2 from '@/assets/image/pic_2.jpg'
import pic_3 from '@/assets/image/pic_3.jpg'

Vue.use(Vuex)

const store = new Vuex.Store({
    
    state:{
        user_access_info: {
            id: 
                window.localStorage.getItem('access_info') != null ?
                JSON.parse(window.localStorage.getItem('access_info')).id
                : 1 ,
            image: 
                window.localStorage.getItem('access_info') != null ?
                JSON.parse(window.localStorage.getItem('access_info')).image
                : 1 ,
            nickname:
                window.localStorage.getItem('access_info') != null ?
                JSON.parse(window.localStorage.getItem('access_info')).nickname
                : 'visitor' ,
            username:
                window.localStorage.getItem('access_info') != null ?
                JSON.parse(window.localStorage.getItem('access_info')).username
                : 'test',
            age: 
                window.localStorage.getItem('access_info') != null ?
                JSON.parse(window.localStorage.getItem('access_info')).age
                : 20 ,
            sex: 
                window.localStorage.getItem('access_info') != null ?
                JSON.parse(window.localStorage.getItem('access_info')).sex
                : '男' ,
            email: 
                window.localStorage.getItem('access_info') != null ?
                JSON.parse(window.localStorage.getItem('access_info')).email
                : 'null',
            phonenumber: 
                window.localStorage.getItem('access_info') != null ?
                JSON.parse(window.localStorage.getItem('access_info')).phonenumber
                : 'null',
            address: 
                window.localStorage.getItem('access_info') != null ?
                JSON.parse(window.localStorage.getItem('access_info')).address
                : 'null',
            token:
                window.localStorage.getItem('access_info') != null ?
                JSON.parse(window.localStorage.getItem('access_info')).token
                : 'null',
        },

        istoken: false, 

        user_acid_info: 
            window.localStorage.getItem('acid_info') != null ?
            JSON.parse(window.localStorage.getItem('acid_info')) : [] ,
        
        user_checkbody_info: 
            window.localStorage.getItem('checkbody_info') != null ?
            JSON.parse(window.localStorage.getItem('checkbody_info')) : [] ,

        user_order_info:
            window.localStorage.getItem('order_info') != null ?
            JSON.parse(window.localStorage.getItem('order_info')) : [] ,
    },
})

export default store
