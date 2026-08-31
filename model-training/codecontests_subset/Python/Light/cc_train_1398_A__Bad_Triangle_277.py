t=int(input())
for i in range(t):
    n=int(input())
    a=[int(v) for v in input().split()]
    p=a[0]
    q=a[1]
    r=a[-1]
    if p+q<=r:
        print(1,2,n)
    else:
        print(-1)