n, k = map(int, input().split())
ans = 1000000000000
for x in input().split():
    ans = min(k / int(x) if k % int(x) == 0 and k >= int(x) else 1000000000000, ans)
print(int(ans))
