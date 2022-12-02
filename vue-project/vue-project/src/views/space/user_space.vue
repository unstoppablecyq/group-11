<script>
    import pic_default from '@/assets/image/pic_default.jpeg'
    import pic_2 from '@/assets/image/pic_2.jpg'
    import pic_3 from '@/assets/image/pic_3.jpg'
    export default {
        data() {
            return {
                user:{
                    userpic : 
                        (this.$store.state.user_access_info.image == 1) ? pic_default
                        : ((this.$store.state.user_access_info.image == 2) ? pic_2 : pic_3),
                    nickname: this.$store.state.user_access_info.nickname, 
                }
            }
        },
        methods:{
            Gospaceinfo(){
                this.$router.push('/user_space/user_spaceinfo') 
            },
            Gochangepic(){
                this.$router.push('/user_space/user_changepic') 
            },
            Gochangeinfo(){
                this.$router.push('/user_space/user_changeinfo') 
            },

            Goorderinfo(){
                this.$router.push('/user_space/user_orderinfo')
            }
        }
    }
</script>

<template>
    <div class="total">
        <div style="height: 800px;width: 1200px;margin: auto;top: 0; left: 0; bottom: 0; right: 0;position: absolute;">
            <el-container style="height: 800px; border: 1px solid #eee;">
                <el-aside width="200px" style="margin-top: 1%" >
                    <div style="width: 190px;background-color: white;padding: 5px;margin: auto">
                        <img :src="user.userpic" width="150px" height="150px" style="object-fit: cover;border-radius: 300px;margin-left: 8%">
                        <br>
                        <br>
                        <p style="margin:0 auto;text-align: center">{{user.nickname}}</p>
                    </div>
                    <br>
                    <br>
                    <el-menu :default-openeds="['1','2']">
                        <el-submenu index="1">
                        <template slot="title"><i class="el-icon-menu"></i>用户中心</template>
                        <el-menu-item-group>
                            <el-menu-item index="1-1" @click.native="Gospaceinfo">个人信息</el-menu-item>
                            <el-menu-item index="1-2" @click.native="Gochangepic">修改头像</el-menu-item>
                            <el-menu-item index="1-3" @click.native="Gochangeinfo">修改信息</el-menu-item>
                        </el-menu-item-group>
                        </el-submenu>
                        <el-submenu index="2">
                        <template slot="title"><i class="el-icon-message"></i>信息中心</template>
                        <el-menu-item-group>
                            <el-menu-item index="2-1" @click.native="Goorderinfo">预约信息</el-menu-item>
                        </el-menu-item-group>
                        </el-submenu>
                    </el-menu>
                </el-aside>
                <el-container style="background-color: white">
                    <el-main>
                        <router-view></router-view>
                    </el-main>
                </el-container>
            </el-container>
        </div>
    </div>
</template>

<style scoped>
    .total{
        max-width: 100%;
        height: 800px;
        margin: 0 auto;
        position: relative;
        /* //background-color: #ddd; */
    }
    .el-header {
        background-color: #B3C0D1;
        color: #333;
        line-height: 60px;
    }

    .el-aside {
        color: #333;
    }
    .router-link {
        text-decoration: none;
        color: #fff;
    }
</style>