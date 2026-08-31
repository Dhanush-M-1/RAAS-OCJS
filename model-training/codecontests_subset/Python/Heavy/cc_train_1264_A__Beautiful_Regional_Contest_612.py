import sys
input = sys.stdin.readline
from collections import Counter

t = int(input())

for _ in range(t):
    n = int(input())
    p = list(map(int, input().split()))
    cnt = Counter(p)
    l = list(cnt.items())
    l.sort(key=lambda k: k[0], reverse=True)
    g = l[0][1]
    s = 0
    
    for i in range(1, len(l)):
        s += l[i][1]
        
        if s>g:
            mark = i
            break
    
    if s<=g:
        print(0, 0, 0)
        continue
    
    b = 0
    
    for i in range(mark+1, len(l)):
        if g+s+b+l[i][1]<=n//2:
            b += l[i][1]
        else:
            break
    
    if b<=g:
        print(0, 0, 0)
        continue
    
    print(g, s, b)
    