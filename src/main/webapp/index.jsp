<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
      <!DOCTYPE html>
      <html>

      <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Index Page</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.15.0/jquery.validate.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="thestyles.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
      </head>

      <body>
        <div id="container">

          <!-- Login Container -->
          <div align="center" id="loginBox">
            <form action='Login' method="post" id="userform">
              <fieldset style="margin:auto; text-align:center">
                <legend class="legend-bold">Login</legend>
                <div>
                  <label>Username:</label>
                  <input class="theinput" type="text" placeholder="Enter email" name="email" required />
                </div>
                <div>
                  <label>Password:</label>
                  <input class="theinput" type="password" placeholder="Enter password" name="psword" required />
                </div>
                <br>
                <input class="submit" type="submit" value="Login" /> Or <a href="#registerModal" id="registerLink">Register </a>
              </fieldset>

            </form>
              <!--<a href="Login?action=listUsers"> Admin page</a>-->
          </div>
          </div>

          <script>
            $(document).ready(function () {
              //JQuery confirms password is equal to confirm password field
              $("#regform").validate({
                rules: {
                  cfmpsword:
                  {
                    equalTo: "#psword"
                  }
                }
              });
            });
          </script>
        </div>
        <!-- page Footer -->
        <!--<div id="footer"></div>-->
      </body>

      </html>