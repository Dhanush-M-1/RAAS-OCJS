
for _ in range(int(input())):
    n=int(input())
    l=list(map(int,input().split()))
    t=l[0]+l[1]
    flag=0
    for i in range(2,n):
        if l[i]>=t:
            flag=1
            c=i
            break
    if flag:
        print(1,2,c+1)
    else:
        print(-1)
    # flag=0
    # for i in range(n-2):
    #     a=l[i]
    #     b=l[i+1]
    #     c=l[i+2]
    #     if a+b<=c:
    #         flag=1
    #         break
    # if flag:
    #     print(a+1,b+1,c+1)
    # else:
    #     print(-1)
