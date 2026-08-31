t=int(input())
for i in range(t):
    n=int(input())
    a=[]
    b=[]
    f=0
    for j in range(n):
        p,q=map(int,input().split())
        a.append(p)
        b.append(q)
    for j in range(n-1):
        if a[j+1]<a[j]:
            f=1
            break
        if b[j+1]<b[j]:
            f=1
            break
        if a[j]<b[j]:
            f=1
            break
        if (a[j+1]-a[j])<(b[j+1]-b[j]):
            f=1
            break
    if a[-1]<b[-1]:
        f=1
    if f==1:
        print("NO")
    else:
        print("YES")