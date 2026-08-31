for _ in range(int(input())):
    n=int(input())
    l=list(map(int,input().split()))
    a=l[0]
    b=l[1]
    c=l[-1]
    if(a+b<=c):
        print(1,2,n)
    else:
        print(-1)