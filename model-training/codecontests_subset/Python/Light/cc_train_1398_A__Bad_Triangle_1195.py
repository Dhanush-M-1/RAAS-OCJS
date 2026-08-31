for _ in range(int(input())):
    n = int(input())
    a = list(map(int, input().split()))
    t = 0
    for i in range(2, n):
        if a[0] + a[1] <= a[i]:
            print(1, 2, i + 1)
            break
        else:
            t += 1
    if t == n-2:
        print(-1)