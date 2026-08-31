def fun(l):
    sum=l[0]+l[1]
    for i in range(len(l)):
        if sum<=l[i]:
            return [1,2,i+1]
    return [-1]
t=int(input())
for _ in range(t):
    n=int(input())
    l=list(map(int,input().split()))
    ans=fun(l)
    print(*ans)
