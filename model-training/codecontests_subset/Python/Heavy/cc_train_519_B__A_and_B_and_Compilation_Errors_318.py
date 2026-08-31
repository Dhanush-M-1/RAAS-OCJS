#                               #
    # author : samars_diary #
    # 28-09-2020 │ 13:22:31 #
#                               #

import sys, os.path

if(os.path.exists('input.txt')):
    sys.stdin = open('input.txt',"r")
    sys.stdout = open('output.txt',"w")

sys.setrecursionlimit(10 ** 5)

def mod(): return 1000000007
def ii(): return int(sys.stdin.readline())
def si(): return sys.stdin.readline().strip()
def li(): return list(sys.stdin.readline().strip())
def mii(): return map(int, sys.stdin.readline().split())
def lii(): return list(map(int, sys.stdin.readline().strip().split()))

#print=sys.stdout.write

def solve():
    a = ii() ; b = lii() ; c = lii() ; d = lii()
    print(sum(b)-sum(c))
    print(sum(c)-sum(d))

for _ in range(1):
    solve()