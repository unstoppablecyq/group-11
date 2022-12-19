<template>
    
</template>

<script>
    export default {
        name: "login_token_error",
        created(){
            this.$alert('登录信息失效','提示',{
                confirmButtonText: '确定'
            }).then((resp) => {
                localStorage.removeItem('access_info')
                location.replace('/login_user')
            })
        }
    }
</script>

<style scoped>

</style>