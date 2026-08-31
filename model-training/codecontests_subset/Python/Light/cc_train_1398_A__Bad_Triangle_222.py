for _ in range(int(input())):
    n = int(input())
    x = list(map(int, input().split()))
    if x[0] + x[1] <= x[-1]:
        print(1, 2, n)
    else:
        print(-1)