<html>
  <head>
    <title>Haley Fantasy Football Draft Kit</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Bootstrap -->
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/css/main.css">
    <link rel="stylesheet" href="bootstrap/css/bootstrap-responsive.css" >

    <script src="assets/js/jquery.min.js"></script>
    <script src="assets/js/jquery.validate.min.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
    <script src="assets/js/main.js"></script>
  </head>
   <body>
    <div class="navbar navbar-inverse navbar-fixed-top">
      <div class="navbar-inner">
        <div class="container">
          <button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="brand" href="#">Haley Draft Kit</a>
          <div class="nav-collapse collapse">
            <ul class="nav">
              <li ><a href="index.jsp">Home</a></li>
              <li><a href="#about">About</a></li>
              <li><a href="#contact">Contact</a></li>
            </ul>
           <form id="log-in" class="navbar-form pull-right">
              <input id="email" name="email" class="span2" type="text" placeholder="Email">
              <input id="password" name="password" class="span2" type="password" placeholder="Password">
              <button id="log-in-submit" type="submit" class="btn">Sign in</button>
            </form>
            <ul id="logged-in" name="logged-in" class="nav pull-right">
               <li class="active"><a href="/account.jsp">My Account</a></li>
               <li><a id="log-out" name="log-out" href="#">Log Out</a></li>
            </ul>
          </div><!--/.nav-collapse -->
        </div>
      </div>
    </div>
    <div class="container">
     <div class="hero-unit">
      <div class="accordion" id="accordion2">
        <div class="accordion-group">
          <div class="accordion-heading">
            <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseOne">
              Account Info
            </a>
          </div>
          <div id="collapseOne" class="accordion-body collapse in">
            <div class="accordion-inner">
        <form class="form-horizontal" id="updateAccount" method='post' action=''>
          <fieldset>

          <div class="control-group">
            <label class="control-label">First Name</label>
            <div class="controls">
              <input type="text" class="input-xlarge" id="user_first_name" name="user_first_name">
            </div>
          </div>
          <div class="control-group">
            <label class="control-label">Last Name</label>
            <div class="controls">
              <input type="text" class="input-xlarge" id="user_last_name" name="user_last_name">
            </div>
          </div>
          <div class="control-group">
            <label class="control-label">Email</label>
            <div class="controls">
              <input type="text" class="input-xlarge" id="user_email" name="user_email" >
            </div>
          </div>
          <div class="control-group">
            <label class="control-label">Current Password</label>
            <div class="controls">
              <input type="password" class="input-xlarge" id="user_current_password" name="user_current_password">
            </div>
          </div>
          <div class="control-group">
            <label class="control-label">New Password</label>
            <div class="controls">
              <input type="password" class="input-xlarge" id="user_password" name="user_password">
            </div>
          </div>
          <div class="control-group">
            <label class="control-label">Retype Password</label>
            <div class="controls">
              <input type="password" class="input-xlarge" id="user_cpassword" name="user_cpassword">
            </div>
          </div>
          <div class="control-group">
            <label class="control-label"></label>
            <div class="controls">
              <button type="submit" class="btn btn-primary" >Create My Account</button>
            </div>
          </div>
          <div class="alert alert-success">
            Well done! You successfully read this important alert message.
          </div>
        </fieldset>
      </form>
            </div>
          </div>
        </div>
        <div class="accordion-group">
          <div class="accordion-heading">
            <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseTwo">
              Draft Kits
            </a>
          </div>
          <div id="collapseTwo" class="accordion-body collapse">
            <div class="accordion-inner">
              <table class="table">
                <tbody>
                  <tr>
                    <td>My First Kit</td>
                  </tr>
                  <tr>
                    <td>My Second Kit</td>
                  </tr>
                </tbody>
              </table>
            </div>
          </div>
        </div>
      </div>


     </div>
        <footer>
        <p>&copy; 2013 jcbgroup</p>
      </footer>
    </div> <!-- /container -->
  </body>
</html>