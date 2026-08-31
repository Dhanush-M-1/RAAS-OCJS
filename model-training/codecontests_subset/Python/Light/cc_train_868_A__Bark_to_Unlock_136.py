a=input()
n=int(input())
pra=0
pob=0
if n==1:
    c=input()
    if (c==a or c==a[::-1]):
        print('YES')
    else:
        print('NO')
else:
    for i in range(n):
        c=input()
        if a[0] == c[1]:
            pra+=1
        if a[1]==c[0]:
            pob+=1
        if a==c:
            pra+=1
            pob+=1
    if (pra>=1 and pob>=1):
        print('YES')
    else:
        print('NO')
