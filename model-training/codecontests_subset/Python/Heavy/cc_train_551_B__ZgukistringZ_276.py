import math,string,itertools,fractions,heapq,collections,re,array,bisect,copy
from itertools import chain, dropwhile, permutations, combinations
from collections import defaultdict, deque

# Guide:
#   1. construct complex data types while reading (e.g. graph adj list)
#   2. avoid any non-necessary time/memory usage
#   3. avoid templates and write more from scratch
#   4. switch to "flat" implementations

def VI(): return list(map(int,input().split()))
def I(): return int(input())
def LIST(n,m=None): return [0]*n if m is None else [[0]*m for i in range(n)]
def ELIST(n): return [[] for i in range(n)]
def MI(n=None,m=None): # input matrix of integers
    if n is None: n,m = VI()
    arr = LIST(n)
    for i in range(n): arr[i] = VI()
    return arr
def MS(n=None,m=None): # input matrix of strings
    if n is None: n,m = VI()
    arr = LIST(n)
    for i in range(n): arr[i] = input()
    return arr
def MIT(n=None,m=None): # input transposed matrix/array of integers
    if n is None: n,m = VI()
    a = MI(n,m)
    arr = LIST(m,n)
    for i,l in enumerate(a):
        for j,x in enumerate(l):
            arr[j][i] = x
    return arr


def run(n,x,l,r):
    s = 0
    curr = 1
    for i in range(n):
        skip = (l[i]-curr) // x
        s += r[i]-curr-skip*x+1
        curr = r[i]+1
    print(s)



def main(info=0):
    a,b,c = input(), input(), input()

    A = [a.count(chr(x+ord('a'))) for x in range(26)]
    B = [b.count(chr(x+ord('a'))) for x in range(26)]
    C = [c.count(chr(x+ord('a'))) for x in range(26)]

    def nin(m,s):
        n = 1000000
        for x in set(s):
            i = ord(x)-ord('a')
            n = min(n, m[i]//s.count(x))
        return n

    def xin(m,s):
        n = 1000000
        for i in range(26):
            if s[i]>0:
                n = min(n, m[i]//s[i])
        return n

    def setup(ib,ic):
        s = b*ib + c*ic
        for i in range(26):
            char = chr(i+ord('a'))
            if char in s:
                A[i] -= s.count(char)
            s += char * A[i]
        return s


    # nb = nin(A,b)
    # nc = nin(A,c)
    nb = xin(A,B)
    nc = xin(A,C)

    best_i = (-1,-1)
    best = 0

    for j in range(nb+1):
        loc = nc
        for x in range(26):
            if C[x]>0:
                loc = min(loc, (A[x]-j*B[x])//C[x])
        if (j+loc)>best:
            best = j+loc
            best_i = (j,loc)
    print(setup(*best_i))

    # p = nc+nb
    # minus = 0
    # ii, jj = -1,-1
    # while p-minus>0:
    #     for i in range(0,minus+1):
    #         j = minus-i
    #         if i>nb or j>nc:
    #             continue
    #         #print("start ",p,i,j,p-i-j)
    #         if nin((b*(nb-i))+(c*(nc-j)))>0:
    #             ii,jj = nb-i,nc-j
    #             #print("f ",ii,jj)
    #             break
    #     if ii >= 0:
    #         #print("w ",ii,jj)
    #         break
    #     minus += 1

    # if ii<0:
    #     print(a)
    # else:
    #     s = b*ii + c*jj
    #     for i,v in enumerate(m):
    #         char = chr(i+ord('a'))
    #         if char in s:
    #             m[i] -= s.count(char)
    #         s += char * m[i]
    #     print(s)



if __name__ == "__main__":
    main()
