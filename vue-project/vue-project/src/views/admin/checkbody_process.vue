<template>
    <div style="text-align: center;">
        <div style="width: 100%;height: 40px;text-align: center;line-height: 20px;border-bottom: 1px solid #eee;">
            <p>体检订单审核处理</p>
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
                prop="checkbody_id"
                label="套餐">
            </el-table-column>
            <el-table-column
                prop="iseyes"
                label="是否测视力">
            </el-table-column>
            <el-table-column
                prop="istooth"
                label="是否检查牙齿">
            </el-table-column>
            <el-table-column
                prop="address"
                label="地址">
            </el-table-column>
            <el-table-column label="操作">
                <template slot-scope="scope">
                    <el-button
                        type="success"
                        size="middle"
                        @click="Yes(scope.row)"
                    >允许</el-button>
                    <el-button
                        type="danger"
                        size="middle"
                        @click="No(scope.row)"
                    >不允许</el-button>
                </template>
            </el-table-column> -->
        </el-table>
        <el-button type="primary" size="middle" @click="getnewdata()">
            刷新
        </el-button>
    </div>
</template>

<script>
    export default{
        data() {
            return {
                tableData: this.$store.state.user_checkbody_info ,
                checkbodymsg: {
                    username: '' ,
                    msg: '',
                }
            }
        },
        methods:{
            getnewdata(){
                window.localStorage.removeItem('checkbody_info');
                this.axios.post('http://localhost:5011/api/getnewcheckbody').then((resp) =>{
                    
                    let data = resp.data;
                    console.log(data);
                    //拿到acid数据放在localStorage里面
                    localStorage.setItem('checkbody_info',JSON.stringify(data));
            
                    //console.log(this.$store.state.user_acid_info);
                })
                location.replace('/admin/checkbody_process');
            },
            Yes(data){
                this.checkbodymsg.msg = '您的上门体检预约成功！' ;
                this.checkbodymsg.username = data.username ;
                this.axios.post('http://localhost:5011/api/addusermsg',this.checkbodymsg).then((resp) =>{
                    
                    if(resp){
                        this.No(data);
                    }else{
                        this.$message({
                            message: '服务器错误',
                            type: 'error'
                        })
                    }
                })
            },
            No(data){
                console.log(data)
                this.axios.post('http://localhost:5011/api/deletecheckbody',data).then((resp) =>{
                    
                    if(resp){
                        this.$message({
                            message: '成功',
                            type: 'success'
                        })
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