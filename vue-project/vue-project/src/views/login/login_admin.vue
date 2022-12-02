<template>
    <body id="poster">
        <el-form class="login-container" label-position="left" label-width="0px">
            <h3 class="login_title">
                admin login
            </h3>
            <el-form-item label="">
                <el-input type="text" v-model="loginForm.username" autocomplete="off" placeholder="账号"></el-input>
            </el-form-item>
            <el-form-item label="">
                <el-input type="password" v-model="loginForm.password" autocomplete="off" placeholder="密码"></el-input>
            </el-form-item>
        
            <el-form-item style="width:100%;">
                <el-button type="primary" style="width:100%; background: #505458;border: none;" @click="Login()">登录</el-button>
            </el-form-item>
        </el-form>
    </body>
    
</template>
<script>
    export default {
        name: 'login_admin',
        data(){
            return{
                loginForm: {
                    username: '',
                    password: '',
                }
            }
        },
        methods:{
            Login(){
                this.axios.post('http://localhost:5011/api/adminlogin',this.loginForm).then((resp) =>{
                    let data = resp.data;
                    if(data.success){
                        this.loginForm = {};
                        this.$message({
                            message: '登陆成功,欢迎来到后台管理系统',
                            type: 'success'
                        });

                        this.axios.post('http://localhost:5011/api/getnewacid').then((resp) =>{
                    
                            let data = resp.data;
                            console.log(data);
                            //拿到acid数据放在localStorage里面
                            localStorage.setItem('acid_info',JSON.stringify(data));
                    
                            //console.log(this.$store.state.user_acid_info);
                        });
                        
                        this.axios.post('http://localhost:5011/api/getnewcheckbody').then((resp) =>{
                    
                            let data = resp.data;
                            console.log(data);
                            //拿到checkbody数据放在localStorage里面
                            localStorage.setItem('checkbody_info',JSON.stringify(data));
                    
                            //console.log(this.$store.state.user_acid_info);
                        });

                        this.$router.push('/admin');
                    }else{
                        this.$message({
                            message: data.message,
                            type: 'error'
                        });
                    }
                })


            }
        }
    }
    
</script>
<style scoped>
    #poster{
        background-origin: center;
        height: 100%;
        width: 100%;
        background-size: cover;
        position: fixed;
    }
    body{
        margin: 0px;
        padding: 0px;
    }
    .login-container{
        border-radius: 15px;
        background-clip: padding-box;
        margin: 90px auto;
        width: 350px;
        padding: 35px 35px 15px 35px;
        background: #fff;
        border: 1px solid #eaeaea;
        box-shadow: 0 0 25px #cacac6;
    }
    .login_title{
        margin: 0px auto 40px auto;
        text-align: center;
        color:#505458;
    }
</style>