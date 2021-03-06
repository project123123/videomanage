<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- saved from url=(0044)http://localhost:8080/Voids/user/password.do -->
<html><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <!-- base href="http://localhost:8080/video/" -->
    <meta name="viewport" content="initial-scale=1, maximum-scale=1, user-scalable=no">
    
        
<!--<base href="http://localhost:8080/Voids/">--><base href=".">
    <meta name="renderer" content="webkit">
    <meta name="keywords" content="Web前端视频教程,大数据视频教程,HTML5视频教程,UI视频教程,PHP视频教程,java视频教程,python基础教程">
    <meta name="description" content="智游教育在线课程视频,为您提供java,python,HTML5,UI,PHP,大数据等学科经典视频教程在线浏览学习,精细化知识点解析,深入浅出,想学不会都难,智游教育,学习成就梦想！">
    <link rel="stylesheet" href="z/base.css">
    <link rel="stylesheet" href="z/profile.css">
    <link rel="icon" href="http://localhost:8080/Voids/static/z/favicon.png" type="image/png">
    <title>在线公开课-智游教育|java|大数据|HTML5|python|UI|PHP视频教程</title>

</head>
<body class="w100">
  
<header>
	<div class="container top_bar clearfix">
		<img src="z/logo.png"  alt="智游">
		<div id="tele">
			<span>4006-371-555</span>
			<span>0371-88888598</span>
		</div>
	</div>
	<menu>
		<div class="container clearfix">
			<ul class="clearfix f_left">
				<li><a href="show">首页</a></li>
				
				<li class="menu_active"><a href="updateDataCenter?service=0">个人中心</a></li>
			</ul>
			
			<div id="user_bar">
				<a>	
					<img id="avatar" src="z/avatar_lg.png" alt="">
				</a>
				<a href="exitUser">退出</a>
			</div>
		</div>
	</menu>
</header>

   <main>
        <div class="container">
            <h2>我的资料</h2>
            <div id="profile_tab">
                <ul class="profile_tab_header f_left clearfix">
	                <li><a href="updateDataCenter?service=1">更改资料</a></li>
					<li class="profile_tab_line">|</li>
					<li><a href="updateDataCenter?service=2">更改头像</a></li>
					<li class="profile_tab_line">|</li>
					<li><a href="updateDataCenter?service=3">密码安全</a></li>
                </ul>
                <div class="proflle_tab_body">
                    <div class="proflle_tab_workplace clearfix">
                        <div class="profile_avatar_area">
		                     <img id="avatar" width="200px;" src="${user.imgurl}" alt="">
                        </div>
                        <div class="profile_ifo_area">
                            <form id="passWordForm" action="saveData" method="post">
                            	<input name="id" value="${user.id}" type="hidden">
                                <div class="form_group">
                                    <span class="dd">旧　密　码：</span>
                                    <input  type="password" id="oldMsg1"> <span id="oldMsg"></span>
                                </div>
                                <div class="form_group">
                                    <span class="dd" >新　密　码：</span>
                                    <input id="regPsw" type="password">
                                </div>
                                <div class="form_group">
                                    <span class="dd" >确认新密码：</span>
                                    <input  id="regPswAgain"  name="password" type="password"><span id="passMsg"></span>
                                </div>
                                <div class="form_submit dd">
                                	<input type="hidden" value="${user.password}" id="password">
                                	
                                    <input onclick="return commitPassWord()" value="保　存" type="submit" >
                                    <a >取消</a>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </main>
    


<footer>
	<div class="container">
		<ul>
			<li><img src="z/footer_logo.png"  alt="" id="foot_logo" ></li>
			<li>版权所有：智游3G教育　　　©&nbsp;www.zhiyou100.com</li>
			<li><img src="z/a.png"  alt="" id="wxgzh"></li>
		</ul>
	</div>
</footer>

<script src="z/bootstrap/js/jquery.js"></script>
<script src="js/index.js"></script>
<script type="text/javascript">

var regIsCommitPswOld=false;
$("#oldMsg1").blur(function(){
	var oldpassword = $("#oldMsg1").val();
	if(oldpassword!=""&&oldpassword!=null){
		$.post("verifyPassWord",{password:oldpassword},function(data){
			if(data!=""){
				regIsCommitPswOld=true;
				$("#oldMsg").html("<span style='color:red '>✔</span>");
			}else{
				regIsCommitPswOld=false;
				$("#oldMsg").html("<span style='color:red '>原密码错误</span>");
			}
		})
	}else{
		regIsCommitPswOld=false;
		$("#oldMsg").html("<span style='color:red '>原密码错误</span>");
	}
	
})

function commitPassWord(){
	
	if(regIsCommitPsw&&regIsCommitPswOld){

	return true;
	}
	  return false;
}
</script>
 
</body></html>