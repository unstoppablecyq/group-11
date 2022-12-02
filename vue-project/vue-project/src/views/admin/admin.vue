<template>
    <el-container class="total">
        <el-aside style="width: 400px;height: 800px;background-color: #545c64;">
            <div style="width: 400px;height: 200px;text-align: center;line-height: 200px;">
                <p style="font-size: 40px;color: #fff;">医•屋后台管理系统</p>
            </div>
            <el-menu
                background-color="#545c64"
                text-color="#fff"
                active-text-color="#ffd04b"
                default-active="1"
                >
                <el-submenu index="1">
                    <template slot="title">
                        <span>审核处理</span>
                    </template>
                    <el-menu-item-group>
                        <el-menu-item index="1-1" @click="GOacid_do()">核酸预约审核处理</el-menu-item>
                        <el-menu-item index="1-2" @click="GOacheckbody_do()">体检订单处理</el-menu-item>
                    </el-menu-item-group>
                </el-submenu>
            </el-menu>
        </el-aside>
        
        <el-container>
            <el-main>
                <router-view></router-view>
            </el-main>
        </el-container>
    </el-container>
</template>

<script>
    export default{
        data(){
            return{

            }
        },
        methods:{
            GOacid_do(){
                this.$router.push('/admin/acid_process')
            },
            GOacheckbody_do(){
                this.$router.push('/admin/checkbody_process')
            }
        },
    }
</script>

<style scoped>
    .total{
        max-width: 100%;
        height: 800px;
        /* //background-color: #ddd; */
    }
</style>