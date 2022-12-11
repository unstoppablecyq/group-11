<template>
    <div class="total">
        <div style="height: 800px;width: 1200px;margin: auto;top: 0; left: 0; bottom: 0; right: 0;position: absolute;">
            <el-container style="height: 800px;">
                <el-container class="img_box">
                    <div class="left_img" @click="acid()" id="acidbox">
                        <div class="img">
                            <img :src="acid2">
                        </div>
                        <div class="text">
                            <div>
                                <h2>核酸预约</h2>
                                <p>方便、便捷、效率的预约方式</p>
                            </div>
                        </div>
                    </div>
                    <div class="left_img" @click="checkbody()" id="checkbodybox">
                        <div class="img">
                            <img :src="acid1">
                        </div>
                        <div class="text">
                            <div>
                                <h2>上门体检</h2>
                                <p>给疲惫的身心来一次深层次的疗养</p>
                            </div>
                        </div>
                    </div>
                    <div class="left_img" @click="eyesbox()" id="eyesbox">
                        <div class="img">
                            <img :src="acid3">
                        </div>
                        <div class="text">
                            <div>
                                <h2>视力检测矫正</h2>
                                <p>敬请期待...</p>
                            </div>
                        </div>
                    </div>
                </el-container>
            </el-container>
        </div>
    </div>
</template>

<script>
    import acid1 from "@/assets/image/acid1.png"
    import acid2 from "@/assets/image/acid2.png"
    import acid3 from "@/assets/image/acid3.png"
    export default{
        data(){
            return {
                acid1,
                acid2,
                acid3,
            }
        },
        methods:{
            acid(){
                this.$router.push('/acid')
            },
            checkbody(){
                this.$router.push('/checkbody')
            },
            eyesbox(){
                //this.$router.push('/test')
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
    .img_box{
        height: 400px;
        width: 1200px;
        margin: auto;
        top: 0; left: 0; bottom: 0; right: 0;
        position: absolute;
        display: flex;
        background-color: #ddd;
        flex-wrap: wrap;
    }
    .img_box .left_img{
        width: 400px;
        height: 400px;
        position: relative;
        overflow: hidden;
        transition: 0.5s;
    }
    .img_box .left_img:hover{
        z-index: 1;
        transform: scale(1.3);
        box-shadow: 0 25px 40px rgba(0,0,0,.5);
    }
    .img_box .left_img .img{
        position: absolute;
        top: 0;
        left: 0;
        width: 100%;
        height: 100%;
    }
    .img_box .left_img .img:before{
        content: '';
        position: absolute;
        top: 0;left: 0;
        width: 100%;
        height: 100%;
        z-index: 1;
        background: linear-gradient(180deg,#fff,#000);
        mix-blend-mode: multiply;
        opacity: 0;
        transition: 0.5s;
    }
    .img_box .left_img:hover .img:before{
        opacity: 1;
    }
    .img_box .left_img .img img{
        position: absolute;
        top: 0;
        left: 0;
        width: 100%;
        height: 100%;
        object-fit: cover;
    }
    .img_box .left_img .text{
        position: absolute;
        top: 0;
        left: 0;
        width: 100%;
        height: 100%;
        z-index: 1;
        display: flex;
        align-items: flex-end;
    }
    .img_box .left_img .text h2{
        color: #fff;
        transition: 0.2s;
        text-transform: uppercase;
        margin-bottom: 5px;
        font-size: 40px;
        transform: translateY(200px);
    }
    .img_box .left_img:hover .text h2{
        transform: translateY(0);
        transition-delay: 0.3s;
    }
    .img_box .left_img .text p{
        color: #fff;
        transform: translateY(200px);
        transition: 0.2s;
        font-size: 24px;
    }
    .img_box .left_img:hover .text p{
        transform: translateY(0);
        transition-delay: 0.5s;
    }
</style>