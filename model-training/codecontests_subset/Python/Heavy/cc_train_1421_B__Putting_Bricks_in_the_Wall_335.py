from collections import *
from functools import *
import math
import sys 

# sys.stdin  = open("Desktop//ip.txt",'r')
# sys.stdout = open("Desktop//op.txt",'w')

inp = sys.stdin.readline
out = sys.stdout.write

def mi():
    return map(int,inp().split())
def li():
    return list(mi())
def ii():
    return int(inp())

def main():
    for _ in range(ii()):
        n = ii()
        grid = []
        for _ in range(n):
            grid.append(input())
        ans = [] ; ans1 = []
        a = grid[0][1]
        b = grid[1][0]
        c = grid[-1][-2]
        d = grid[-2][-1]
        if a != '0':
            ans.append([1,2])
        if b != '0':
            ans.append([2,1])
        if c != '1':
            ans.append([n, n-1])
        if d != '1':
            ans.append([n-1, n])

        if a != '1':
            ans1.append([1,2])
        if b != '1':
            ans1.append([2,1])
        if c != '0':
            ans1.append([n, n-1])
        if d != '0':
            ans1.append([n-1, n])
        if len(ans) <= len(ans1):
            print(len(ans))
            for i in ans:
                print(*i)
        else:
            print(len(ans1))
            for i in ans1:
                print(*i)

main()