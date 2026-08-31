
import sys
import collections
import heapq
import math
import bisect

input = sys.stdin.readline

def rints(): return map(int, input().strip().split())
def rstr(): return input().strip()
def rint(): return int(input().strip())
def rintas(): return [int(i) for i in input().strip().split()]
    
def gcd(a, b):       
    if (b == 0): 
        return a 
    return gcd(b, a%b) 
 
n, m = rints()
a = rintas()
b = rintas()
b.sort()
ans = float('inf')
for i in range(n):
    k = (m+b[i] - a[0])%m
    tmp = []
    for j in a:
        tmp.append((j+k)%m)
    tmp.sort()
    if tmp == b:
        ans = min(ans, k)
print(ans)
