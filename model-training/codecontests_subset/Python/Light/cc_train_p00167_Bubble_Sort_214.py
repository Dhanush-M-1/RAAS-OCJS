while 1:
    n=int(input())
    if n==0:break
    c=0
    a=[int(input()) for _ in range(n)]
    for i in range(n):
        for j in range(n-1,0,-1):
            if a[j]<a[j-1]:c,(a[j],a[j-1])=c+1,(a[j-1],a[j])
    print(c)