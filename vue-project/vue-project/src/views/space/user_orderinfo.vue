<template>
    <div style="text-align: center;">
        <el-table
            :data="tableData"
            style="width: 100%"
            :header-cell-style="{textAlign: 'center'}"
            :cell-style="{textAlign: 'center'}"
            >
            <el-table-column
                prop="msg"
                label="信息">
            </el-table-column>
            <el-table-column label="操作">
                <template slot-scope="scope">
                    <el-button
                        type="success"
                        size="middle"
                        @click="Yes(scope.row)"
                    >确定</el-button>
                </template>
            </el-table-column>
        </el-table>
        <el-button type="primary" size="middle" @click="getnewdata()">
            刷新
        </el-button>
    </div>
</template>

<script>
    export default {
        data(){
            return {
                tableData: this.$store.state.user_order_info ,
                req: {
                    username: this.$store.state.user_access_info.username ,
                }
                
            }
        },
        methods: {
            getnewdata(){
                window.localStorage.removeItem('order_info');
                this.axios.post('http://localhost:5011/api/getuserorder',this.req).then((resp) =>{
                    
                    let data = resp.data;
                    //拿到orderinfo数据放在localStorage里面
                    localStorage.setItem('order_info',JSON.stringify(data));
            
                    //console.log(this.$store.state.user_acid_info);
                })
                location.replace('/user_space/user_orderinfo');
            },
            Yes(data){
                console.log(data)
                this.axios.post('http://localhost:5011/api/deleteorderinfo',data).then((resp) =>{
                    
                    if(resp){
                        this.getnewdata();
                    }else{
                        this.$message({
                            message: '服务器错误',
                            type: 'error'
                        })
                    }
                })
            }
        }
    }
</script>

<style scoped>

</style>