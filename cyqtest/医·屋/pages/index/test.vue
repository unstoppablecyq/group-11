<template>
	<view class="content">
		<button @click="testclientdb()">请求数据库</button>
		<text></text>
	</view>

</template>

<script>
	export default {
		data() {
			return {
				
			}
		},
		methods: {
			testclientdb() {
				const db = uniCloud.database();
				db.collection("User_Patient").get().then((res) => {
					// res->查询结果
					console.log(res)
				}).catch((e) => {
					console.log(e)
				});
			}
		}
	}
</script>

<style>

</style>


