import sys
input = sys.stdin.readline
from collections import *

def judge(i):
    return S*c+gain[i]>=xi

def binary_search():
    l, r = 0, n-1
    
    while l<=r:
        m = (l+r)//2
        
        if judge(m):
            r = m-1
        else:
            l = m+1
    
    return l

    
for _ in range(int(input())):
    n, m = map(int, input().split())
    a = list(map(int, input().split()))
    x = list(map(int, input().split()))
    gain = [a[0]]
    
    for i in range(1, n):
        gain.append(gain[-1]+a[i])
    
    M = max(gain)
    
    for i in range(1, n):
        gain[i] = max(gain[i], gain[i-1])
        
    S = sum(a)
    ans = []
    
    for xi in x:
        if S<=0:
            if xi>M:
                ans.append(-1)
            else:
                c = 0
                ans.append(binary_search())
        else:
            c = max(0, (xi-M+S-1)//S)
            i = binary_search()
            ans.append(n-1+(c-1)*n+i+1)
    
    print(*ans)