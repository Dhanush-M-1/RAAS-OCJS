from math import log2
from collections import defaultdict
import sys
input = sys.stdin.readline
'''
for CASES in range(int(input())):
n, m = map(int, input().split())
n = int(input())
A = list(map(int, input().split()))
S = input().strip()
sys.stdout.write(" ".join(map(str,ans))+"\n")
'''
inf = 100000000000000000  # 1e17
mod = 998244353


n = int(input())
A=defaultdict(list)
ru=[0]*n
for i in range(n-1):
    x,y = map(int, input().split())
    x-=1
    y-=1
    A[x].append(y)
    A[y].append(x)
    ru[x]+=1
    ru[y]+=1
num=0
flag=1
for i in range(n):
    if ru[i]==2:
        flag=0

if flag==1:
    print("yes")
else:
    print("no")
# the end
