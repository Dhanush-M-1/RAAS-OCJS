a, b = map(int, input().split())

ost = 0
ans = 0

while a > 0:
    ost += a
    ans += a
    a = 0
    
    a += ost // b
    ost %= b

print(ans)
