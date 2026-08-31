n, m = list(map(int, input().split()))
a = set(range(1, m + 1))
s = set()
for i in range(n):
    x = list(map(int, input().split()))
    for j in x[1:]:
        s.add(j)
if a - s == set():
    print('YES')
else:
    print('NO')