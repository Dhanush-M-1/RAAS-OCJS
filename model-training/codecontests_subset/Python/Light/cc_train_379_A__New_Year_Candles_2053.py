[a, b] = map(int, input().split())
ans = a
res = 0

while a >= b:
    res = a % b
    ans += (a - res) / b
    a = (a - res) / b + res

print(int(ans))
