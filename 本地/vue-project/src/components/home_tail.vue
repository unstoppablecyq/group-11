<script>

</script>

<template>
    <div>
        <div class="mod_menu">
            <div class="mod_text">
                <h4 style="font-size:25px;">关 于 我 们</h4>
            </div>
        </div>
        <div class="mod_tail">
            <p>一支有凝聚力并致力于健康的开发队伍</p>
            <router-link to="/login_select"></router-link>
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
    border-bottom: 1px solid #eee;
}
.mod_tail{
    max-width: 100%;
    height: 100px;
    text-align: center;
    line-height: 100px;
    background-color: #808080;
    font-weight: bolder;
    font-size: larger;
}
</style>