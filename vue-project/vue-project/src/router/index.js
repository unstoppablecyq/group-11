import Vue from 'vue'
import Router from 'vue-router'
import home from '@/views/home/home.vue'
import {Message} from 'element-ui'


import axios from 'axios'
import VueAxios from 'vue-axios'

Vue.prototype.$message = Message
Vue.use(VueAxios, axios)
Vue.use(Router)
const router = new Router({
    mode: 'history',
    routes: [
        {
            path: '/',
            redirect: '/home'
        },
		{
			path: '/home',
            name: 'home',
			component: home,
		},
		{
            path: '/login_user',
            name: 'login_user',
            component:() => import("@/views/login/login_user.vue")
        },
        {
            path: '/login_admin',
            name: 'login_admin',
            component:() => import("@/views/login/login_admin.vue")
        },
        {
            path: '/login_select',
            name: 'login_select',
            component:() => import("@/views/login/login_select.vue")
        },
        {
            path: '/login_changepass',
            name: 'login_changepass',
            component:() => import("@/views/login/login_changepass.vue")
        },
        {
            path: '/login_token_error',
            name: 'login_token_error',
            component:() => import("@/views/login/login_token_error.vue")
        },
        {
            path: '/user_space',
            name: 'user_space',
            component:() => import("@/views/space/user_space.vue"),
            children: [
                {
                    path: "user_spaceinfo",
                    name: "user_spaceinfo",
                    component:() => import("@/components/user_spaceinfo.vue"),
                },
                {
                    path: "user_changepic",
                    name: "user_changepic",
                    component:() => import("@/components/user_changepic.vue"),
                },
                {
                    path: "user_changeinfo",
                    name: "user_changeinfo",
                    component:() => import("@/components/user_changeinfo.vue"),
                },
                {
                    path: "user_changepic_select",
                    name: "user_changepic_select",
                    component:() => import("@/components/user_changepic_select.vue"),
                },
                {
                    path: "user_orderinfo",
                    name: "user_orderinfo",
                    component:() => import("@/views/space/user_orderinfo.vue"),
                },
            ],
            beforeEnter: (to , from , next ) => {
                let gologin = JSON.parse(window.localStorage.getItem('access_info'))
                if(!gologin) {
                    Message({
                        message: "请先登录",
                        type: 'error'
                    })
                    next('/login_user')
                }else{
                    //校验token合法性
                    //console.log(gologin)
                    axios({
                        url: 'http://localhost:5011/api/checkToken',
                        method: 'get',
                        headers: {
                            token: gologin.token
                        }
                    }).then((resp) => {
                        //console.log(resp)
                        if(!resp.data){
                            console.log("校验失败")
                            next('/login_token_error')
                        }
                    })
                }
                next()
            }
        },
        {
            path: "/all_function",
            name: "all_funtion",
            component:() => import("@/views/function/all_function.vue"),
        },
        {
            path: "/admin",
            name: "admin",
            component:() => import("@/views/admin/admin.vue"),
            children: [
                {
                    path: "acid_process",
                    name: "acid_process",
                    component:() => import("@/views/admin/acid_process.vue"),
                },
                {
                    path: "checkbody_process",
                    name: "checkbody_process",
                    component:() => import("@/views/admin/checkbody_process.vue"),
                },
            ]
        },
        {
            path: "/acid",
            name: "acid",
            component:() => import("@/views/function/acid.vue"),
            beforeEnter: (to , from , next ) => {
                let gologin = JSON.parse(window.localStorage.getItem('access_info'))
                if(!gologin) {
                    Message({
                        message: "请先登录",
                        type: 'error'
                    })
                    next('/login_user')
                }else{
                    //校验token合法性
                    //console.log(gologin)
                    axios({
                        url: 'http://localhost:5011/api/checkToken',
                        method: 'get',
                        headers: {
                            token: gologin.token
                        }
                    }).then((resp) => {
                        //console.log(resp)
                        if(!resp.data){
                            console.log("校验失败")
                            next('/login_token_error')
                        }
                    })
                }
                next()
            }
        },
        {
            path: "/checkbody",
            name: "checkbody",
            component:() => import("@/views/function/checkbody.vue"),
            beforeEnter: (to , from , next ) => {
                let gologin = JSON.parse(window.localStorage.getItem('access_info'))
                if(!gologin) {
                    Message({
                        message: "请先登录",
                        type: 'error'
                    })
                    next('/login_user')
                }else{
                    //校验token合法性
                    //console.log(gologin)
                    axios({
                        url: 'http://localhost:5011/api/checkToken',
                        method: 'get',
                        headers: {
                            token: gologin.token
                        }
                    }).then((resp) => {
                        //console.log(resp)
                        if(!resp.data){
                            console.log("校验失败")
                            next('/login_token_error')
                        }
                    })
                }
                next()
            }
        },
        {
            path: "/test",
            name: "test",
            component:() => import("@/views/test.vue"),
        },
    ]
})



export default router;