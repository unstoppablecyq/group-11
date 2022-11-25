
let prefix;
console.log('NODE_ENV2222========',process.env.NODE_ENV)
if (process.env.NODE_ENV === 'development') {
  // #ifdef APP-PLUS
    prefix = 'http://192.168.0.115:8100/tongxiang';
  // #endif
  // #ifdef H5
    prefix = '/tongxiang';
  // #endif
}else{  
  prefix = 'https://www.xiaowanwu.cn/tongxiang';
}

function deal(path,params,method){
	return new Promise((resolve,reject)=>{
		uni.request({
			url: `${prefix}${path}`, 
			method: method || 'post',
			data: params,
			header: {
				"Content-Type": "application/json",
        // "token": getToken()
			},
			success: (res) => {
				console.log('res',res);
				if(res.data.meta.errno!==0){
					uni.showToast({
						title:res.data.meta.msg || "系统错误",
						icon:"none"
					})
					reject(res.data.meta);
				}else{
					resolve(res.data.result)
				}
        
        uni.hideLoading();
			},
			fail: ()=>{
				uni.showToast({
					title:"系统错误",
					icon:"none"
				})
        uni.hideLoading();
			}
		});
	})
}


// 注册
export function register(params){
	return deal('/user/register',params);
}

// export function login(params){
// 	return deal('/user/login',params);
// }
export function login(params){
	return deal('/user/loginByVCode',params);
}
