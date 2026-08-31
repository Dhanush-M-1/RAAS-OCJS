'''
n, m = input().split()
n = int(n); m = int(m)
a = sorted([int(x) for x in input().split()])
b = sorted([int(x) for x in input().split()])
for x in range(m):
    c = sorted([(i+x) % m for i in a])
    if c == b:
        print(x)
        break
'''
n, m = input().split()
n = int(n); m = int(m)
a = sorted([int(x) for x in input().split()])
b = sorted([int(x) for x in input().split()])
for index in range(n):
    c = a[ : n - index]
    d = b[index: n]
    for i in range(n-index):
        if d[i] - c[i] != d[0] - c[0]:
            break
    else:
        x = (d[0] - c[0] + m) % m
        break
print(x)