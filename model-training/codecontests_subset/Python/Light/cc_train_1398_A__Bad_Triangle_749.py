t = int(input())

for i in range(t):
    n = int(input())
    a = list(map(int, input().split()))

    found = False

    for j in range(2, n):
        if a[0] + a[1] <= a[j]:
            print(1, 2, j + 1)
            found = True
            break

    if not found:
        print(-1)
