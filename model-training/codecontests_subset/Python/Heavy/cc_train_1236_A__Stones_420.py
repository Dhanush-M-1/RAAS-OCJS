'''
    Author : thekushalghosh
    Team   : CodeDiggers
'''
import sys,math
input = sys.stdin.readline
n = int(input())
for i in range(n):
    a,b,c = map(int,input().split())
    q = 0
    ww = 0
    if b > 0:
        bb = b
        if c > 1:
            q = min(c // 2,b) * 3
            bb = b - (q // 3)
        if bb > 1 and a > 0:
            w = min(bb // 2,a) * 3
            q = q + w
        if b > 1 and a > 0:
            ww = min(b // 2,a) * 3
            bb = b - (2 * (ww // 3))
        if bb > 0 and c > 1:
            w = min(c // 2,bb) * 3
            ww = ww + w
    print(max(q,ww))