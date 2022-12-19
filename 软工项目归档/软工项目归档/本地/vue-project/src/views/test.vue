<template>
    <div class="hello">
      <input placeholder="账号" v-model="registerform.username">
      <input placeholder="密码" v-model="registerform.password">
      <button @click="register()">register</button>
      <p>{{registerform.username}}</p>
      <p>{{registerform.password}}</p>
    </div>
  </template>
  
<script>
    export default{
        data () {
            return {
                registerform: {
                username: '',
                password: ''
                }
            }
        },
        methods: {
            register(){
                this.axios.post("http://localhost:5011/api/registerr",this.registerform).then((resp) => {
                    if(resp){
                        alert('ok');
                    }else{
                        alert('no');
                    }
                })
            }
        }
    }

</script>
  
  <!-- Add "scoped" attribute to limit CSS to this component only -->
  <style scoped>
  
  </style>
  