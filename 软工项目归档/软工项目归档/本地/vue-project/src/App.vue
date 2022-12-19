<script>
    import all_header from '@/components/all_header.vue'
    export default{
        components: {
            all_header,
        },
        //让路由强制刷新 --start
        data () {
            return {
                // 控制router-view的隐藏与展示
                isShow: true,
            }
        },
        // 提供可注入子组件属性
        provide () {
            return {
                reload: this.reload ,
            }
        },
        // 定义reload方法
        methods: {
            reload () {
                // 先隐藏
                this.isShow = false
                // $nextTick() 将回调延迟到下次 DOM 更新循环之后执行
                this.$nextTick(() => {
                    this.isShow = true
                })
            },
        },
    }
</script>

<template>
	<div id="app">
        <all_header></all_header>
		<div class="all_header_fill"></div>
		<router-view v-if="isShow"></router-view>
	</div>
</template>

<style>
    .all_header_fill{
        max-width: 100%;
        height: 100px;
        background-color: fff;
    }
</style>
