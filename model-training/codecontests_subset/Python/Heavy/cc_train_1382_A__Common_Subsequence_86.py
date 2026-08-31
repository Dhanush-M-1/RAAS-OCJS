from sys import stdin,stdout
from collections import Counter
from math import ceil
from bisect import bisect_left 
from bisect import bisect_right
import math

def ai(): return list(map(int, stdin.readline().split()))
def ei(): return map(int, stdin.readline().split())
def ip(): return  int(stdin.readline().strip())
def op(ans): return stdout.write(str(ans) + '\n')

for i in range(ip()):
    n,m = ei()
    a = ai()
    b = ai()
    a = set(a)
    b = set(b)
    x = list(a.intersection(b))
    if x:
        print('YES')
        print(1,x[0])
    else:
        print('NO')

#     n = ip()
#     s = input()
#     d = {}
#     for i in s:
#       if i not in d:
#           d[i] = 1
#       else:
#           d[i] += 1
#     ans = d.values()
#     cnt = 0
#     for i in ans:
#       if i%2:
#           cnt += 1
#           break
#     if cnt==0:
#       print("YES")
#     else:
#       print('NO')
