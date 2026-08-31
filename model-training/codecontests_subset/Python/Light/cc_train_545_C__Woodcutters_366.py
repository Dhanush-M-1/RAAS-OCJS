n = int(input())
arr = list((0, 0) for _ in range(n)) + [(2e9+3, 2e9+3)]
for i in range(n):
    a, b = map(int, input().split())
    arr[i] = (a, b)

if (n < 3):
    print(n)
    exit()

arr.sort()
res, e = 0, -2e9
for i in range(n):
    if arr[i][0] - arr[i][1] > e:
        res += 1
        e = arr[i][0]
    elif arr[i][0] + arr[i][1] < arr[i+1][0]:
        res += 1
        e = arr[i][0] + arr[i][1]
    else:
        e = arr[i][0]
print(res)
