#                               #
    # author : samars_diary #
    # 14-09-2020 │ 17:02:13 #
#                               #

import sys, os.path

if(os.path.exists('input.txt')):
    sys.stdin = open('input.txt',"r")
    #sys.stdout = open('output.txt',"w")

sys.setrecursionlimit(10 ** 5)

def mod(): return 10**9+7
def i(): return sys.stdin.readline().strip()
def ii(): return int(sys.stdin.readline())
def li(): return list(sys.stdin.readline().strip())
def mii(): return map(int, sys.stdin.readline().split())
def lii(): return list(map(int, sys.stdin.readline().strip().split()))

#print=sys.stdout.write

def solve():
    a=ii()
    con2=con3=0
    while a%2==0: con2+=1 ; a//=2
    while a%3==0: con3+=1 ; a//=3
    if a==1 and (con2<=con3): print(2*con3-con2)
    else: print(-1)
for _ in range(ii()):
    solve()