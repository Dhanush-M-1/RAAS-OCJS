n, m = map(int, input().split())
ost = 0
ans = 0
while n:
    ans += n
    n += ost
    ost = n % m
    n //= m
print(ans)
