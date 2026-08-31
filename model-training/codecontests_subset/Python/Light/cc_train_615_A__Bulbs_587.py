n,m=map(int,input().split())
x=[]
for i in range(n):
    s=list(input().split(' '))
    num=int(s[0])
    for j in range(1,num+1):
        if s[j] not in x:
            x.append(s[j])
x=set(list(map(int,x)))
if len(x)==m:
    print('YES')
else:
    print('NO')