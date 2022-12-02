<script>
    let id = 0
    //let id2 = 0
    export default{
        data(){
            return{
                header_text: '医•屋',
                header_mod_list: [
                    { id: id++ , text: '首页' },
                    { id: id++ , text: '主要功能' , 
                        // second_list: [
                        // { id2 : id2++ , con: '核酸预约' },
                        // { id2 : id2++ , con: '体检预约' },
                        // { id2 : id2++ , con: '视力检测矫正' },
                        // //{ id2 : id2++ , con: '药物购买' },
                        // ]
                    },
                    { id: id++ , text: '个人中心' },
                ],
                user:{
                    nickname: this.$store.state.user_access_info.nickname,
                },
                //k : false ,
                loginbtn: false,
                oklogin: JSON.parse(window.localStorage.getItem('access_info')),


            }
        },
        methods: {
            // list_show(e){
            //     this.k = ( (e.id == 1) ? true : false )
            // },
            loginbtn_show(){
                this.loginbtn = true;
            },
            loginbtn_hid(){
                this.loginbtn = false;
            },
            loginout(){
                this.$store.state.istoken = false
                window.localStorage.removeItem('access_info');
                location.replace('/')
            },
            Go(e){
                if(e.id == 0){
                    this.$router.push('/')
                }else{
                    if(e.id == 2){
                        this.$router.push('/user_space') 
                    }else{
                        this.$router.push('/all_function')
                    }
                }
            },
            changepass(){
                this.$router.push('/login_changepass')
            }
        },
        
        watch: {
            //监听vuex中istoken数据，如果发生变化并且是true则刷新all_header重新渲染all_header组件
            '$store.state.istoken': function () {
                if(this.$store.state.istoken == true){
                    location.replace('/')
                }
            },
        }
    }
</script>

<template>
    <div class="mod_header">
        <div class="section_inner">
            <div class="header_logo">
                <p style="font-size: 30px;color: #000;font: SimHei;">{{ header_text }}</p>
            </div>
            <div class="header_2">
                <ul class="header_filter">
                    <li class="header_filter_item1" v-for="e in header_mod_list" :key="e.id">
                        <router-link to="" @click.native="Go(e)" >{{ e.text }}</router-link>
                        <!-- <ul class="item1_mod1" v-show="k" style="opacity: 0.85;">
                            <li v-for="i in e.second_list" :key="i.id2">
                                <router-link to="" @click.native="power(i)">{{ i.con }}</router-link>
                            </li>
                        </ul> -->
                    </li> 
                </ul>
            </div>
            <div class="header_login">
                <div class="btn_login">
                    <div v-show="!oklogin">
                        <router-link to="/login_select"><span style="font-weight: bold;">登录/注册</span></router-link>
                    </div>
                    <div class="btn_login_info_loginout" @mouseenter="loginbtn_show()" @mouseleave="loginbtn_hid()" v-show="oklogin">
                        <div class="btn_login_info">
                            {{user.nickname}}
                        </div>
                        <ul v-show="loginbtn">
                            <li>
                                <router-link to="" @click.native="changepass()">修改密码</router-link>
                            </li>
                            
                            <li>
                                <router-link to="" @click.native="loginout()">退出</router-link>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<style scoped>
    .mod_header{
        position: fixed;
        top: 0; left: 0; right: 0;
        z-index: 1000;
        background-color: #fff;
    }
    .section_inner{
        display: flex;
        text-align: center;
        align-items: center;
        justify-content: space-between;
        height: 100px ;
        margin: 0 auto;
        position: relative;
        padding: 0 0.8rem;
    }
    .header_logo{
        float: left;
        width: 350px;
        height: 100px;
        text-align: center;
        line-height: 100px;
    }
    .header_2{
        float: left;
        width: 1050px;
        height: 100px;
    }
    .header_filter{
        height : 100px;
        line-height: 100px;
        padding-left: 275px;
    }
    .header_filter_item1 {
        list-style: none ;
        float: left;
        font-size: 20px;
        color: #c1c1c1;
    }
    .item1_mod1{
        display: none;
        position: absolute;
        background-color: white;
    }
    .header_filter_item1:hover .item1_mod1{
        display: block;
    }
    .header_login{
        float: left;
        width: 200px;
        height: 100px;
        text-align: center;
        position: relative;
    }
    .btn_login{
        width: 140px;
        height: 50px;
        position: absolute;
        left: 50%;
        top: 50%;
        text-align: center;
        line-height: 50px;
        transform: translate(-50%,-50%);
        -webkit-border-radius: 10px;
        border-radius: 10px;
    }
    .btn_login_info{
        border-bottom: 1px solid;
    }
    .btn_login_info_loginout:hover{
        color: #03a2cb;
    }
    .btn_login_info_loginout{
        background-color: #ffffff;
        opacity: 0.8;
    }
</style>
