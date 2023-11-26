$(document).ready(function() {
    if (localStorage.getItem("access_token") !== null) {
        $("#login-area").hide();
    } else {
        $("#logout-area").hide();
    }
});

$("#logout-button").click(function() {
    if (localStorage.getItem("access_token") != null) {
        localStorage.removeItem("access_token");
        location.href = "/logout";
    }
});