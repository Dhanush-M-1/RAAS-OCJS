for _ in range(int(input())):
    n=int(input())
    l=list(map(int,input().split()))
    l=[0]+l
    a=l[1]
    b=l[2]
    for i in range(2,n+1):
        c=l[i]
        if a+b<=c:
            print(1,2,i)
            break
    else:
        print(-1)