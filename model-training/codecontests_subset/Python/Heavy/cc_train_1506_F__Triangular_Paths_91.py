import sys
input = sys.stdin.readline

t = int(input().strip())
for __ in range(t):
    n = int(input().strip())
    rarr = [int(val) for val in input().strip().split(' ')]
    carr = [int(val) for val in input().strip().split(' ')]
    arr = [(0,1,1)]+[(r-c,r,c) for r, c in zip(rarr,carr)]
    arr.sort()
    res = 0

    for i in range(n):
        delta = arr[i+1][0] - arr[i][0]
        if delta % 2:
            if arr[i][0] % 2:
                res += delta // 2+1
            else:
                res += delta // 2
        elif delta == 0 and arr[i][0] % 2 == 0:
            res += arr[i+1][1]-arr[i][1]
        else:
            res += delta // 2
    print(res)
