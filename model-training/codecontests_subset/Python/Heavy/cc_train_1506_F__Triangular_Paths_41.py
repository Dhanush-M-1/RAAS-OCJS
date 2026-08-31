from os import path;import sys,time
mod = int(1e9 + 7)
from math import ceil, floor,gcd,log,log2 ,factorial,sqrt
from collections import defaultdict ,Counter , OrderedDict , deque;from itertools import combinations,permutations
# from string import ascii_lowercase ,ascii_uppercase
from bisect import *;from functools import reduce;from operator import mul;maxx = float('inf')
I = lambda :int(sys.stdin.buffer.readline())
lint = lambda :[int(x) for x in sys.stdin.buffer.readline().split()]
S = lambda: sys.stdin.readline().strip('\n')
grid = lambda  r :[lint() for i in range(r)]
localsys = 0
start_time = time.time()
#left shift --- num*(2**k) --(k - shift)
nCr = lambda n, r: reduce(mul, range(n - r + 1, n + 1), 1) // factorial(r)
def ceill(n,x):
    return (n+x -1 )//x
T =1
def make_set(v):
    parent[v] = v

def find_set(v):
    if v== parent[v]:
        return v
    return find_set(parent[v])

def union_sets(a , b):
    a = find_set(a)
    b = find_set(b)
    if a!= b:
        parent[b] = a
def lcs(x , y ):
    m , n = len(x) , len(y)
    dp = [[None]*(n+1) for _ in range(m+1)]
    for i in range(m+1):
        for j in range(n+1):
            if i == 0 or j == 0 :
                dp[i][j] = 0
            elif y[j-1] == x[i-1]:
                dp[i][j] = dp[i-1][j-1]+ 1
            else:
                dp[i][j] = max(dp[i-1][j], dp[i][j-1])
    return dp[m][n]

def solve():
    n = I()
    arr , ans = [(1,1)] + sorted((i,j) for i ,j in zip(lint() , lint())) , 0
    for i in range(n):
        c = (arr[i+1][0] - arr[i][0]) - (arr[i+1][1] - arr[i][1])
        if not c:
            ans+=(1 - sum(arr[i]) % 2) *(arr[i+1][0] - arr[i][0])
            continue
        ans+=((c - (1 - sum(arr[i])%2))+1)//2
    print(ans)









def run():
    if (path.exists('input.txt')):
        sys.stdin=open('input.txt','r')
        sys.stdout=open('output.txt','w')


run()
T = I() if T else 1
for _ in range(T):
    solve()


if localsys:
    print("\n\nTime Elased :",time.time() - start_time,"seconds")


