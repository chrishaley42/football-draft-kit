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
      log in failed please try again, <a href="register.jsp">register</a>, or <a href="register.jsp">rest password</a>.
     </div>
        <footer>
        <p>&copy; 2013 jcbgroup</p>
      </footer>
    </div> <!-- /container -->
  </body>
</html>