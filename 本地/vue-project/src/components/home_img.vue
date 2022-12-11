<script>
    let id = 0
    import img1 from '@/assets/image/backimage1.jpg'
    import img2 from '@/assets/image/backimage2.png'
    import img3 from '@/assets/image/backimage3.jpg'
    import img4 from '@/assets/image/backimage4.png'
    export default{
        data(){
            return{
                imglist:[
                    { id: id++ , img: img1},
                    { id: id++ , img: img2},
                    { id: id++ , img: img3},
                    { id: id++ , img: img4},
                ]
            }
        },
    }
</script>

<template>
    <div class="big_box">
        <el-carousel trigger="click" height="600px" :interval="5000">
            <el-carousel-item v-for="item in imglist" :key="item.id">
                <img :src="item.img" style="object-fit: cover;width: 100%;height: 600px;">
            </el-carousel-item>
        </el-carousel>
        <div class="text">
            <h4 style="font-size: 80px;color: black;">科技改变生活</h4>
            <div style="text-align: center;font-size: 16px;color: black;">Technology changes life</div>
        </div>
    </div>
</template>

<style scoped>
    .big_box{
        margin: 0 auto;
        position: relative;
    }
    .text{
        z-index: 100;
        height: 160px;
        width: 600px;
        margin: auto;
        top: 0; left: 0; bottom: 0; right: 0;
        position: absolute;
        text-align: center;
    }
</style>