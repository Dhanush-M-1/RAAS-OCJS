p=input()
p1=p[0]
p2=p[-1]
n=int(input())
a=[]
f1=False
f2=False
for i in range(n):
    a.append(input())
if p in a:
    print('YES')
else:
    for i in range(len(a)):
        if a[i][-1]==p1:
            f1=True
        if a[i][0]==p2:
            f2=True
    if f2 and f1:
        print('YES')
    else:
        print('NO')
