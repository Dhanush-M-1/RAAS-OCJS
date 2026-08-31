for u in range(int(input())):
    n=int(input())
    l=list(map(int,input().split()))
    s=l[0]+l[1]
    f=0
    for i in range(2,n):
        if(l[n-1]>=s):
            f=1
            print(1,2,n)
            break
    if(f==0):
        print(-1)
