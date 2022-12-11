<script>
</script>

<template>
    <div class="mod_login">
        <div class="log_con">
            <div class="log_con_left">
                <div class="log_con_left_top">
                    <div class="log_con_left_top_img"></div>
                </div>
                <div class="log_con_left_bot">
                    <div class="log_con_left_bot_text">
                        <router-link to="/login_admin" style="font-size:30px;color: white;">我是管理员</router-link>
                    </div>
                </div>
            </div>
            <div class="log_con_right">
                <div class="log_con_left_top">
                    <div class="log_con_right_top_img"></div>
                </div>
                <div class="log_con_left_bot">
                    <div class="log_con_left_bot_text">
                        <router-link to="/login_user" style="font-size:30px;color: white;">我是用户</router-link>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<style scoped>
    .mod_login{
		max-width: 100%;
		height: 800px;
		position: relative;
		margin: 0 auto;
		/* background: linear-gradient(200deg,white,skyblue); */
	}
	.log_con{
		width: 900px;
		height: 500px;
		position: absolute;
		margin: auto;
		top: 0;left: 0;bottom: 0;right: 0;
		-webkit-border-radius: 20px;
		border-radius: 20px;
	}
	.log_con_left{
		float: left;
		width: 400px;
		height: 500px;
		box-shadow: 0 0 25px #cacac6;
		-webkit-border-radius: 20px;
		border-radius: 20px;
		opacity: 0.8;
	}
	.log_con_right{
		float: right;
		width: 400px;
		height: 500px;
		box-shadow: 0 0 25px #cacac6;
		-webkit-border-radius: 20px;
		border-radius: 20px;
		opacity: 0.8;
	}
	.log_con_left_top{
		width: 400px;
		height: 350px;
		margin: 0 auto;
		position: relative;
	}
	.log_con_left_bot{
		width: 400px;
		height: 150px;
		margin: 0 auto;
		position: relative;
	}
	.log_con_left_top_img{
		background-size: cover;
		background-image: url("../assets/image/admin.jpeg");
		width: 200px;
		height: 200px;
		position: absolute;
		margin: auto;
		top: 0;left: 0;bottom: 0;right: 0; 
		border-radius: 100px;
		-webkit-border-radius: 100px;
		-moz-border-radius: 100px;
	}
	.log_con_left_bot_text{
		text-align: center;
		line-height: 75px;
		position: absolute;
		margin: auto;
		top: 0;left: 0;bottom: 0;right: 0;
		width: 200px;
		height: 75px;
		-webkit-border-radius: 20px;
		border-radius: 20px;
		background-color: #eb8e55;
	}
	.log_con_right_top_img{
		background-size: cover;
		background-image: url("../assets/image/user.jpeg");
		width: 200px;
		height: 200px;
		position: absolute;
		margin: auto;
		top: 0;left: 0;bottom: 0;right: 0;
		border-radius: 100px;
		-webkit-border-radius: 100px;
		-moz-border-radius: 100px; 
	}
	.changecolor{
		color: black;
	}
</style>