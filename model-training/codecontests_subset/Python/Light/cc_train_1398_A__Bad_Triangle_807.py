for _ in range(int(input())):
    n=int(input())
    l=list(map(int, input().split()))
    a=l[0]+l[1]
    f=1
    for i in range(2,n):
        if(a<=l[i]):
            f=0
            break
    if(f):
        print(-1)
    else:
        print(1,2,i+1)
