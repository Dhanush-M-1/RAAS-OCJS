for _ in range(int(input())):
    n=int(input())
    l=list(map(int,input().split()))
    x=-1
    for i in range(0,n):
        if(l[i]<i):
            x=i
            break
    if(x==-1):
        print('YES')
        continue
    else:
        y=0
        for i in range(n-1,-1,-1):
            if(l[i]<y):
                break
            else:
                y+=1
        if(y==n):
            print('YES')
            continue
        if(y+x)<=n:
            print('NO')
        else:
            print('YES')

    