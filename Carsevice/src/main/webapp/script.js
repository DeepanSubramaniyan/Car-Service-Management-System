function validate() {
  uname = document.getElementById("name").value;
  pwd = document.getElementById("pwd").value;
  err = document.getElementById("err");
  if (uname == "deepan" && pwd == 1234) {
    err.innerText = "Login successful";
  } else {
    err.innerText = "Invalid username or password";
  }
}
