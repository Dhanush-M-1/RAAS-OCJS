for i in range(int(input())):
    x=int(input())
    l=list(map(int,input().split()))
    hi=l[-1]
    lo=l[0]
    ne=l[1]
    if lo+ne>hi:
        print(-1)
    else:
        print('1 2',end=' ')
        print(len(l))