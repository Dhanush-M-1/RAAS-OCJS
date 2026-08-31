n = int(input())
f = lambda x: x if x < n else f(x // n) * 10 + x % n
for i in range(1, n): print(*[f(i * j) for j in range(1, n)])