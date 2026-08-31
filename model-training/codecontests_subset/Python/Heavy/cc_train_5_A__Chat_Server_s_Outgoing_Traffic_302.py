"""f = open("input.txt", "r")
if f.mode == 'r':
    contents = f.readlines()
   """

import sys

contents = []
participants = 0
sum = 0

while True:
    try:
        s = input()
        contents.append(s)
    except:
        break


for content in contents:
    if content[0] == "+":
        participants += 1
    elif content[0] == "-":
        participants -= 1
    else:
        flash = ":"
        message = content.partition(flash)[2]
        message = message.rstrip('\n')
        traffic = len(message)
        traffic *= participants
        sum += traffic
print(sum)

