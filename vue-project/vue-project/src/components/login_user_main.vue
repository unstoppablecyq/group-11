<template>
    <div class="poster_con">
        <div class="poster_con_tran">
            <div class="reg_log_box" ref="reg_log_box">
                <el-form :model="ruleForm" 
                        :rules="rules"
                        ref="ruleForm" 
                        label-width="0px"
                        label-position="left" :id="ifhidden1">
                    <h3 class="register_title">
                        注册
                    </h3>
                    <el-form-item label="" prop="username">
                        <el-input 
                        type="text"
                        autocomplete="off"
                        v-model="ruleForm.username"
                        placeholder="请输入账号"
                        prefix-icon="el-icon-user-solid"
                        ></el-input>
                    </el-form-item>
                    <el-form-item label="" prop="email">
                        <el-input 
                        type="email"
                        autocomplete="off"
                        v-model="ruleForm.email"
                        placeholder="请输入邮箱"
                        prefix-icon="el-icon-message"
                        ></el-input>
                    </el-form-item>
                    <el-form-item label="" prop="password">
                        <el-input 
                        type="password" 
                        v-model="ruleForm.password" 
                        autocomplete="off"
                        placeholder="请输入密码"
                        prefix-icon="el-icon-lock"
                        ></el-input>
                    </el-form-item>
                    <el-form-item label="" prop="checkpass">
                        <el-input 
                        type="password" 
                        v-model="ruleForm.checkpass"
                        autocomplete="off"
                        placeholder="请确认密码"
                        prefix-icon="el-icon-lock"
                        ></el-input>
                    </el-form-item>
                    
                    <el-form-item style="text-align: center;">
                        <el-button type="primary" style="background: #505458;border: none;" @click="submitForm('ruleForm')">注册</el-button>
                        <el-button @click="resetForm('ruleForm')">重置</el-button>
                    </el-form-item>
                </el-form>

                <el-form label-position="left" label-width="0px" style="padding-top: 65px;" :id="ifhidden2">
                    <h3 class="login_title">
                        登录
                    </h3>
                    <el-form-item label="">
                        <el-input type="text" v-model="loginForm.username" autocomplete="off" placeholder="账号"></el-input>
                    </el-form-item>
                    <el-form-item label="">
                        <el-input type="password" v-model="loginForm.password" autocomplete="off" placeholder="密码"></el-input>
                    </el-form-item>
                
                    <el-form-item style="text-align: center;">
                        <el-button type="primary" style=" background: #505458;border: none;" @click="Login">登录</el-button>
                    </el-form-item>
                </el-form>
            </div>
            


            <div class="con-box left">
                <h2><span>您好!</span></h2>
                <img  src="@/assets/image/login-logo.png" alt="" style="-webkit-border-radius: 100px;-moz-border-radius: 100px;">
                <p>我已有账号</p>
                <button id="login" @click="LoginGo">登录</button>
            </div>
            <div class="con-box right">
                <h2><span>您好!</span></h2>
                <img src="@/assets/image/login-logo.png" alt="" style="-webkit-border-radius: 100px;-moz-border-radius: 100px;">
                <p>我未有账户</p>
                <button id="register" @click="registerGo">注册</button>
            </div>
        </div>
    </div>
    
</template>

<script>
    export default {
        inject: ['reload'],
        data() {
            var validatePass = (rule, value, callback) => {
                if (value === '') {
                    callback(new Error('请输入密码'));
                } else {
                if (this.ruleForm.checkPass !== '') {
                    this.$refs.ruleForm.validateField('checkpass');
                }
                    callback();
                }
            };
            var validatePass2 = (rule, value, callback) => {
                if (value === '') {
                    callback(new Error('请再次输入密码'));
                } else if (value !== this.ruleForm.password) {
                    callback(new Error('两次输入密码不一致!'));
                } else {
                    callback();
                }
            };
            var checkMail = (rule, value, callback) => {
                const regCN = /[\w!#$%&'*+/=?^_`{|}~-]+(?:\.[\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\w](?:[\w-]*[\w])?\.)+[\w](?:[\w-]*[\w])?/
                if (!regCN.test(value)) {
                    callback(new Error('邮箱格式不正确'))
                } else {
                    callback()
                }
            }
            return {
                ifhidden1: 'hidden',
                ifhidden2: '',
                ruleForm: {
                    username: '',
                    email: '',
                    password: '',
                    checkpass: '',
                },
                loginForm: {
                    username: '',
                    password: '',
                },
                req: {
                    username: '',
                },
                rules: {
                    username: [
                        { required: true, message:"请输入用户名", trigger: 'blur' },
                        { min: 2, max: 9, message:"长度2到10个字符", trigger: 'blur' },
                    ],
                    password: [
                        { validator: validatePass, trigger: 'blur' }
                    ],
                    checkpass: [
                        { validator: validatePass2, trigger: 'blur' }
                    ],
                    email: [
                        { required: true, message: '请输入电子邮箱', trigger: 'blur' },
                        { validator: checkMail, trigger: 'blur' }
                    ],
                }
            };
        },
        methods: {
            submitForm(ruleForm) {
                this.$refs[ruleForm].validate((valid) => {
                    if(valid){
                        this.axios.post('http://localhost:5011/api/register',this.ruleForm).then((resp) =>{
                            //console.log(resp);
                            let data = resp.data;
                            //console.log(data);
                            if(data.success){
                                this.ruleForm = {},
                                this.$message({
                                    message: '注册成功',
                                    type: 'success'
                                });
                            }else{
                                this.$message({
                                    message: data.message,
                                    type: 'error'
                                });
                            }
                        }) 
                    }else{
                        this.$message({
                            message: '请完善注册信息',
                            type: 'error'
                        });
                        return false;
                    }
                })
                
                
            },
            resetForm(ruleForm) {
                this.$refs[ruleForm].resetFields();
            },
            Login(){
                this.axios.post('http://localhost:5011/api/login',this.loginForm).then((resp) =>{
                    //console.log(resp);
                    let data = resp.data;
                    if(data.success){
                        localStorage.setItem('access_info',JSON.stringify(resp.data.content));
                        
                        this.$message({
                            message: 'welcome! '+ data.content.nickname,
                            type: 'success'
                        });

                        this.$store.state.istoken = true ;

                        this.req.username = this.loginForm.username ;
                        this.axios.post('http://localhost:5011/api/getuserorder',this.req).then((resp) =>{
                    
                            let data = resp.data;
                            //拿到orderinfo数据放在localStorage里面
                            localStorage.setItem('order_info',JSON.stringify(data));
                    
                            //console.log(this.$store.state.user_acid_info);
                        })
                        this.$router.push('/');
                    }else{
                        this.$message({
                            message: data.message,
                            type: 'error'
                        });
                    }
                })
            },
            LoginGo(){
                const Regist = this.$refs.reg_log_box
                console.log( Regist );
                Regist.style.transform = 'translateX(0%)'
                this.ifhidden1 = 'hidden'
                this.ifhidden2 = ''
            },
            registerGo(){
                const Regist = this.$refs.reg_log_box
                console.log( Regist );
                Regist.style.transform = 'translateX(80%)'
                this.ifhidden1 = ''
                this.ifhidden2 = 'hidden'
            },
        }
    }
</script>

<style scoped>
    .poster_con{
        height: 800px;
        display: -webkit-box;
        display: -ms-flexbox;
        display: flex;
        justify-content: center;
        align-items: center;
        /* background: linear-gradient(200deg,white,skyblue); */
    }
    .poster_con_tran{
        background-color: #fff;
        width: 650px;
        height: 415px;
        border-radius: 5px;
        box-shadow: 0 0 25px #cacac6;
        position: relative;
    }
    .register_title{
        margin: 0px auto 40px auto;
        text-align: center;
        color:#505458;
    }
    .con-box{
        width: 50%;
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: center;
        position: absolute;
        top: 50%;
        transform: translateY(-50%);
    }
    .con-box.left{
        left: -2%;
    }
    .con-box.right{
        right: -2%;
    }
    .con-box h2{
        color: #8e9aaf;
        font-size: 25px;
        font-weight: bold;
        letter-spacing: 3px;
        text-align: center;
        margin-bottom: 4px;
    }
    .con-box span{
        color: rgb(66, 62, 62);
    }
    .con-box img{
        width: 150px;
        height: 150px;
        opacity: 0.9;
        margin: 40px 0;
    }
    .con-box button{
        margin-top: 3%;
        background-color: #fff;
        color: rgb(66, 62, 62);
        border: 1px solid rgb(66, 62, 62)8;
        padding: 6px 10px;
        border-radius: 5px;
        letter-spacing: 1px;
        outline: none;
        cursor: pointer;
    }
    .login_title{
        margin: 0px auto 40px auto;
        text-align: center;
        color:#505458;
    }
    .reg_log_box{
        position: absolute;
        top: -10%;
        left: 5%;
        width: 250px;
        height: 425px;
        z-index: 2;
        transition: 0.5s ease-in-out;
        border-radius: 5px;
        background-clip: padding-box;
        padding: 75px 35px 0px 35px;
        background: #fff;
        border: 1px solid #eaeaea;
        box-shadow: 0 0 25px #cacac6;
    }
    #hidden{
        display: none;
        transition: 0.5s;
    }
</style>
