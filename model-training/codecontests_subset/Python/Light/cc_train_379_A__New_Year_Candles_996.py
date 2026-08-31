n, m = input().split()
n, m = int(n), int(m)
ans = 0
k = 0
while n > 0:
    ans += n
    newk = (n + k) % m
    newn = (n + k) // m
    k = newk
    n = newn
print(ans)