for _ in range(int(input())):
    n = int(input())
    l = list(map(int,input().split()))
    l.sort()

    if l[0] + l[1] > l[-1] and l[0] + l[-1] > l[1] and l[1] + l[-1] > l[0] :
        print(-1)
    else:
        print(1,2,n) 