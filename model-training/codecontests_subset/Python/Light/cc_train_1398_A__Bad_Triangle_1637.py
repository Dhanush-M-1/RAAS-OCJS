t = int(input())
while t:
    t -= 1
    n = int(input())
    lis = [*map(int, input().split())]
    if lis[0] + lis[1] <= lis[n - 1]:
        print(1, 2, n)
    else:
        print(-1)
