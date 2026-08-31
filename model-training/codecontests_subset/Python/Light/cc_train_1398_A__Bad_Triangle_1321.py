t=int(input())
while(t):
    n=int(input())
    l=list(map(int,input().split()))
    a=l[0]+l[1]
    b=l[-1]
    if(a<=b):
        print(1,2,n)
    else:
        print(-1)

    t-=1
