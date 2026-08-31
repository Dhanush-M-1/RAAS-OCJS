password = input()
n = int(input())

flag1 = False
flag2 = False
flag3 = False

for i in range(n):
    word = input()
    
    if password == word:
        flag1 = True
    if word[1] == password[0]:
        flag2 = True
    if word[0] == password[1]:
        flag3 = True

if flag1:
    print('YES')
elif flag2 and flag3:
    print('YES')
else:
    print('NO')
