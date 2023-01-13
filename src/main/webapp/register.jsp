<%-- Document : register Created on : Jan 13, 2023, 4:18:05 PM Author : vungoctrung --%>

  <%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>JSP Page</title>
</head>

<body>
  <h1>Register</h1>


  <!-- Modal body-->
  <div class="modal-body" style="padding:30px 40px;">
    <!-- Register Form -->
    <form action='Register' method="post" id="regform">
      <fieldset style="margin:auto; text-align:center">
        <div>
          <label for="usnm">Username</label>
          <input class="theinput" type="text" name="username" id="usnm" placeholder="Enter Username" required />
        </div>
        <div>
          <label for="eml">Email</label>
          <input class="theinput" type="text" name="email" id="eml" placeholder="Enter Email" required />
        </div>
        <div>
          <label for="psword">Password</label>
          <input class="theinput" type="password" id="psword" name="psword" placeholder="Enter Password" required />
        </div>
        <div>
          <label for="cfmpsword">Confirm Password</label>
          <input class="theinput" type="password" id="cfmpsword" name="cfmpsword" placeholder="Confirm Password"
            required />
        </div>
        <br>
        <input class="submit" type="submit" value="Register" />
      </fieldset>
    </form>
  </div>
  <!-- Modal footer-->
  <div class="modal-footer">
    <button type="submit" class="btn btn-danger btn-default pull-left" data-dismiss="modal"><span
        class="glyphicon glyphicon-remove"></span> Cancel</button>
  </div>
</body>

</html>