for t in range(int(input())):
    n=int(input())
    l=[int(i) for i in input().split()]
    if l[0]+l[1]>l[n-1]:
        print(-1)
    else:
        print(1,2,n)
        