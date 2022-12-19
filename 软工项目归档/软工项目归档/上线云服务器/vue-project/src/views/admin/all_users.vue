<template>
    <div style="text-align: center;">
        <div style="width: 100%;height: 40px;text-align: center;line-height: 20px;border-bottom: 1px solid #eee;">
            <p>所有用户</p>
        </div>
        <el-table
            :data="tableData"
            style="width: 100%"
            :header-cell-style="{textAlign: 'center'}"
            :cell-style="{textAlign: 'center'}"
            >
            <el-table-column
                prop="username"
                label="账号">
            </el-table-column>
            <el-table-column
                prop="nickname"
                label="昵称">
            </el-table-column>
            <el-table-column
                prop="checkpass"
                label="密码">
            </el-table-column>
        </el-table>
        <el-button type="primary" size="middle" @click="getnewdata()">
            查询
        </el-button>
    </div>
</template>

<script>
    export default{
        data(){
            return{
                tableData: [],
            }
        },
        methods:{
            getnewdata(){
                this.axios.post('http://47.113.189.48:5011/api/getnewusers').then((resp) =>{
                    
                    let data = resp.data;
                    this.tableData = data;
                    //拿到acid数据放在localStorage里面
            
                    //console.log(this.$store.state.user_acid_info);
                })
            }
        }
    }
</script>

<style scoped>

</style>