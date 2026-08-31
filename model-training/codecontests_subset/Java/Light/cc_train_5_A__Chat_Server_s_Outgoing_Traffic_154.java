var counter = 0;
var users = [];
var cmd = "";
while (cmd != undefined) {
    cmd = readline();

    if (!cmd) { break; }

    switch (cmd.charAt(0)) {
        case "+":
            var commer = cmd.slice(1);
            users.push(commer);
            break
        case "-":
            var leaver = cmd.slice(1);
            users = users.filter(function (e) { return e != leaver });
            break
        default:
            var msg = cmd.slice(cmd.indexOf(":") + 1);
            counter += users.length * msg.length;
    }   
}
print(counter);