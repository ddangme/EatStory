function login() {
    const form = document.form;

    fetch('/api/login', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({
            userId: form.userId.value,
            userPassword: form.userPassword.value,
        }),
    })
        .then((response) => {
            if (!response.ok) {
                throw new Error(response.status);
            }
            return response.json();
        })
        .then(data => {
            localStorage.setItem('token', data.result.token);
            alert("로그인되었습니다.");
        })
        .catch(error => {
            console.log(error);
            alert('error.message');
        });
}