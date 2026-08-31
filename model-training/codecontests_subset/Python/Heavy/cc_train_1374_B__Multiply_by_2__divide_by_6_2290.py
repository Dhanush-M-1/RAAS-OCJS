
def func(n,m):
    #print(n,m)
    if n==1:
        return m
    elif n<6:
        return func(2*n,m+1)
    elif n<=0:
        return 1
    else:
        if n%6==0:
            return func(n//6,m+1)
        elif n%3==0:
            return func(2*n,m+1)
        else:
            return -1


t=int(input())
for _ in range(t):
    n=int(input())
    print(func(n,0))
##    x,y,n=map(int,input().split())
##    ans=0
##    a=(n-y)%x
##    print(n-a)
##    for k in range(n,-1,-1):
##        if k%x==y:
##            ans=k
##            break
##    print(ans)


