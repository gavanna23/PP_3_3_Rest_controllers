const URLTableUsers = 'http://localhost:8080/api/admin/users/';

getAllUsers();

function getAllUsers() {
    fetch(URLTableUsers)
        .then(function (response) {
            return response.json();
        })
        .then(function (users) {
            let dataOfUsers = '';
            let rolesString = '';

            const tableUsers = document.getElementById('tableUsers');

            for (let user of users) {

                rolesString = user.roles.map(role => role.role).join(", ");

                dataOfUsers += `<tr>
                        <td>${user.id}</td>
                        <td>${user.name}</td>
                        <td>${user.surname}</td>
                        <td>${user.email}</td>
                        <td>${user.age}</td>                        
                        <td>${rolesString}</td>


                        <td>
                          <button type="button"
                          class="btn btn-info"
                          data-bs-toggle="modal"
                          data-target="#editModal"
                          onclick="editModal(${user.id})">
                                Edit
                            </button>
                        </td>


                        <td>
                            <button type="button" 
                            class="btn btn-danger" 
                            data-bs-toggle="modal" 
                            data-target="#deleteModal" 
                            onclick="deleteModal(${user.id})">
                                Delete
                            </button>
                        </td>
                    </tr>`;
            }
            tableUsers.innerHTML = dataOfUsers;
        })
}
