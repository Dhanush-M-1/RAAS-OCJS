import sys
import collections
import heapq
import math
 
input = sys.stdin.readline
 
def rints(): return map(int, input().strip().split())
def rstr(): return input().strip()
def rint(): return int(input().strip())
def rintas(): return [int(i) for i in input().strip().split()]
    
def gcd(a, b):       
    if (b == 0): 
         return a 
    return gcd(b, a%b) 

t = rint()
for _ in range(t):
    n = rint()
    p = rintas()
    ans = [0, 0, 0]
    d = n//2

    cmp = p[d]
    while d > 0 and p[d-1] == cmp:
            d -= 1
    if d >= 5:
        g, s , b = 0, 0 , 0
        idx = 0
        for i in range(d):
            idx = i
            if i == 0 or p[i] == p[i-1]:
                 g += 1
            else:
                break

        for i in range(idx, d):
            idx = i
            if i == 0 or p[i] == p[i-1] or s <= g:
                s += 1
            else:
                break
        
        b = d-idx
        if g > 0 and s > 0 and b > 0 and g < s and g < b:
            print(str(g) + " " + str(s) + " " + str(b))
        else:
            print("0 0 0")
    else:
        print("0 0 0")
    
