for i in range(int(input())):
    n = int(input())
    l = list(map(int,input().split()))
    t = l[0]+l[1]
    if l[-1] >= t:
        print(1,2,n)
    else:
        print(-1)