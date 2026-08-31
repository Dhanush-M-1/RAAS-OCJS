# cook your dish here
from sys import stdin, stdout
import math
from itertools import permutations, combinations
from collections import defaultdict
from bisect import bisect_left 
from bisect import bisect_right
from collections import deque
 
def L():
    return list(map(int, stdin.readline().split()))
 
def In():
    return map(int, stdin.readline().split())
 
def I():
    return int(stdin.readline())
 
P = 1000000007
k = I()
s = input()
lis = [0 for i in range(26)]
for i in range(len(s)):
    lis[ord(s[i])-97] += 1 
st = ''
flag = 1
for i in range(26):
    if lis[i]%k == 0:
        p = chr(97+i)
        st += p*(lis[i]//k)
    else:
        flag = 0 
        break
if flag:
    print(st*k)
else:
    print(-1)