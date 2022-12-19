<script>
	import all_header from '@/components/all_header.vue'

    export default{
        components: {
            all_header,
        },
    }
</script>

<template>
	<div>
		<all_header></all_header>
		<div class="all_header_fill"></div>
		<router-view></router-view>
	</div>
</template>

<style>
	.all_header_fill{
        max-width: 100%;
        height: 100px;
        background-color: fff;
    }
</style>
