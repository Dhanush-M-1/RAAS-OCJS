s=input()
n=int(input())
f=e=''
for i in range(n):
    t=input()
    if t==s:exit(print('YES'))
    f+=t[0]
    e+=t[1]
    if s[0] in e and s[1] in f:exit(print('YES'))
print('NO')