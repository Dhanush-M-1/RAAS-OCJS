a, b = map(int, input().split())
i = 0
j = a
ans = a
while j >= b:
    now = j//b
    ans += now
    j %= b
    j += now
print(ans)
