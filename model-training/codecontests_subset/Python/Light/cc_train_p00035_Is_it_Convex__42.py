import sys
f = sys.stdin

def take2(iterable):
    i = iter(iterable)
    while True:
        yield next(i), next(i)
def cross(a, b):
    return a.real * b.imag - a.imag * b.real
# 砂時計型の場合は考慮しない
def is_convex(a, b, c, d):
    v1 = cross(a - b, b - c)
    v2 = cross(b - c, c - d)
    v3 = cross(c - d, d - a)
    v4 = cross(d - a, a - b)    
    return 0 < v1 * v2 and 0 < v2 * v3 and 0 < v3 * v4

for line in f:
    a, b, c, d = [x + y *1j for x, y in take2(map(float, line.split(',')))]
    
    print('YES' if is_convex(a,b,c,d) else 'NO')