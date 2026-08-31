def check(x, a, b, m):
    res = [(a[i] + x) % m for i in range(n)]
    res.sort() 
    b_copy = b.copy()
    b_copy.sort()
    if b_copy == res:
        return x
    else: 
        return m + 2

n, m = map(int, input().split())
a = list(map(int, input().split()))
b = list(map(int, input().split()))
min_ = m + 1
for i in range(n):
    if b[0] - a[i] < 0:
        x = m - abs(b[0] - a[i])
    else:
        x = b[0] - a[i]
    if 0 <= check(x, a, b, m) < min_:
        min_ = check(x, a, b, m)
print(min_)