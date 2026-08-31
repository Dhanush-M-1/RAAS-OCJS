n,m = map(int,input().split())
k = n
p = n
if n < m:
    print(k)
elif n == m:
    print(k + 1)
else:
    while p >= m:
        k += p // m
        p = p // m + p % m
    print(k)