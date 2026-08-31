def fun(ai,n):
    ii = -ai%n
    num = (ii*n)-ii-ai
    return num

n = int(input())
a = [int(i) for i in input().split()]
if n==1:
    print(1,1)
    print(-a[0])
    print(1,1)
    print(0)
    print(1,1)
    print(0)
else:
    ans1 = []
    for i in range (n):
        if a[i]%n==0:
            ans1.append(-a[i])
            a[i]=0
        else:
            ans1.append(fun(a[i],n))
            a[i]+=ans1[-1]
    ans2=[]
    for i in range (n-1):
        ans2.append(-a[i])
    print(1,n)
    print(*ans1)
    print(1,n-1)
    print(*ans2)
    print(n,n)
    print(-a[-1])