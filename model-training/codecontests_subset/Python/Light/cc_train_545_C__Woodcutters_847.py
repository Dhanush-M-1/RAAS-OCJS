n, ps = int(input()), []
for _ in '0'*n:
    x, h = map(int, input().split())
    ps.append((x, h))
ps.append((2*10**9+1, 1)) # fell the last tree to the right
s, e = (ps[0][0] - ps[0][1]), ps[0][0]
for i in range(1, n):
    x, h = ps[i][0], ps[i][1]
    if e < x - h:              # left
        s = x - h
        e = x
    elif ps[i+1][0] > x + h:   # right
        s = x
        e = x + h
    else:
        s = e = x
        n -= 1
print(n)