p, n, w = input(), int(input()), []
w.extend(input() for _ in range(n))

if any(s == p for s in w) or (any(s.startswith(p[1]) for s in w) and any(s.endswith(p[0]) for s in w)):
    print('YES')
else:
    print('NO')
