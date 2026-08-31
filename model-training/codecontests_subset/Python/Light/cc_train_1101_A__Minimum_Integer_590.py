def f(x):
    l, r, d = map(int, x.split())
    if l > d:
        return d
    else:
        return r + (d - r%d)

q = int(input())
print('\n'.join(map(str, [f(input()) for _ in range(q)])))
