<template>
    <div class="total">
        <div style="height: 800px;width: 1200px;margin: auto;top: 0; left: 0; bottom: 0; right: 0;position: absolute;">
            <el-container style="height: 800px; border: 1px solid #eee;">
                <el-table
                    :data="tableData"
                    style="width: 100%"
                    :header-cell-style="{textAlign: 'center'}"
                    :cell-style="{textAlign: 'center'}"
                    >
                    <el-table-column
                        prop="time"
                        label="时间"
                        width="220px">
                    </el-table-column>
                    <el-table-column
                        prop="version"
                        label="版本号"
                        width="220px">
                    </el-table-column>
                    <el-table-column
                        prop="msg"
                        label="版本改动信息">
                    </el-table-column>
                </el-table>
            </el-container>
        </div>
    </div>
</template>

<script>
    export default {
        data(){
            return {
                tableData: [
                    {
                        time: '2022/11/28' ,
                        version: '0.1.0' ,
                        msg: '网站首次上线。基本功能全部完善。'
                    },
                    {
                        time: '2022/12/01' ,
                        version: '0.1.1' ,
                        msg: '修复了用户中心预约信息刷新不出来、管理员界面刷新不了用户核酸和体检的订单信息等bug。'
                    },
                ]
            }
        }
    }
</script>

<style scoped>
    .total{
        max-width: 100%;
        height: 800px;
        margin: 0 auto;
        position: relative;
        /* //background-color: #ddd; */
    }
</style>