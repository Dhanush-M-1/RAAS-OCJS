for i in range(int(input())):
    n=int(input())
    l=[int(x) for x in input().split()]
    count=0
    if l[0]+l[1]<=l[n-1]:
        print(*[1,2,n])
    else:
        print(-1)
            