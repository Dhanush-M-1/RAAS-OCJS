import sys;input=sys.stdin.readline
# from decimal import *
# import math
# getcontext().prec = 50
# input().strip()
# int(input())
# list(map(int,input().split()))
# map(int,input().split())
# def solve():

# for _ in range(int(input())):
#     solve()    
# print()
def update(res,h):
    for i in h.keys():
        res[ord(i)-97]+=h[i]
def solve():
    n,m = map(int,input().split())
    s = input().strip()
    q = sorted(list(map(int,input().split())),reverse = True)
    h = {}
    for i in s:
        if i not in h:
            h[i] = 1
        else:
            h[i] = h[i]+1
    res = [0 for _ in range(26)]
    last = len(s)
    update(res,h)
    for qu in q:
        for x in range(qu,last):
            h[s[x]]-=1
        update(res,h)
        last = qu
    print(*res)
    
# solve()
for _ in range(int(input())):
    solve()    