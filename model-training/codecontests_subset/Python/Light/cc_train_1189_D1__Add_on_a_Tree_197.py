# https://codeforces.com/contest/1189/problem/D1
n    = int(input())
g    = {}
p    = {}
path = {}
flg  = True

for _ in range(n-1):
    u,v = map(int, input().split())
    if u not in g:
        g[u] = []
    g[u].append(v)
    
    if v not in g:
        g[v] = []
    g[v].append(u)

flg = 'YES'
for x in g:
    if len(g[x]) == 1:continue
    if len(g[x]) == 2:
        flg = 'NO'
        break
        
print(flg)        