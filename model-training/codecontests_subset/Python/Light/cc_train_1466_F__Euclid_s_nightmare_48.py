import sys
input = sys.stdin.buffer.readline

def _find(s, u):
    p = []
    while s[u] != u:
        p.append(u)
        u = s[u]
    for v in p: s[v] = u
    return u

def _union(s, u, v):
    su, sv = _find(s, u), _find(s, v)
    if su != sv: s[su] = sv

n, m = map(int, input().split())
s, res = list(range(m+1)), []
for i in range(n):
    p = list(map(int, input().split()))
    if p[0] == 1:
        u, v = 0, p[1]
    else:
        u, v = p[1], p[2]
    su, sv = _find(s, u), _find(s, v)
    if su != sv:
        _union(s, su, sv)
        res.append(i+1)
 
print(pow(2, len(res), 10**9+7), len(res))
print(*res)
