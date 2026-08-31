password = input()
n = int(input())
s = []
for i in range(n):
    s.append(input())

if password in s:
    print('YES')
else:
    front = False
    back = False
    for i in s:
        if password[0] == i[1]:
            front = True
            break
    for i in s:
        if password[1] == i[0]:
            back = True
            
    if front and back:
        print('YES')
    else:
        print('NO')
