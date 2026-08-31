a, b = map(int, input().split())

res = 0

while a > 0:
    d, r = divmod(a, b)
    if d:
        res += d * b
        a = d + r
    else:
        res += r
        a = 0

print(res)