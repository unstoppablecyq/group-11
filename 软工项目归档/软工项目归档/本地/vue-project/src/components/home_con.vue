<script>
</script>

<template>
    <div>
        <div class="mod_menu">
            <div class="mod_text">
                <h4 style="font-size:25px;">网 站 简 介</h4>
            </div>
        </div>
        <div class="mod_menu_con">
            <div class="mod_menu_con_all">
                <div class="mod_menu_con_left">
                    <div class="mod_menu_con_left_text">
                        <p>现如今社会，人们生活的节奏感不断加强，很多人忽略了注意自己的健康问题</p><p><br></p>
                        <p>这是一个致力于关心并管理人们健康的网站平台。在这里，您可以与我们分享交流</p><p><br></p>
                        <p>您的身体情况，我们可以给您做出最好的建议，为您解决后顾之忧~</p><p><br></p>
                    </div>
                </div>
                <div class="mod_menu_con_right">
                    <div class="mod_menu_con_right_img1"></div>
                </div>
            </div>
        </div>
        <div class="mod_menu_con">
            <div class="mod_menu_con_all">
                <div class="mod_menu_con_right">
                    <div class="mod_menu_con_right_img2"></div>
                </div>
                <div class="mod_menu_con_left">
                    <div class="mod_menu_con_left_text">
                        <p>核酸预约、视力检测矫正、测量血压、药物购买••••••</p><p><br></p>
                        <p>我们为您提供了便利的途径，并会累积存档，综合分析出近阶段您的身体状况</p><p><br></p>
                    </div>
                </div>
            </div>
        </div>
        <div class="mod_menu_con">
            <div class="mod_menu_con_all">
                <div class="mod_menu_con_left">
                    <div class="mod_menu_con_left_text">
                        <p>对于老人、儿童、妇女，我们会提供更加全方位的健康关心。</p><p><br></p>
                        <p>… …</p><p><br></p>
                        <p>我们正在更积极地改进并完善各类功能 ！</p><p><br></p>
                    </div>
                </div>
                <div class="mod_menu_con_right">
                    <div class="mod_menu_con_right_img3"></div>
                </div>
            </div>
        </div>
    </div>
</template>

<style scoped>
.mod_menu{
    max-width: 100%;
    height: 50px;
    position: relative;
    margin: 0 auto;
    text-align: center;
    line-height: 50px;
    /*background: -webkit-linear-gradient(top,white,skyblue);*/
    
}
.mod_text{
    margin: auto;
    position: absolute;
    top: 0; left: 0; bottom: 0; right: 0;
    width: 800px;
    border-bottom: 1px solid #ccc;
}
.menu_filter{
    width: 400px;
    height: 100px;
    margin: auto;
    position: absolute;
    top: 0; left: 0; bottom: 0; right: 0;
    background-color: black;
}
.mod_menu_con{
    max-width: 100%;
    height: 400px;
    position: relative;
    text-align: center;
    margin: 0 auto;
}
.mod_menu_con_all{
    display: flex;
    align-items: center;
    justify-content: space-between;
    height: 400px;
    margin: 0;
    position: relative;
    padding: 0 0.8rem;
}
.mod_menu_con_left{
    float: left;
    width: 650px;
    height: 400px;
    text-align: center;
    position: relative;
    margin: 0 auto;
}
.mod_menu_con_left_text{
    width: 650px;
    height: 150px;
    margin: auto;
    position: absolute;
    top: 0; left: 0; bottom: 0; right: 0;
    text-align: center;
}
.mod_menu_con_right{
    float: left;
    width: 650px;
    height: 400px;
    position: relative;
    margin: 0 auto;
}
.mod_menu_con_right_img1{
    width: 300px;
    height: 300px;
    margin: auto;
    position: absolute;
    top: 0; left: 0; bottom: 0; right: 0;
    background-size: cover;
    background-image: url("../assets/image/index_con1.png");
}
.mod_menu_con_right_img2{
    width: 300px;
    height: 300px;
    margin: auto;
    position: absolute;
    top: 0; left: 0; bottom: 0; right: 0;
    background-size: cover;
    background-image: url("../assets/image/index_con2.png");
}
.mod_menu_con_right_img3{
    width: 300px;
    height: 300px;
    margin: auto;
    position: absolute;
    top: 0; left: 0; bottom: 0; right: 0;
    background-size: cover;
    background-image: url("../assets/image/index_con3.png");
}
</style>