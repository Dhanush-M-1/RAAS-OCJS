read = lambda: map(int, input().split())
n, m = read()
a = set()
for i in range(n):
    y = list(read())[1:]
    a |= set(y)
print('YES' if a == {i for i in range(1, m + 1)} else 'NO')
