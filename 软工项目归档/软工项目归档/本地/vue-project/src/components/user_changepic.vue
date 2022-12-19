<script>
    import pic_default from '@/assets/image/pic_default.jpeg'
    import pic_2 from '@/assets/image/pic_2.jpg'
    import pic_3 from '@/assets/image/pic_3.jpg'
    export default{
        data(){
            return{
                o_k: false,
                picc:
                    (this.$store.state.user_access_info.image == 1) ? pic_default
                    : ((this.$store.state.user_access_info.image == 2) ? pic_2 : pic_3) ,
            }
        },
        methods: {
            chan_pic1(){
                this.o_k = true ;
            },
            chan_pic2(){
                this.o_k = false ;
            },
            xiugai_pic(){
                this.$router.push('/user_space/user_changepic_select') ;
            }
        }
    }
</script>

<template>
    <div>
        <el-card style="height: 700px;width: 800px;margin: auto;top: 0; left: 0; bottom: 0; right: 0;position: relative;">
            <div class="pic_box" @mouseenter="chan_pic1" @mouseleave="chan_pic2">
                <img :src="picc" class="pic">
                <div class="pic_cover" v-show="o_k"></div>
                <div class="change" v-show="o_k" @click="xiugai_pic">
                    <img src="@/assets/image/changepic.png" style="width: 50px; height:50px;-webkit-border-radius: 100px;border-radius: 100px;">
                </div>
            </div>
        </el-card>
    </div>
</template>

<style scoped>
    .pic_box{
        width: 200px;
        height: 200px;
        margin: auto;
        top: 0; left: 0; bottom: 0; right: 0; 
        position: absolute;
        -webkit-border-radius: 100px;
		border-radius: 100px;
    }
    .pic{
        width: 200px;
        height: 200px;
        -webkit-border-radius: 100px;
		border-radius: 100px;
        object-fit: cover;
    }
    .change{
        position: absolute;
        width: 50px;
        height: 50px;
        margin: auto;
        top: 0; left: 0; bottom: 0; right: 0; 
        -webkit-border-radius: 100px;
		border-radius: 100px;
    }
    .pic_cover{
        position: absolute;
        width: 200px;
        height: 200px;
        margin: auto;
        top: 0; left: 0; bottom: 0; right: 0; 
        background-color: #808080;
        -webkit-border-radius: 100px;
		border-radius: 100px;
        opacity: 0.5;
    }
</style>