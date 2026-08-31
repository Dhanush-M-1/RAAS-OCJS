t = int(input())
for i in range(t):
    a, b, n = map(int, input().split())
    a = bin(a)[2:]
    b = bin(b)[2:]
    s = ''
    al = len(a)
    bl = len(b)
    if al > bl:
        b = '0'*(al - bl)+b
    else:
        a = '0'*(bl - al)+a
    m = max(al, bl)
    d = n % 3
    if d == 0:
        for k in range(m):
            s = s + a[k]
    if d == 1:
        for k in range(m):
            s = s + b[k]
    if d == 2:
        for k in range(m):
            s = s + str((int(a[k]) + int(b[k])) % 2)
    print(int(s, 2))
