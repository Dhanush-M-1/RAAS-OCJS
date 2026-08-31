import sys
n, k = map(int, input().split())
cnt = n
while n >= k:
    cnt, n = cnt + n // k, n // k + n - (n // k * k)
print(cnt)