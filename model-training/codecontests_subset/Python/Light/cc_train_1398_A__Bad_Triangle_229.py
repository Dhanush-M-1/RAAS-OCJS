t=int(input())
while t:
    t-=1
    n=int(input())
    lst=list(map(int,input().split()))
    res=-1
    a=lst[0]
    b=lst[1]
    if n==3:
        if a+b<=lst[2]:
            res=3
    else:
        for i in range(2,n):
            if a+b<=lst[i]:
                res=i+1
                break
    if res==-1:
        print(-1)
    else:
        print(1,2,res)