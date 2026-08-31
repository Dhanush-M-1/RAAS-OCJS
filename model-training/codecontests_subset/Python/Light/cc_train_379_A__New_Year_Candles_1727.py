a, b = map(int, input().split())
ans = r = 0
while a != 0:
    ans += a
    r += a
    a = r // b
    r %= b
print(ans)
