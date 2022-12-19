<template>
    <div class="total">
        <div style="height: 800px;width: 1200px;margin: auto;top: 0; left: 0; bottom: 0; right: 0;position: absolute;">
            <el-container style="height: 800px;border: 1px solid #eee;">
                <div style="height: 800px;width: 900px;margin: auto;top: 0; left: 0; bottom: 0; right: 0;position: absolute;">
                    <div style="height: 360px;width: 900px;">
                        <el-carousel trigger="click" height="320px" :interval="50000000" type="card" ref="carousel">
                            <el-carousel-item v-for="item in imglist" :key="item.id"  @click.native="bannerClick()"
                                style="border: 1px solid #ccc;">
                                <img :src="item.img" style="object-fit: cover;width: 100%;height: 320px;">
                            </el-carousel-item>
                        </el-carousel>
                    </div>
                    <div v-show="showtext == 0" class="infor">
                        <div style="height: 50px;width: 900px;text-align: center;line-height: 30px;font-size: 30px;">
                            定制款
                        </div>
                        <div style="height: 40px;width: 900px;text-align: center;line-height: 30px;font-size: 15px;">
                            包含身高体重、血压等常规体检，以及上门体检确认您所需要的体检选项。
                        </div>
                        <el-form label-width="180px" :model="checkbody_0_form" ref="checkbody_0_form">
                            <el-form-item label="是否测视力">
                                <el-radio-group v-model="checkbody_0_form.iseyes">
                                    <el-radio label="是"></el-radio>
                                    <el-radio label="否"></el-radio>
                                </el-radio-group>
                            </el-form-item>
                            <el-form-item label="是否检查牙齿情况">
                                <el-radio-group v-model="checkbody_0_form.istooth">
                                    <el-radio label="是"></el-radio>
                                    <el-radio label="否"></el-radio>
                                </el-radio-group>
                            </el-form-item>
                            <el-form-item label="地址是否为个人中心地址" >
                                <el-radio-group v-model="isaddress">
                                    <el-radio label="是"></el-radio>
                                    <el-radio label="否"></el-radio>
                                </el-radio-group>
                                <el-input v-model="another_address" v-show="!(isaddress == '是')" placeholder="新地址"></el-input>
                            </el-form-item>
                                
                        </el-form>
                        <div style="text-align: center;">
                            <el-button type="primary" @click="submit()">确定预约</el-button>
                        </div>
                        
                    </div>
                    <div v-show="showtext == 1" class="infor">

                    </div>
                    <div v-show="showtext == 2" class="infor">

                    </div>
                </div>
            </el-container>
        </div>
    </div>
</template>

<script>
    let id = 0
    import img1 from '@/assets/image/checkbody1.png'
    import img2 from '@/assets/image/checkbody2.png'
    import img3 from '@/assets/image/checkbody3.png'
    export default{
        data(){
            return{
                imglist:[
                    { id: id++ , img: img1 , con: '套餐一' },
                    { id: id++ , img: img2 , con: '套餐二' },
                    { id: id++ , img: img3 , con: '套餐三' },
                ],
                showtext: 0 ,

                checkbody_0_form:{ 
                    checkbody_id: '套餐一',
                    username: this.$store.state.user_access_info.username , 
                    iseyes: '是',
                    istooth: '是',
                    address: '',
                },
                isaddress: '是',
                another_address: '',
            }
        },
        methods:{
            bannerClick(){
                let index = this.$refs.carousel.activeIndex
                this.showtext = index
                console.log(index)
            },
            submit(){
                if(this.isaddress == '是'){
                    this.checkbody_0_form.address = this.$store.state.user_access_info.address;
                }else{
                    this.checkbody_0_form.address = this.another_address;
                }
                this.axios.post('http://localhost:5011/api/checkbody',this.checkbody_0_form).then((resp) =>{
                    //console.log(this.checkbody_0_form);
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
                            message: '服务器错误',
                            type: 'error'
                        });
                    }
                })
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
        /* background: linear-gradient(200deg,white,skyblue); */
        /* //background-color: #ddd; */
    }
    .infor{
        width: 900px;
        height: 200px;
    }

</style>