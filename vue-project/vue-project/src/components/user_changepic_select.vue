<script>
    import pic_default from '@/assets/image/pic_default.jpeg'
    import pic_2 from '@/assets/image/pic_2.jpg'
    import pic_3 from '@/assets/image/pic_3.jpg'
    export default {
        inject: ['reload'],
        data(){
            return{
                pic_default,
                pic_2,
                pic_3,
                pic_bord1: '',
                pic_bord2: '',
                pic_bord3: '',
            }
        },
        methods: {
            givebord1(){
                this.pic_bord1 = 'border: solid 1px skyblue';
            },
            nobord1(){
                this.pic_bord1 = '';
            },
            givebord2(){
                this.pic_bord2 = 'border: solid 1px skyblue';
            },
            nobord2(){
                this.pic_bord2 = '';
            },
            givebord3(){
                this.pic_bord3 = 'border: solid 1px skyblue';
            },
            nobord3(){
                this.pic_bord3 = '';
            },
            tog_pic_de(){
                this.$store.state.user_access_info.image = 1
                this.axios.post('http://localhost:5011/api/saveuser',this.$store.state.user_access_info).then((resp) =>{
                    let data = resp.data;
                    if(data.success){
                        localStorage.setItem('access_info',JSON.stringify(resp.data.content));
                        this.$message({
                            message: '修改成功',
                            type: 'success'
                        });
                        this.$router.push('/user_space/user_changepic')
                        this.reload();
                    }else{
                        this.$message({
                            message: '服务器保存失败',
                            type: 'error'
                        });
                    }
                })
            },
            tog_pic2(){
                this.$store.state.user_access_info.image = 2
                this.axios.post('http://localhost:5011/api/saveuser',this.$store.state.user_access_info).then((resp) =>{
                    let data = resp.data;
                    if(data.success){
                        localStorage.setItem('access_info',JSON.stringify(resp.data.content));
                        this.$message({
                            message: '修改成功',
                            type: 'success'
                        });
                        this.$router.push('/user_space/user_changepic')
                        this.reload();
                    }else{
                        this.$message({
                            message: '服务器保存失败',
                            type: 'error'
                        });
                    }
                })
            },
            tog_pic3(){
                this.$store.state.user_access_info.image = 3
                this.axios.post('http://localhost:5011/api/saveuser',this.$store.state.user_access_info).then((resp) =>{
                    let data = resp.data;
                    if(data.success){
                        localStorage.setItem('access_info',JSON.stringify(resp.data.content));
                        this.$message({
                            message: '修改成功',
                            type: 'success'
                        });
                        this.$router.push('/user_space/user_changepic')
                        this.reload();
                    }else{
                        this.$message({
                            message: '服务器保存失败',
                            type: 'error'
                        });
                    }
                })
            },
        },
    }
</script>
<template>
    <div>
        <el-card style="height: 700px;width: 800px;margin: auto;top: 0; left: 0; bottom: 0; right: 0;position: relative;">
            <el-card class="pics">
                <div class="pic_show_all">
                    <div class="pic_show_mod">
                        <div class="pic_show" @mouseenter="givebord1" @mouseleave="nobord1" :style="pic_bord1" @click="tog_pic_de()">
                            <img :src="pic_default" class="pic">
                            <div class="con">默认</div>
                        </div>
                    </div>
                    <div class="pic_show_mod">
                        <div class="pic_show" @mouseenter="givebord2" @mouseleave="nobord2" :style="pic_bord2" @click="tog_pic2()">
                            <img :src="pic_2" class="pic">
                        </div> 
                    </div>
                    <div class="pic_show_mod">
                        <div class="pic_show" @mouseenter="givebord3" @mouseleave="nobord3" :style="pic_bord3" @click="tog_pic3()">
                            <img :src="pic_3" class="pic">
                        </div>
                    </div>
                    
                </div>
            </el-card>
        </el-card>
    </div>
</template>

<style scoped>
    .pics{
        height: 500px;
        width: 600px;
        margin: auto;
        top: 0; left: 0; bottom: 0; right: 0;
        position: absolute;
    }
    .pic_show_all{
        width: 560px;
        height: 460px;
        margin: auto;
        top: 0; left: 0; bottom: 0; right: 0;
        position: absolute;
    }
    .pic_show_mod{
        float: left;
        width: 280px;
        height: 240px;
        position: relative;
    }
    .pic_show{
        width: 200px;
        height: 200px;
        margin: auto;
        top: 0; left: 0; bottom: 0; right: 0;
        position: absolute;
        -webkit-border-radius: 20px;
		border-radius: 20px;
    }
    .pic{
        width: 180px;
        height: 180px;
        margin: auto;
        top: 0; left: 0; bottom: 0; right: 0;
        position: absolute;
        -webkit-border-radius: 20px;
		border-radius: 20px;
        object-fit: cover;
    }
    .con{
        height: 100px;
        width: 200px;
        margin: auto;
        top: 0; left: 0; bottom: 0; right: 0;
        position: absolute;
        text-align: center;
        line-height: 100px;
        font-size: 30px;
    }
</style>
