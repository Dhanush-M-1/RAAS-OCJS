for _ in range(int(input())):
    n=int(input())
    l=[int(i) for i in input().split()]
    a,b,c=l[0],l[1],l[-1]
    if a+b<=c:
        print(1,2,n)
    else:
        print(-1)