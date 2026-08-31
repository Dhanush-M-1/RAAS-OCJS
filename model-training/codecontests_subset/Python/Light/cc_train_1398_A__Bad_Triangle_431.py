t = int(input())


for _ in range(t):
    l = int(input())
    a = list(map(int, input().strip().split()))
    if l < 3:
        print(-1)
        continue

    if a[0]+a[1] <= a[l-1]:
        print("{0} {1} {2}".format(1, 2, l))
    else:
        print(-1)
