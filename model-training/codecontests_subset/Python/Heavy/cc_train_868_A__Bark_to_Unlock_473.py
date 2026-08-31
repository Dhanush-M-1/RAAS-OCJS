from sys import stdin
password = stdin.readline()
n = int(stdin.readline())
words = []
for i in range(0, n):
    words.append(stdin.readline())

firstAvailable = False
secondAvailable = False
for i in range(0, n):
    if words[i] == password:
        firstAvailable = True
        secondAvailable = True
    if words[i][1] == password[0]:
        firstAvailable = True
    if words[i][0] == password[1]:
        secondAvailable = True

if (firstAvailable and secondAvailable):
    print("YES")
else:
    print("NO")