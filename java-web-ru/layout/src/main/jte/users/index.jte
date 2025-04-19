@import gg.jte.Content
@import exercise.dto.users.UsersPage

@param UsersPage page

@template.layout.page(
    title = "Список пользователей",
    content = @`
        <a href="/users/build">New User</a>
        <ul class="list-group">
            @for(var user : page.getUsers())
                <li class="list-group-item">
                    <a href="/users/${user.getId()}">${user.getFirstName()} ${user.getLastName()}</a>
                </li>
            @endfor
        </ul>
    `
)