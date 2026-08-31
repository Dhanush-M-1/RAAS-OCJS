a, b = map(int, input().split())
ans = 0
cur = 0
while a:
    ans += a
    cur += a
    a = int(cur / b)
    cur = cur % b
print(ans)
    