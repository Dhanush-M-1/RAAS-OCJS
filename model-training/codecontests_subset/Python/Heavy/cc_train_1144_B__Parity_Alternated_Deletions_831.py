n=int(input())
a=list(map(int,input().split()))
a.sort()
b=[]
c=[]
s=0
r=0
e=0
d=0
for i in range(len(a)):
    if a[i]%2==0:

        e+=1
        b.append(a[i])
    else:
        d+=1
        c.append(a[i])

if e>d+1 and d>0:
    x=e-d
    for i in range(x-1):
        s=s+b[i]
    print(s)
elif d>e+1 and e>0:
    x=d-e
    for i in range(x-1):
        s=s+c[i]
    print(s)
elif d==0:
    for i in range(len(b)-1):

        s=s+b[i]
    print(s)
elif e == 0:
    for i in range(len(c) - 1):
        s = s + c[i]
    print(s)
else:
    print(0)






