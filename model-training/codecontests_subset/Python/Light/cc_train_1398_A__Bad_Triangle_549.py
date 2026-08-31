for _ in range(int(input())):
    n=int(input())
    l=list(map(int,input().split()))
    m=max(l)
    for i in range(0,n-1):
        if (l[i]+l[i+1])<=m:
            print(i+1,i+2,n)
            break
    else:
        print(-1)