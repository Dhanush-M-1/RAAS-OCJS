a, b = map(int, input().split())
ans = 0
while a >= b:
    ans += (a - a % b)
    a = a % b + a // b
if a != 0:
    ans += a
print(ans)
