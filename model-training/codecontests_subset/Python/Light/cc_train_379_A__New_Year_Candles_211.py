n,m = input().split()
n,m = int(n),int(m)

ans = n
while n >= m:
    value = int(n/m)
    n = int(n/m) + int(n % m)
    ans += value
print(ans)
