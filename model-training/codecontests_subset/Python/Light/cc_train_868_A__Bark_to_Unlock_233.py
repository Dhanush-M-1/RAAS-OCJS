ip = input()
n = int(input())

flag1, flag2 = False, False

for _ in range(n):
    s = input()
    if s==ip:
        flag1, flag2 = True, True
        break
    if ip[1] == s[0]:
        flag1=True
    if ip[0] == s[1]:
        flag2=True
        
if flag1==True and flag2==True:
    print('YES')
else:
    print('NO')