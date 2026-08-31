#! python3

current_users = []

def add_user(user):
    global current_users
    current_users.append(user)

def remove_user(user):
    global current_users
    if user in current_users:
        current_users.remove(user)

def message_byte(message):
    global current_users
    return len(current_users)*len(message)

def get_input():
    while True:
        try:
            line = input()
            if line == '':
                break
            else:
                yield line
        except EOFError:
            break

commands = list(get_input())
all_bytes = 0
for cmd in commands:
    if cmd.startswith('+'):
        add_user(cmd[1:])
    elif cmd.startswith('-'):
        remove_user(cmd[1:])
    else:
        all_bytes += message_byte(cmd.split(':')[1])
print(all_bytes)
