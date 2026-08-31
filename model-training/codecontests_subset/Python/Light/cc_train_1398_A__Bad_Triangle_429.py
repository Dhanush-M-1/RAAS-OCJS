test = int(input().strip())

for _ in range(test):
    n = int(input().strip())
    arr = list(map(int, input().strip().split(" ")))

    i1, i2, i3 = 0, 1, n-1
    if arr[i1] + arr[i2] <= arr[i3]:
        print(i1 + 1, i2 + 1, i3 + 1)
    else:
        print(-1)
