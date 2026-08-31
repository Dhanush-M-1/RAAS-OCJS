n, k = map(int, input().split())
arr = list(map(int, input().split()))

ans = 1000000
for i in range(n):
    if k % arr[i] == 0:
        temp = k // arr[i]
        ans = min(temp, ans)

print(ans)
