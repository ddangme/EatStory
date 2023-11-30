function previewImage() {
    var input = document.getElementById('mainPhoto');
    var preview = document.getElementById('mainPhotoPreview');

    if (input.files && input.files[0]) {
        var reader = new FileReader();

        reader.onload = function (e) {
            preview.src = e.target.result;
    };

    reader.readAsDataURL(input.files[0]);
    } else {
        preview.src = '/img/main-photo-preview.png';
    }
}