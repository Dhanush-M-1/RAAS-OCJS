n, k = map(int, input().split())
s = 0
while (n > 0):
    s += min(n, k)
    n -= k
    n += 1
print(s)
