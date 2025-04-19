@import gg.jte.Content
@import exercise.dto.users.UsersPage
@import exercise.model.User

@param UsersPage page

@template.layout.page(
    content = @`
        <form action="/users" method="get" class="mb-3">
            <div class="input-group">
                <input type="text" class="form-control" name="term" value="${page.getTerm() == null ? "" : page.getTerm()}" placeholder="Поиск по имени">
                <button type="submit" class="btn btn-primary">Найти</button>
            </div>
        </form>

        @if (page.getUsers().isEmpty())
            <p>Совпадений не найдено.</p>
        @else
            <ul class="list-group">
                @for(User user : page.getUsers())
                    <li class="list-group-item">
                        ${user.getFirstName()} ${user.getLastName()}
                    </li>
                @endfor
            </ul>
        @endif
    `
)

