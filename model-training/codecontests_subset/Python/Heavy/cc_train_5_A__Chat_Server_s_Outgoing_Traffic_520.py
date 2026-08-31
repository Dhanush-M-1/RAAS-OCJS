import sys

res = 0
users = {}
# try:
#     for line in sys.stdin:
#         if ':' in line:
#             sender_name, message_text = line.split(':')
#             res += len(users) * (len(message_text) - 1)
#         else:
#             command = line[0]
#             name = line[1:]
#             if command == '+':
#                 users[name] = 1
#             else:
#                 users.pop(name)
# except:
#     print(res)

for line in sys.stdin:
    if ':' in line:
        _, message_text = line.split(':')
        res += len(users) * (len(message_text) - 1)
    else:
        command = line[0]
        name = line[1:]
        if command == '+':
            users[name] = 1
        else:
            users.pop(name)
print(res)