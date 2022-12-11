<script>
    export default{
        
        data(){
            return{

                radio1: this.$store.state.user_access_info.sex,

                nickname_: this.$store.state.user_access_info.nickname,
                age_: this.$store.state.user_access_info.age,

                email_: this.$store.state.user_access_info.email,
                phonenumber_: this.$store.state.user_access_info.phonenumber,
                address_: this.$store.state.user_access_info.address,

            }
        },
        methods: {
            submitinfo(){
                this.$store.state.user_access_info.nickname = this.nickname_ ;
                this.$store.state.user_access_info.age = this.age_ ;
                this.$store.state.user_access_info.email = this.email_ ;
                this.$store.state.user_access_info.phonenumber = this.phonenumber_ ;
                this.$store.state.user_access_info.address = this.address_ ;
                this.$store.state.user_access_info.sex = this.radio1;
                this.axios.post('http://localhost:5011/api/saveuser',this.$store.state.user_access_info).then((resp) =>{
                    let data = resp.data;
                    if(data.success){
                        localStorage.setItem('access_info',JSON.stringify(resp.data.content));
                        
                        this.$message({
                            message: '修改成功',
                            type: 'success'
                        });
                        location.replace('/user_space/user_spaceinfo')
                        
                    }else{
                        this.$message({
                            message: '服务器保存失败',
                            type: 'error'
                        });
                    }
                })
            },
        },
        created(){
            //this.test();
        }
    }
</script>

<template>
    <div>
        <el-card style="height: 700px;width: 800px;margin: auto;top: 0; left: 0; bottom: 0; right: 0;">
            <el-descriptions class="margin-top" title="个人信息" :column="2" >
                <template slot='extra'>
                    <el-button type='primary' size='small' @click="submitinfo">保存</el-button>
                </template>
                <el-descriptions-item>
                    <template slot="label">
                        <i class="el-icon-user"></i>用户名
                    </template>
                    <el-input type="text" v-model="nickname_"></el-input>
                </el-descriptions-item>
                <!-- <el-descriptions-item>
                    <template slot="label">
                        <i class="el-icon-s-custom"></i>昵称
                    </template>
                    {{ nickname }}
                </el-descriptions-item> -->
                <el-descriptions-item>
                    <template slot="label">
                        <i class="el-icon-odometer"></i>年龄
                    </template>
                    <el-input type="text" v-model="age_"></el-input>
                </el-descriptions-item>
                <el-descriptions-item>
                    <template slot="label">
                        <i class="el-icon-male"></i>
                        <i class="el-icon-female"></i>性别
                    </template>
                    <el-radio v-model="radio1" label="1" border>男</el-radio>
                    <el-radio v-model="radio1" label="0" border>女</el-radio>
                </el-descriptions-item>
                <el-descriptions-item>
                    <template slot="label">
                        <i class="el-icon-message"></i>邮箱 E-mail
                    </template>
                    <el-input type="text" v-model="email_"></el-input>
                </el-descriptions-item>
                <el-descriptions-item>
                    <template slot="label">
                        <i class="el-icon-mobile-phone"></i>手机号码
                    </template>
                    <el-input type="text" v-model="phonenumber_"></el-input>
                </el-descriptions-item>
                <!-- <el-descriptions-item>
                    <template slot="label">
                        <i class="el-icon-location-outline"></i>地区
                    </template>
                    {{ area }}
                </el-descriptions-item>
                <el-descriptions-item>
                    <template slot="label">
                        <i class="el-icon-office-building"></i>职业
                    </template>
                    {{ work }}
                </el-descriptions-item> -->
                <el-descriptions-item>
                    <template slot="label">
                        <i class="el-icon-magic-stick"></i>住址
                    </template>
                    <el-input type="text" v-model="address_"></el-input>
                </el-descriptions-item>
                <!-- <el-descriptions-item>
                    <template slot="label">
                        <i class="el-icon-date"></i>注册日期
                    </template>
                    {{ createdate}}
                </el-descriptions-item> -->
            </el-descriptions>
            
            
        </el-card>
    </div>
</template>

<style scoped>
    .el-descriptions{
        font-size: 18px;
    }
    .margin-top{
        padding: 180px 0px 100px 0px;
    }
</style>