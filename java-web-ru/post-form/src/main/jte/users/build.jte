@template.layout.page(
content = @`
    <form action="/users" method="post">
        <div class="mb-3">
            <label class="form-label">
                Имя
                <input type="text" class="form-control" required name="firstName" />
            </label>
        </div>
        <div class="mb-3">
            <label class="form-label">
                Фамилия
                <input type="text" class="form-control" required name="lastName" />
            </label>
        </div>
        <div class="mb-3">
            <label class="form-label">
                Почта
                <input type="email" class="form-control" required name="email" />
            </label>
        </div>
        <div class="mb-3">
            <label class="form-label">
                Пароль
                <input type="password" class="form-control" required name="password" />
            </label>
        </div>
        <input type="submit" class="btn btn-primary" value="Регистрация" />
    </form>
`
)