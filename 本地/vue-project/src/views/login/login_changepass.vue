<template>
    <el-form :model="change_pass_form"
            :rules="rules" 
            ref="change_pass_form" 
            class="login-container" 
            label-position="left" 
            label-width="0px" >
        <h3 class="login_title">
            修改密码
        </h3>
        <el-form-item label="" prop="oldpass">
            <el-input type="text" v-model="change_pass_form.oldpass" autocomplete="off" placeholder="旧密码"></el-input>
        </el-form-item>
        
        <el-form-item label="" prop="newpass">
            <el-input type="password" v-model="change_pass_form.newpass" autocomplete="off" placeholder="新密码"></el-input>
        </el-form-item>
        
        <el-form-item label="" prop="checknewpass">
            <el-input type="password" v-model="change_pass_form.checknewpass" autocomplete="off" placeholder="确认新密码"></el-input>
        </el-form-item>

        <el-form-item style="text-align: center;">
            <el-button type="primary" style="background: #505458;border: none;" @click="chanGe('change_pass_form')">修改</el-button>
        </el-form-item>
    </el-form>
</template>

<script>
    export default {
        data(){
            var validatePass = (rule, value, callback) => {
                if (value === '') {
                    callback(new Error('请输入新密码'));
                } else {
                if (this.change_pass_form.checknewpass !== '') {
                    this.$refs.change_pass_form.validateField('checknewpass');
                }
                    callback();
                }
            };
            var validatePass2 = (rule, value, callback) => {
                if (value === '') {
                    callback(new Error('请再次输入密码'));
                } else if (value !== this.change_pass_form.newpass) {
                    callback(new Error('两次输入密码不一致!'));
                } else {
                    callback();
                }
            };
            return{
                change_pass_form:{
                    username: this.$store.state.user_access_info.username ,
                    oldpass: '' ,
                    newpass: '' ,
                    checknewpass: '',
                },
                

                rules: {
                    oldpass: [
                        { required: true, message:"请输入旧密码", trigger: 'blur' }
                    ],
                    newpass: [
                        { validator: validatePass, trigger: 'blur' }
                    ],
                    checknewpass: [
                        { validator: validatePass2, trigger: 'blur' }
                    ],
                }
            }
        },
        methods:{
            chanGe(change_pass_form){
                this.$refs[change_pass_form].validate((valid) => {
                    if(valid){
                        this.axios.post('http://localhost:5011/api/changepass',this.change_pass_form).then((resp) =>{
                            //console.log(resp);
                            let data = resp.data;
                            //console.log(data);
                            if(data){
                                this.$message({
                                    message: '修改成功',
                                    type: 'success'
                                });
                                this.$store.state.istoken = false
                                window.localStorage.removeItem('access_info');
                                location.replace('/login_user')
                            }else{
                                this.$message({
                                    message: '服务器错误',
                                    type: 'error'
                                });
                            }
                        }) 
                    }else{
                        this.$message({
                            message: '请完善修改信息',
                            type: 'error'
                        });
                    }
                })
                
            }
        }
    }
</script>

<style scoped>
    .login-container{
        border-radius: 5px;
        background-clip: padding-box;
        margin: 90px auto;
        width: 250px;
        height: 375px;
        padding: 75px 35px 15px 35px;
        background: #fff;
        border: 1px solid #eaeaea;
        box-shadow: 0 0 25px #cacac6;
    }
    .login_title{
        margin: 0px auto 50px auto;
        text-align: center;
        color:#505458;
    }
</style>