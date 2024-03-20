function join() {
    const form = document.form;

    fetch('/api/join', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({
            userId: form.userId.value,
            userPassword: form.userPassword.value,
            userPasswordCheck: form.userPasswordCheck.value,
        }),
    })
        .then((response) => {
            if (!response.ok) {
                throw new Error(response.status);
            }
            return response.json();
        })
        .then(data => {
            alert("회원가입에 성공하였습니다..");
        })
        .catch(error => {
            console.log(error);
            alert(error.message);
        });
}