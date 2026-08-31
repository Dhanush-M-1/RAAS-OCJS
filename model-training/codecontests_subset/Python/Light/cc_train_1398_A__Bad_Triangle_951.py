for _ in range(int(input())):
    n = int(input())
    lst = list(map(int,input().split()))
    if lst[0]+lst[1] > lst[-1]:
        print(-1)
    else:
        print(1,2,n)
