n, m = list(map(int, input().split()))
i = 1
while i != n + 1:
    if i % m == 0:
        n += 1
    i += 1
print(n) 