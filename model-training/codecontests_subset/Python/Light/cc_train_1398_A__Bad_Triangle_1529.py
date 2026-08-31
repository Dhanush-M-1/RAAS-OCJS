t = int(input())
for x in range(t) :
    n = int(input())
    arr = list(map(int, input().split(" ")))
    i = 1
    j = 2
    l = arr[0] + arr[1]
    y = 2
    while y < n :
        k = arr[y]
        if k >= l :
            k = y + 1
            break
        y += 1
    if y == n :
        print(-1)
    else :
        print(i, j, k)
        