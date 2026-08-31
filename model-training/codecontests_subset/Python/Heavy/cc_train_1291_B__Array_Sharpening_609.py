import sys
t=int(input())
g=sys.stdin.readlines()


for j in range(t):
    n=int(g[2*j])
    a=list(map(int,g[2*j+1].split()))
    lf=0
    rf=n-1
    f=False
    for i in range(1,n):
        if i-1<a[i]:
            lf+=1
        else:
            break
    for i in range(n-2,-1,-1):
        if n-i-2<a[i]:
            rf-=1
        else:
            break
    if lf==n-1:
        f=True

    if rf==0:
        f=True

    if rf<=lf:
        f=True
    if f:
        print("Yes")
    else:
        print("No")

