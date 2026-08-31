n, m = list(map(int, input().split()))
k = 0
while n != 0:
    k += 1
    n -= 1
    if k % m == 0 and k >= m:
        n += 1
print(k)
