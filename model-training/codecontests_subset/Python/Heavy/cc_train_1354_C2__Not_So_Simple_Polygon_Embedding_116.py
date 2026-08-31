from math import *
import sys

sys.setrecursionlimit(10 ** 6)
int1 = lambda x: int(x) - 1
p2D = lambda x: print(*x, sep="\n")
def II(): return int(sys.stdin.readline())
def MI(): return map(int, sys.stdin.readline().split())
def LI(): return list(map(int, sys.stdin.readline().split()))
def LLI(rows_number): return [LI() for _ in range(rows_number)]
def SI(): return sys.stdin.readline()[:-1]

def main():
    for _ in range(II()):
        n=II()
        a=0.5/sin(pi/n/2)
        #print(a)
        r=(pi/2-pi*(n//2)/n)/2
        ans=a*cos(r)*2
        print(ans)

main()