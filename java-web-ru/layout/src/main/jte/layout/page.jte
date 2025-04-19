@import gg.jte.Content
@param Content content
@param String title

<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <title>${title}</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
        <p>
            <a href="/users">Users</a>
            <a href="/">Home</a>
        </p>
        <main class="container">
            ${content}
        </main>
        <footer class="footer bg-light">
            <div class="container">
                <span class="text-muted"> &copy; 2023. <a href="https://gitlab.com/ваш_логин">Ваш профиль GitLab</a></span>
            </div>
        </footer>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>