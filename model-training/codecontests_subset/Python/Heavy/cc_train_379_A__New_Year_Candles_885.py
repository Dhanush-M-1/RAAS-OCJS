#                               #
    # author : samars_diary #
    # 10:41:49 | 24-09-2020 #
#                               #

import sys, os.path

if(os.path.exists('input.txt')):
    sys.stdin = open('input.txt',"r")
    sys.stdout = open('output.txt',"w")

sys.setrecursionlimit(10 ** 5)

def i(): return sys.stdin.readline().strip()
def ii(): return int(sys.stdin.readline())
def li(): return list(sys.stdin.readline().strip())
def mii(): return map(int, sys.stdin.readline().split())
def lii(): return list(map(int, sys.stdin.readline().strip().split()))

#print=sys.stdout.write

def solve():
    a, b = mii() ; s = a
    while a>=b: 
        s+=(a//b)
        a=(a//b)+(a%b)
    print(s)
for _ in range(1): solve()
