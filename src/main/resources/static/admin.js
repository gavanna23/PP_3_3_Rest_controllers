const URL = 'http://localhost:8080/api/admin/current/';
const navbarAdmin = document.getElementById('navbarAdmin');
const tableUserAdmin = document.getElementById('tableAdmin');

function getCurrentAdmin() {
    fetch(URL)
        .then((res) => res.json())
        .then((userAdmin) => {
            let rolesStringAdmin = userAdmin.roles.map(role => role.role).join(", ");
            let data = '';
            data += `<tr>
            <td>${userAdmin.id}</td>
            <td>${userAdmin.name}</td>
            <td>${userAdmin.surname}</td>
            <td>${userAdmin.email}</td>
            <td>${userAdmin.age}</td>
            <td>${rolesStringAdmin}</td>
            </tr>`;
            tableUserAdmin.innerHTML = data;
            navbarAdmin.innerHTML = `<b><span>${userAdmin.email}</span></b>
                             <span>with roles:</span>
                             <span>${rolesStringAdmin}</span>`;
        });
}

getCurrentAdmin()

async function getUserById(id) {
    let response = await fetch("/api/admin/user/" + id);
    return await response.json();
}

async function open_fill_modal(form, modal, id) {
    modal.show();
    let user = await getUserById(id);
    form.id.value = user.id;
    form.name.value = user.name;
    form.surname.value = user.surname;
    form.email.value = user.email;
    form.password.value = user.password;
    form.age.value = user.age;
    form.roles.value = user.roles;
}
