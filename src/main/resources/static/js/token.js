const token = searchParam('token')

if (token) {
    localStorage.setItem("access_token", token);
    window.location.href="/";
} else {
}

function searchParam(key) {
    return new URLSearchParams(location.search).get(key);
}
