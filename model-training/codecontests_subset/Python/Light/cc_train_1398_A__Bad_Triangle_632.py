inp = lambda cast=int: [cast(x) for x in input().split()]
printf = lambda s='', *args, **kwargs: print(str(s).format(*args), flush=True, **kwargs)

t, = inp()
for _ in range(t):
    n, = inp()
    A = inp()
    a, b, c = A[0], A[1], A[-1]
    if a + b <= c:
        print(1, 2, n)
    else:
        print(-1)