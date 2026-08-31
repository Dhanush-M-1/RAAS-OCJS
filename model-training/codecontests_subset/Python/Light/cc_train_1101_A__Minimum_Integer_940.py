t=int(input())
for _ in range(t):
    n,k,m=map(int,input().split())
    if m<n:
        print(m)
    elif m>k:
        print(m)
    else:
        d=k-m
        e=d//m
        f=m*(e+2)
        print(f)





