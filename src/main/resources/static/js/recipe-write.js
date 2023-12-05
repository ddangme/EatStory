

function addIngredientRow() {
    const parent = document.getElementById('ingredient-list');
    const newIndex = Number(parent.getElementsByClassName('card-body')[parent.getElementsByClassName('card-body').length - 1].id.slice(-1)) + 1;

    const temp = document.createElement('div');
    temp.classList.add('card');
    temp.classList.add('shadow');
    temp.classList.add('mb-4');
    temp.innerHTML = `
        <div class="card-body" id="ingredient-` + newIndex + `">
            <div class="row">
                <div class="row" id="ingredient-row-0">
                    <div class="col-lg-1">
                        <input type="button" onclick="deleteIngredient(this.parentElement)" class="btn btn-primary" value="재료/양념 묶음 삭제">
                    </div>
                    <div class="col-lg-11"></div>
                    <div class="col-lg-3">
                        <label class="col-form-label mt-4">재료 종류</label>
                        <input name="recipeIngredientWriteForms[` + newIndex + `].category" class="form-control" placeholder="예) 소스">
                    </div>
                    <div class="col-lg-4">
                        <label class="col-form-label mt-4">재료 이름</label>
                        <input name="recipeIngredientWriteForms[` + newIndex +`].ingredients[0]" class="form-control" placeholder="예) 돼지고기">
                    </div>
                    <div class="col-lg-4">
                        <label class="col-form-label mt-4">재료양</label>
                        <input name="recipeIngredientWriteForms[` + newIndex + `].amounts[0]"  class="form-control" placeholder="예) 300g">
                    </div>
                    <div class="col-lg-1">
                        <label class="col-form-label mt-4">추가/삭제</label>
                        <input type="button" onclick="addSingleIngredient(this.parentElement)" class="btn btn-primary" value="추가">
                    </div>
                    <div class="col-lg-12"><br></div>
                </div>
            </div>
        </div>
    `;

    parent.append(temp);
}


function addSingleIngredient(e) {
    var parent = e.parentElement.parentElement;
    var parentIndex = Number(parent.parentElement.id.slice(-1));
    var newIndex = Number(parent.getElementsByClassName('row')[parent.getElementsByClassName('row').length - 1].id.slice(-1)) + 1;

    const temp = document.createElement('div');
    temp.classList.add('row');
    temp.id = 'ingredient-row-' + newIndex;
    temp.innerHTML = `
        <div class="col-lg-4 offset-lg-3">
            <input name="recipeIngredientWriteForms[` + parentIndex +`].ingredients[` + newIndex + `]" class="form-control">
        </div>
        <div class="col-lg-4">
            <input name="recipeIngredientWriteForms[` + parentIndex +`].amounts[` + newIndex + `]"  class="form-control">
        </div>
        <div class="col-lg-1">
            <a onclick="deleteSingleIngredient(this.parentElement)">
                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-trash" viewBox="0 0 16 16">
                    <path d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5m2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5m3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0z"/>
                    <path d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1zM4.118 4 4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4zM2.5 3h11V2h-11z"/>
                </svg>
            </a>
        </div>
        <div class="col"><br></div>
    `;
    parent.append(temp);
}

function deleteSingleIngredient(e) {
    e.parentElement.remove()
}

function deleteIngredient(e) {
    e.parentElement.parentElement.parentElement.parentElement.remove();
}

function mainPreviewImage() {
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

function stepPreviewImage(input) {
    var index = input.id.slice(-1);
    var preview = document.getElementById('step-photo-preview-' + index);

    if (input.files && input.files[0]) {
        var reader = new FileReader();

        reader.onload = function (e) {
            preview.src = e.target.result;
        };

        reader.readAsDataURL(input.files[0]);
    } else {
        preview.src = '/img/step-default.gif';
    }
}

function fileLoad(element) {
    var index = element.id.slice(-1);
    var input = document.getElementById('final-photo-' + index);

    if (window.FileReader) {
        input.click();

        input.addEventListener('change', function() {
            var selectedFile = input.files[0];

            if (selectedFile) {
                var reader = new FileReader();
                reader.onload = function(e) {
                    element.src = e.target.result;
                };
                reader.readAsDataURL(selectedFile);
            }
        });
    }
}


function addAllFinalPhoto() {
    var input = document.getElementById('final-photo');

    if (window.FileReader) {

        input.click();

        input.addEventListener('change', function() {
            var files = input.files;
            if (files.length > 5) {
                alert('최대 5개 까지 등록 가능합니다.');
                return;
            }

            var list = document.getElementById('final-photo-list');
            list.innerHTML = `
                <div class="col">
                    <img src="/img/step-default.gif" id="final-photo-preview-0" style="max-width: 100%; height: auto; object-fit: cover; aspect-ratio: 1/1;  width: 100%;  display: block; margin: auto;">
                </div>
                <div class="col">
                    <img src="/img/step-default.gif" id="final-photo-preview-1" style="max-width: 100%; height: auto; object-fit: cover; aspect-ratio: 1/1;  width: 100%;  display: block; margin: auto;">
                </div>
                <div class="col">
                    <img src="/img/step-default.gif" id="final-photo-preview-2" style="max-width: 100%; height: auto; object-fit: cover; aspect-ratio: 1/1;  width: 100%;  display: block; margin: auto;">
                </div>
                <div class="col">
                    <img src="/img/step-default.gif" id="final-photo-preview-3" style="max-width: 100%; height: auto; object-fit: cover; aspect-ratio: 1/1;  width: 100%;  display: block; margin: auto;">
                </div>
                <div class="col">
                    <img src="/img/step-default.gif" id="final-photo-preview-4" style="max-width: 100%; height: auto; object-fit: cover; aspect-ratio: 1/1;  width: 100%;  display: block; margin: auto;">
                </div>
            `;


            for (let i = 0; i < files.length; i++) {
                var file = files[i];
                if (file.type.match('image')) {
                    var reader = new FileReader();

                    reader.onload = function (e) {
                        var preview = document.getElementById('final-photo-preview-' + i);
                        preview.src = e.target.result;
                    };
                    reader.readAsDataURL(file);
                }
            }

            document.getElementById('all-final-photo-input').value = '한 개씩 추가하기'
            document.getElementById('all-final-photo-input').onclick = function() {
                buttonChange();
            }
        });
    }
}

function buttonChange() {
    var list = document.getElementById('final-photo-list');
    list.innerHTML = `
        <div class="col">
            <img src="/img/step-default.gif" id="final-photo-preview-0" onclick="fileLoad(this)" style="cursor: pointer; max-width: 100%; height: auto; object-fit: cover; aspect-ratio: 1/1;  width: 100%;  display: block; margin: auto;">
            <input type="file" class="form-control" id="final-photo-0" name="finalPhotos[0]" accept="image/jpeg, image/png, image/jpg, image/gif" style="display: none">
        </div>
        <div class="col">
            <img src="/img/step-default.gif" id="final-photo-preview-1" onclick="fileLoad(this)" style="cursor: pointer; max-width: 100%; height: auto; object-fit: cover; aspect-ratio: 1/1;  width: 100%;  display: block; margin: auto;">
            <input type="file" class="form-control" id="final-photo-1" name="finalPhotos[1]" accept="image/jpeg, image/png, image/jpg, image/gif" style="display: none">
        </div>
        <div class="col">
            <img src="/img/step-default.gif" id="final-photo-preview-2" onclick="fileLoad(this)" style="cursor: pointer; max-width: 100%; height: auto; object-fit: cover; aspect-ratio: 1/1;  width: 100%;  display: block; margin: auto;">
            <input type="file" class="form-control" id="final-photo-2" name="finalPhotos[2]" accept="image/jpeg, image/png, image/jpg, image/gif" style="display: none">
        </div>
        <div class="col">
            <img src="/img/step-default.gif" id="final-photo-preview-3" onclick="fileLoad(this)" style="cursor: pointer; max-width: 100%; height: auto; object-fit: cover; aspect-ratio: 1/1;  width: 100%;  display: block; margin: auto;">
            <input type="file" class="form-control" id="final-photo-3" name="finalPhotos[3]" accept="image/jpeg, image/png, image/jpg, image/gif" style="display: none">
        </div>
        <div class="col">
            <img src="/img/step-default.gif" id="final-photo-preview-4" onclick="fileLoad(this)" style="cursor: pointer; max-width: 100%; height: auto; object-fit: cover; aspect-ratio: 1/1;  width: 100%;  display: block; margin: auto;">
            <input type="file" class="form-control" id="final-photo-4" name="finalPhotos[4]" accept="image/jpeg, image/png, image/jpg, image/gif" style="display: none">
        </div>
    `;
    document.getElementById('all-final-photo-input').value = '한번에 추가하기'
    document.getElementById('all-final-photo-input').onclick = function() {
        addAllFinalPhoto();
    }
}

function addStep(e) {
    const newIndex = Number(e.getElementsByClassName('card shadow mb-4')[e.getElementsByClassName('card shadow mb-4').length - 1].id.slice(-1)) + 1;

    const temp = document.createElement('div');
    temp.classList.add('card');
    temp.classList.add('shadow');
    temp.classList.add('mb-4');
    temp.id = "step-" + newIndex;
    temp.innerHTML = `
        <div class="row card-body">
            <div class="col-lg-9">
                <div class="row">
                    <div class="col-1">
                        <input type="button" onclick="deleteStep(this.parentElement)" class="btn btn-primary" value="순서 삭제">
                    </div>
                    <div class="col-11"></div>
                    <div class="col-12">
                        <br>
                        <textarea class="form-control" name="recipeStepWriteForms[` + newIndex + `].detail" rows="7"  placeholder="예) 소고기는 기름을 떼어내고 적당한 크기로 썰어주세요."></textarea>
                    </div>
                    <div class="col-2 mt-3 align-self-center">
                        <small>재료 정보</small>
                    </div>
                    <div class="col-10 mt-3">
                        <input name="recipeStepWriteForms[` + newIndex + `].ingredient" class="form-control" placeholder="예) 밀가루 100g, 소금 2큰술, 물 100g">
                    </div>
                    <div class="col-2 mt-1 align-self-center">
                        <small>도구 정보</small>
                    </div>
                    <div class="col-10 mt-1">
                        <input name="recipeStepWriteForms[` + newIndex + `].tool" class="form-control" placeholder="예) 국자, 가위">
                    </div>
                    <div class="col-2 mt-1 align-self-center">
                        <small>불 조절</small>
                    </div>
                    <div class="col-10 mt-1">
                        <input name="recipeStepWriteForms[` + newIndex + `].fire" class="form-control" placeholder="예) 강불, 약불">
                    </div>
                    <div class="col-2 mt-1 align-self-center">
                        <small>요리 팁</small>
                    </div>
                    <div class="col-10 mt-1">
                        <input name="recipeStepWriteForms[` + newIndex + `].tip" class="form-control" placeholder="예) 아삭한 식감의 콩나물이 좋다면 다음 단계에서 넣으세요.">
                    </div>
                </div>
            </div>
            <div class="col-lg-3">
                <label for="mainPhoto" class="col-form-label mt-4">음식 이미지</label>
                <input type="file" class="form-control" id="step-photo-` + newIndex + `" name="recipeStepWriteForms[` + newIndex + `].photo" accept="image/jpeg, image/png, image/jpg, image/gif" onchange="stepPreviewImage(this)">
                <img id="step-photo-preview-` + newIndex + `" src="/img/step-default.gif" alt="Step Photo Preview" style="max-width: 100%; height: auto; object-fit: cover; aspect-ratio: 1/1;  width: 100%;  display: block; margin: auto;" class="pt-4 pb-4 ps-4 pe-4">
            </div>
        </div>
    `;
    document.getElementById('step-list').append(temp);
}

function deleteStep(e) {
    e.parentElement.parentElement.parentElement.parentElement.remove();
}

function write_check() {
    const form = document.data;

    if (form.mainPhoto.value == '') {
        return error_alert_focus('대표 이미지', form.mainPhoto);
    }
    if (form.title.value == '') {
        return error_alert_focus('레시피 제목', form.title);
    }
    if (form.describe.value == '') {
        return error_alert_focus('레시피 소개', form.describe);
    }
    if (form.foodType.value == '') {
        return error_alert_focus('카테고리 (종류별)', form.foodType);
    }
    if (form.situationType.value == '') {
        return error_alert_focus('카테고리 (상황별)', form.situationType);
    }
    if (form.methodType.value == '') {
        return error_alert_focus('카테고리 (방법별)', form.methodType);
    }
    if (form.ingredientType.value == '') {
        return error_alert_focus('카테고리 (재료별)', form.ingredientType);
    }
    if (form.foodSize.value == '') {
        return error_alert_focus('요리정보 (인원)', form.foodSize);
    }
    if (form.cookingTime.value == '') {
        return error_alert_focus('요리정보 (조리시간)', form.cookingTime);
    }
    if (form.difficultyLevel.value == '') {
        return error_alert_focus('요리정보 (난이도)', form.difficultyLevel);
    }

    var categorys = form.querySelectorAll('input[name^="recipeIngredientWriteForms["][name$="].category"]');

    for (var i = 0; i < categorys.length; i++) {
        var input = categorys[i];

        if (input.value == '') {
            return error_alert_focus('재료 종류', input);
        }
    }

    var InputIngredientData = document.querySelectorAll('#ingredient-list input');

    for (var i = 0; i < InputIngredientData.length; i++) {
        if (InputIngredientData[i].value == '') {
            return error_alert_focus("레시피 재료 정보", InputIngredientData[i]);
        }
    }

    var details = document.querySelectorAll('textarea[name^="recipeStepWriteForms["][name$="].detail"]');

    for (var i = 0; i < details.length; i++) {
        var input = details[i];

        if (input.value == '') {
            return error_alert_focus('요리 순서', input);
        }
    }

    form.submit();
}

function error_alert_focus(word, f) {
    alert(word + "을(를) 입력해주세요.");
    f.focus();
}

