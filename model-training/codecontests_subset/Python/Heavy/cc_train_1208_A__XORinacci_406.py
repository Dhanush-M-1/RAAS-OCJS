def xor(a, b):
    ans = ''
    ma = a if len(a) > len(b) else b
    mi = a if len(a) < len(b) else b
    for d in range(1, len(mi)-1):
        ans = '1'+ans if a[-d] != b[-d] else '0'+ans
    ans = ma[2:2+len(ma)-len(mi)]+ans
    return '0b'+ans


def f(a, b, n):
    if n == 0:
        return a
    if n == 1:
        return b
    return xor(f(a, b, n-1), f(a, b, n-2))


arr = []
for i in range(int(input())):
    p = input().split()
    x, y = bin(int(p[0])), bin(int(p[1]))
    z = int(p[2]) % 3
    arr.append(int(f(x, y, z), 2))
print(*arr, sep='\n')
