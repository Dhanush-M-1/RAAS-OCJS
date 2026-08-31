s=input()
n=int(input())
a=[]
b=[]
for i in range(n):
    c=input()
    a.append(c[0])
    b.append(c[1])
    if c==s:
        print('YES')
        break
else:
    if ((s[1] in a) and (s[0] in b)):
        print('YES')
    else:
        print('NO')