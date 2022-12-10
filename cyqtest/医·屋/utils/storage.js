// 保存用户
export function saveUser(obj){
	uni.setStorageSync('storage_user', obj);
}
// 获取用户
export function getUser(callback){
	return uni.getStorageSync('storage_user')
}

// 保存消息列表
export function saveMessagelatest(obj){
	uni.setStorageSync('storage_messagelatest', obj);
}
// 获取消息列表
export function getMessagelatest(callback){
	return uni.getStorageSync('storage_messagelatest')
}
export function clear(){
	uni.removeStorageSync("storage_user");
  uni.removeStorageSync("storage_messagelatest");
}

