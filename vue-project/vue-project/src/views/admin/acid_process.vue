<template>
    <div style="text-align: center;">
        <div style="width: 100%;height: 40px;text-align: center;line-height: 20px;border-bottom: 1px solid #eee;">
            <p>核酸预约审核处理</p>
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
                prop="hospital"
                label="预约医院">
            </el-table-column>
            <el-table-column
                prop="timer"
                label="预约时间">
            </el-table-column>
            <el-table-column
                prop="healthcode"
                label="健康码绿码">
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
            </el-table-column>
        </el-table>
        <el-button type="primary" size="middle" @click="getnewdata()">
            刷新
        </el-button>
    </div>
</template>

<script>
    export default {
        inject: ['reload'],
        data() {
            return {
                tableData: this.$store.state.user_acid_info ,
                acidmsg: {
                    username: '' ,
                    msg: '',
                }
            }
        },
        methods: {
            //刷新localstorage
            getnewdata(){
                window.localStorage.removeItem('acid_info');
                this.axios.post('http://localhost:5011/api/getnewacid').then((resp) =>{
                    
                    let data = resp.data;
                    console.log(data);
                    //拿到acid数据放在localStorage里面
                    localStorage.setItem('acid_info',JSON.stringify(data));
            
                    //console.log(this.$store.state.user_acid_info);
                })
                location.replace('/admin/acid_process');
            },
            Yes(data){
                this.acidmsg.msg = '您的核酸预约成功！' ;
                this.acidmsg.username = data.username ;
                this.axios.post('http://localhost:5011/api/addusermsg',this.acidmsg).then((resp) =>{
                    
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
                this.axios.post('http://localhost:5011/api/delateacid',data).then((resp) =>{
                    
                    if(resp){
                        this.$message({
                            message: '成功',
                            type: 'success'
                        })
                        this.getnewdata();
                    }else{
                        this.$message({
                            message: '拒绝失败',
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