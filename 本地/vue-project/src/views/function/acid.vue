<template>
    <div class="total">
        <div style="height: 800px;width: 1200px;margin: auto;top: 0; left: 0; bottom: 0; right: 0;position: absolute;">
            <el-container style="height: 800px;border: 1px solid #eee;">
                <div style="height: 600px;width: 800px;margin: auto;top: 0; left: 0; bottom: 0; right: 0;position: absolute;">

                
                    <el-form :model="acidform" ref="acidform" label-width="160px" :rules="rules">
                        <el-form-item label="选择医院" prop="hospital">
                            <el-select v-model="acidform.hospital" placeholder="请选择医院" @change="select_hos">
                                <el-option 
                                    v-for="item in hospitallist"
                                    :key="item.value"
                                    :label="item.label"
                                    :value="{ value: item.value, label: item.label}"
                                ></el-option>
                            </el-select>
                        </el-form-item>
                        <el-form-item label="选择核酸时间" prop="timer">
                            <el-date-picker 
                                type="datetime" 
                                value-format="yyyy-MM-dd HH:mm:ss"
                                placeholder="选择日期" 
                                v-model="acidform.timer" 
                                style="width: 100%;"
                            ></el-date-picker>
                        </el-form-item>
                        <el-form-item label="消息提醒">
                            <el-switch v-model="acidform.delivery"></el-switch>
                            <p style="opacity: 0.5;">开启消息提醒后,系统会在预约成功后第一时间在个人中心中提醒您</p>
                        </el-form-item>
                        <el-form-item label="健康码是否为绿码">
                            <el-radio-group v-model="acidform.healthcode">
                                <el-radio label="是"></el-radio>
                                <el-radio label="否"></el-radio>
                            </el-radio-group>
                        </el-form-item>
                        <el-form-item label="附加备注">
                            <el-input type="textarea" v-model="acidform.text"></el-input>
                        </el-form-item>
                        <el-form-item style="text-align: center;">
                            <el-button type="primary" @click="onSubmit()">预约！</el-button>
                        </el-form-item>
                    </el-form>
                </div>
            </el-container>
        </div>
    </div>
</template>

<script>
    let hos_id = 0 ;
    export default {
        data() {
            return {
                acidform: {
                    username: this.$store.state.user_access_info.username ,
                    hospital: '',
                    hospital_id: '',
                    timer: '',
                    delivery: true,
                    healthcode: '是',
                    text: ''
                },
                hospitallist: [
                    { value: hos_id++ , label: '上海市力泉医院' },
                    { value: hos_id++ , label: '上海市奉贤区中心医院' },
                ],
                rules: {
                    hospital: [
                        { required: true, message: '不能为空', trigger:'change' },
                    ],
                    timer: [
                        { required: true, message: '请选择日期', trigger: 'blur'}
                    ],
                }
            }
        },
        methods: {
            onSubmit() {
                this.$refs.acidform.validate((valid) => {
                    if(valid){
                        this.axios.post('http://localhost:5011/api/acid',this.acidform).then((resp) =>{
                            //console.log(resp);
                            let data = resp.data;
                            //console.log(data);
                            if(data.success){
                                this.$message({
                                    message: '预约成功！',
                                    type: 'success'
                                });
                                this.$router.push('/all_function')
                            }else{
                                this.$message({
                                    message: data.message,
                                    type: 'error'
                                });
                            }
                        })
                    }else{
                        this.$message({
                            message: '请完善预约信息',
                            type: 'error'
                        });
                    }
                })
                
            },
            select_hos(data) {
                const {value, label} = data
                this.acidform.hospital = label
                this.acidform.hospital_id = value
            },
        }
    }
</script>

<style scoped>
    .total{
        max-width: 100%;
        height: 800px;
        margin: 0 auto;
        position: relative;
        /* background: linear-gradient(200deg,white,skyblue); */
        /* //background-color: #ddd; */
    }
</style>