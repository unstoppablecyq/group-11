<script>
    //import home_header from '@/components/home_header.vue'
    import home_img from '@/components/home_img.vue'
    import home_con from '@/components/home_con.vue'
    import home_tail from '@/components/home_tail.vue'
    export default{
        components: {
            home_img,
            home_con,
            home_tail,
        }
    }
</script>

<template>
    <div>
        <home_img />
        <home_con />
        <home_tail />
    </div>
    
</template>

<style scoped>
    
</style>
