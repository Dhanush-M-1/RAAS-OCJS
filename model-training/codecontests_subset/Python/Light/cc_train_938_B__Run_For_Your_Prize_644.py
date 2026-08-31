n = int(input())
a = list(map(int, input().split()))

ans = float("+inf")

for i in range(n+1):
    cur = 0
    if i:
        cur = max(cur, a[i-1]-1)
    if i != n:
        cur = max(cur, 1000000-a[i])
    ans = min(ans, cur)

print(ans)
