import sys
input = sys.stdin.readline
from collections import defaultdict

def compress(l):
    l = list(set(l))
    l.sort()
    idx = defaultdict(int)
    c = 0
    
    for li in l:
        idx[li] = c
        c += 1
    
    return idx
    
class BIT:
    #n:要素数
    def __init__(self, n):
        self.n = n
        self.bit = [0]*(n+1)
    
    #i番目(0-indexed)の値にxを足す
    def add(self, i, x):
        i += 1
        
        while i<=self.n:
            self.bit[i] += x
            i += i&(-i)
    
    #0からi番目までの値の和を求める
    def acc(self, i):
        i += 1
        s = 0
        
        while i>0:
            s += self.bit[i]
            i -= i&(-i)
        
        return s
    
n = int(input())
x = list(map(int, input().split()))
v = list(map(int, input().split()))
xv = [(xi, vi) for xi, vi in zip(x, v)]
xv.sort(key=lambda t: t[0])
idx = compress(v)
sum_bit = BIT(len(idx))
cnt_bit = BIT(len(idx))
ans = 0

for xi, vi in xv:
    ans += cnt_bit.acc(idx[vi])*xi-sum_bit.acc(idx[vi])
    sum_bit.add(idx[vi], xi)
    cnt_bit.add(idx[vi], 1)

print(ans)
