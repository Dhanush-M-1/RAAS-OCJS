n, k = map(int, input().split()); c = n
while n >= k:
    c += n // k; n -= (n // k)*k - n // k
print(c)