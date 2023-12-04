

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
        console.log(parent);
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