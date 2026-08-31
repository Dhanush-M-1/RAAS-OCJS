from collections import deque

import sys
input = sys.stdin.readline
    
def bfs(x,y,x2,y2,moves,seg):
    q = deque([])
    q.append((x,y,moves))
    
    rw = [0, 0, -1, 1, -1, -1, 1, 1]
    cl = [1, -1, 0, 0, -1, 1, -1, 1]
    visited =dict()
    visited[(x,y)]=1
    while q:
        curr= q.popleft()
        if curr[0]==x2 and curr[1]==y2:
            return curr[2]
        for w in range(8):
            if (curr[0]+rw[w],curr[1]+cl[w]) not in visited:
                if (curr[0]+rw[w],curr[1]+cl[w]) in seg:
                    q.append((curr[0]+rw[w],curr[1]+cl[w],curr[2]+1))
                    visited[(curr[0]+rw[w],curr[1]+cl[w])]=1        
        
    return -1


x,y,x2,y2 = [int(x) for x in input().split()]
n = int(input())
seg = set()
for i in range(n):
    r,a,b = [int(t) for t in input().split()]
    for q in range(a,b+1):
        seg.add((r,q))

print(bfs(x,y,x2,y2,0,seg))