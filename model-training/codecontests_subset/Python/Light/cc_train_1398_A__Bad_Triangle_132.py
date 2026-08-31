for _ in range(int(input())):
    n = int(input())
    a = list(map(int, input().strip().split()))[:n]

    i = a[0]
    j1 = a[1]
    j2 = a[-2]
    k = a[-1]

    if(i + j1 <= k):
        print(1, 2, n)
    elif(i + j2 <= k):
        print(1, n-1, n)
    else:
        print(-1)