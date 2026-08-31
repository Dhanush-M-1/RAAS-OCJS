t = int(input())
i = 0
while i < t:
    n = int(input())
    a = list(map(int, input().split()))
    if a[0] + a[1] <= a[len(a) - 1]:
        print(1, 2, len(a))
    else:
        print(-1)
    i += 1