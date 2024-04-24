
'use strict';


function getCurrentUser() {
    fetch("/api/user/")
        .then(res => res.json())
        .then(user => {
            const roles = user.roles.map(role => role.role).join(',')
            $('#emailCurrentUser').append(`<span>${user.email}</span>`)
            $('#roleCurrentUser').append(`<span>${roles}</span>`)
            const u = `$(
                    <tr>
                       <td>${user.id}</td>
                          <td>${user.name}</td>
                          <td>${user.surname}</td>
                          <td>${user.email}</td>
                          <td>${user.age}</td>
                        <td>${roles}</td>
                    </tr>)`;
            $('#oneUser').append(u)
        })
}

getCurrentUser()








