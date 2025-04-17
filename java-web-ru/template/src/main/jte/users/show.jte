@param exercise.dto.users.UserPage userPage

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Details</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container">
        <h1>User Details</h1>
        <div class="card">
            <div class="card-body">
                <h5 class="card-title">${userPage.getUser().getFirstName()} ${userPage.getUser().getLastName()}</h5>
                <p class="card-text">Email: ${userPage.getUser().getEmail()}</p>
                <a href="/users" class="btn btn-secondary">Back to Users</a>
            </div>
        </div>
    </div>
</body>
</html>