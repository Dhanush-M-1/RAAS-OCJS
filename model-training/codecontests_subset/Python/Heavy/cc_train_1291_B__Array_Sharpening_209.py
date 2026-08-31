"""
-----------------------------Pseudo---------------------------------
"""
import copy
import sys
from collections import defaultdict, Counter

def input(): return sys.stdin.readline()
def mapi(): return map(int,input().split())
def maps(): return map(str,input().split())
#
def print(arg, *argv, end=None):
    sys.stdout.write(str(arg))
    for i in argv: sys.stdout.write(" "+str(i))
    sys.stdout.write(end) if end else sys.stdout.write("\n")
#
def GCD(x, y): return GCD(y,x%y) if y else x
#
def modPow(x, y, p):
    res,x = 1,x%p
    while(y>0):
        if(y&1)==1: res=(res*x)%p
        y,x = y>>1,(x*x)%p
    return res
def modInv(s, mod): return modPow(s,mod-2,mod)
#---------------------------------------------------------------#

def solve():
    t = 1
    t = int(input())
    while(t):
        t-=1
        n = int(input())
        a = list(mapi())
        pf = [True]
        sf = [True]
        for i in range(n):
            pf.append(pf[-1] and a[i]>=i)
            sf.append(sf[-1] and a[n-i-1]>=i)
            ##print(pf[i],sf[i])
        pf = pf[1:]
        sf = sf[::-1]
        sf.pop()
        ##print(pf,sf)
        i=0
        while(i<n):
            if pf[i] and sf[i]:
                break
            i+=1
        if i>=n:
            print("No")
        else:
            print("Yes")

#---------------------------------------------------------------#
if __name__ == '__main__':
    solve()

