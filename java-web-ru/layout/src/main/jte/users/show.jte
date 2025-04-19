@import gg.jte.Content
@import exercise.dto.users.UserPage

@param UserPage page

@template.layout.page(
    title = "Информация о пользователе",
    content = @`
        <div class="card">
            <div class="card-body">
                <h5 class="card-title">${page.getUser().getFirstName()} ${page.getUser().getLastName()}</h5>
                <p class="card-text">ID: ${page.getUser().getId()}</p>
                <p class="card-text">Email: ${page.getUser().getEmail()}</p>
            </div>
        </div>
    `
)