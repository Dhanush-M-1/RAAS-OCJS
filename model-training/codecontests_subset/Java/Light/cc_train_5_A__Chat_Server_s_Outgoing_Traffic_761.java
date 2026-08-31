function userAdd(user){
    if (userList.indexOf(user) === -1) userList.push(user);
}

function userRemove(user){
    var id = userList.indexOf(user);
    if (id !== -1) userList.splice(id, 1);
}

function send(msg){
    traffic += msg.length * userList.length;
}

var i, input, cmd, temp, userList = [], traffic = 0;

while (true){
    input = readline();
    if (typeof input === 'undefined') break;

    cmd = input.substr(0,1);
    if (cmd === '+') {
        userAdd(input.substr(1));
    } else if (cmd === '-') {
        userRemove(input.substr(1));
    } else {
        send(input.split(':')[1]);
    }
}

print(traffic);
