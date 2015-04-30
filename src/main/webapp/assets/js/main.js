(function($){

	function init(){

		// calling loging function
		$('#log-in').submit(function() {	   
	    login();
	    return false;
	  });

	  //calling logout function
	  $('#log-out').click(function() {
	  	logout();
	  	return false;
	  });


		checklogged();
	  
		// setting default settings
	  $('.alert').hide();
	  $('#log-in').hide();
	  $('#logged-in').hide();	

    // Popover 
		$('#registerHere input').hover(function(){
			$(this).popover('show')
		});

		// Regform Validation
		$("#registerHere").validate({
		rules:{
		user_first_name:{required:true},
		user_last_name:{required:true},
		user_email:{required:true,email: true},
		user_password:{required:true,minlength: 6},
		user_cpassword:{required:true,equalTo: "#user_password"},
		gender:"required"
		},

		messages:{
		user_first_name:"Enter your first name",
		user_last_name:"Enter your last name",
		user_email:{
		required:"Enter your email address",
		email:"Enter valid email address"},
		user_password:{
		required:"Enter your password",
		minlength:"Password must be minimum 6 characters"},
		user_cpassword:{
		required:"Enter confirm password",
		equalTo:"Password and Confirm Password must match"},
		gender:"Select Gender"
		},

		errorClass: "help-inline",
		errorElement: "span",
		highlight:function(element, errorClass, validClass)
		{
		$(element).parents('.control-group').addClass('error');
		},
		unhighlight: function(element, errorClass, validClass)
		{
		$(element).parents('.control-group').removeClass('error');
		$(element).parents('.control-group').addClass('success');
		}
		});

    $('#registerHere').submit(function() {	   
	    register();
	    return false;
	  });

	}

	// Calling the server to login a profile
	function login() {
    $.ajax({
      url: "/api/user",
			data: { email: $("#email").val(), password: $("#password").val() },
			dataType: 'text',
			type: 'POST',
			success: function (data) {
			  $("#logged-in").show();
			  $("#log-in").hide();
			  $("#password").val("");
	      $("#email").val("");
			  window.location.href = "/account.jsp";
			},
			error: function (data) {
			  if(data.status == 401) {
			  	// redirect to log in help page
			  	alert("Inncorrect Password");
			  	window.location.href = "/register.jsp"
			  }
			  if(data.status == 404) {
			  	// redirect to log in help page
			  	alert("There is no account associated to your email address.");
			  	window.location.href = "/register.jsp"
			  }
			  
			}
			});
  }

  // Registering a new user
  function register() {
    $.ajax({
      url: "/api/user/register",
			data: { firstName: $("#user_first_name").val(), lastName: $("#user_last_name").val(), email: $("#user_email").val(), password: $("#user_password").val() },
			dataType: 'text',
			type: 'POST',
			success: function (data) {
				if(data == "true") {
			    $(".alert").show();
			    window.location.href = "/account.jsp"
				}
			},
			error: function (data) {
			  alert("An error occurred. Please try again later.");
			}
			});
  }

	function checklogged() {
	  $.ajax({
	    url: "/api/user",
			dataType: 'text',
			type: 'GET',
			success: function (data) {
				  $("#logged-in").show();
				  if(window.location.pathname == "/account.jsp") {
				  	populateAccountInfo(data);
				  }
			},
			error: function (data) {
				$("#log-in").show();
				if(window.location.pathname != "/index.jsp") {
				  window.location.href = "/index.jsp";
				}

			}
		});
	}

	function logout() {
		$.ajax({
	    url: "/api/user/logout",
			dataType: 'text',
			type: 'GET',
			success: function (data) {
				$("#logged-in").hide();
				$("#log-in").show();
				window.location.href = "/index.jsp";
			},
			error: function (data) {
				alert("An error occurred. Please try again later.");
			}
		});
	}

	function populateAccountInfo(data) {
		var user = jQuery.parseJSON(data);
		$("#user_first_name").val(user.firstName);
    $("#user_last_name").val(user.lastName);
    $("#user_email").val(user.email);
	}

	// Document Ready
	$(init);

})(jQuery);

