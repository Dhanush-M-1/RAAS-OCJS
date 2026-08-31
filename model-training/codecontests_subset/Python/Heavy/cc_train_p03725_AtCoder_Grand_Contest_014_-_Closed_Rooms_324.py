import sys
input = sys.stdin.readline

import itertools

# 初日以外は何も気にせず動けるとしてよい。初日に到達可能な場所のうち、最もゴールに近いものはどこか

H,W,K = map(int,input().split())
A = '#' * (W+2)
for _ in range(H):
    A += '#' + input().rstrip() + '#'
A += '#' * (W+2)

start = A.find('S')
dxs = (1,-1,(W+2),-(W+2))

visited = set()
q = [start]
visited.add(start)
for _ in range(K):
    qq = []
    for x,dx in itertools.product(q,dxs):
        y = x+dx
        if A[y] == '#':
            continue
        if y in visited:
            continue
        visited.add(y)
        qq.append(y)
    q = qq

nearest = 10**9
for x in visited:
    row,col = divmod(x,W+2)
    d = min(row-1,H-row,col-1,W-col)
    if nearest > d:
        nearest = d

answer = 1 + (nearest+K-1)//K
print(answer)