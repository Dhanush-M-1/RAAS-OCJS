import sys


# inf = open('input.txt', 'r')
# reader = (map(int, line.split()) for line in inf)
reader = (map(int, line.split()) for line in sys.stdin)
input = reader.__next__

def gsb(p, n):
    if n < 10:
        return [0, 0, 0]
    
    m = n // 2 - 1
    while m >= 0 and p[m] == p[m+1]:
        m -= 1
    if m < 4:
        return [0, 0, 0]
    
    g = 1
    while g-1 < m and p[g-1] == p[g]:
        g += 1
    if g-1 == m:
        return [0, 0, 0]
    
    clusters = []
    k = 1
    for i in range(g, m - 1):
        if p[i] != p[i+1]:
            clusters.append(k)
            k = 1
        else:
            k += 1
    clusters.append(k)
    s = 0
    for c in clusters:
        s += c
        if s > g:
            break
    b = m + 1 - g - s
    if b > g:
        return [g, s, b]
    else:
        return [0, 0, 0]

t, = input()
for _ in range(t):
    n, = input()
    p = list(input())
    ans = gsb(p, n)
    print(*ans)
    
# inf.close()
