<script>
    export default{
        data(){
            return {

                
            }
        },
    }
</script>

<template>
    <div>
        <el-card style="height: 700px;width: 800px;margin: auto;top: 0; left: 0; bottom: 0; right: 0;">
            <el-descriptions class="margin-top" title="个人信息" :column="2" >
                <el-descriptions-item>
                    <template slot="label">
                        <i class="el-icon-user"></i>用户名
                    </template>
                    {{ $store.state.user_access_info.nickname }}
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
                    {{ $store.state.user_access_info.age }}
                </el-descriptions-item>
                <el-descriptions-item>
                    <template slot="label">
                        <i class="el-icon-male"></i>
                        <i class="el-icon-female"></i>性别
                    </template>
                    <el-tag size="small">{{ $store.state.user_access_info.sex == 1 ? '男' : '女' }}</el-tag>
                </el-descriptions-item>
                <el-descriptions-item>
                    <template slot="label">
                        <i class="el-icon-message"></i>邮箱 E-mail
                    </template>
                    {{ $store.state.user_access_info.email }}
                </el-descriptions-item>
                <el-descriptions-item>
                    <template slot="label">
                        <i class="el-icon-mobile-phone"></i>手机号码
                    </template>
                    {{ $store.state.user_access_info.phonenumber }}
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
                    {{ $store.state.user_access_info.address }}
                </el-descriptions-item>
                <!-- <el-descriptions-item>
                    <template slot="label">
                        <i class="el-icon-date"></i>注册日期
                    </template>
                    {{ createdate}} -->
                <!-- </el-descriptions-item> -->
            </el-descriptions>
            
            
        </el-card>
    </div>
</template>

<style scoped>
    .el-descriptions{
        font-size: 18px;
    }
    .margin-top{
        padding: 200px 0px 100px 30px;
    }
</style>