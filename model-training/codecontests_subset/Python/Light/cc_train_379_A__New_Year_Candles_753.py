a, b = map(int, input().split())
ans = a
ost = 0
while a >= b:
    ost = a % b
    a = a // b
    ans += a
    a += ost
print(ans)