R = lambda: map(int, input().split())
n = int(input())
arr = [list(R()) for _ in range(n)]
if n <= 2:
    print(n)
    exit(0)
res = 2
for i in range(1, n - 1):
    if arr[i][0] - arr[i][1] > arr[i - 1][0]:
        res += 1
    elif arr[i][0] + arr[i][1] < arr[i + 1][0]:
        res += 1
        arr[i][0] += arr[i][1]
print(res)