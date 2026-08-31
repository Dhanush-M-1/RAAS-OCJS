n, m = map(int, input().split())
chas = 0
while n > 0:
    chas += 1
    n -= 1
    if chas % m == 0:
        n += 1
print(chas)