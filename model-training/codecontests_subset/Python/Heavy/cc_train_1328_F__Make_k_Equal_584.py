from heapq import *
from collections import *
import sys

sys.setrecursionlimit(10 ** 5)
int1 = lambda x: int(x) - 1
p2D = lambda x: print(*x, sep="\n")
def II(): return int(sys.stdin.readline())
def MI(): return map(int, sys.stdin.readline().split())
def MI1(): return map(int1, sys.stdin.readline().split())
def LI(): return list(map(int, sys.stdin.readline().split()))
def LI1(): return list(map(int1, sys.stdin.readline().split()))
def LLI(rows_number): return [LI() for _ in range(rows_number)]
def SI(): return sys.stdin.readline()[:-1]

def main():
    n,k=MI()
    cnt=Counter(LI())
    aa=[]
    cc=[]
    for a,c in sorted(cnt.items()):
        aa.append(a)
        cc.append(c)
        if c>=k:
            print(0)
            exit()
    #print(aa)
    #print(cc)
    n=len(aa)
    cl=[0]*n
    sc=0
    sa=0
    for i in range(n):
        cl[i]=(aa[i]-1)*sc-sa
        sc+=cc[i]
        sa+=cc[i]*aa[i]
    #print(cl)

    cr=[0]*n
    sc=0
    sa=0
    for i in range(n-1,-1,-1):
        cr[i]=sa-(aa[i]+1)*sc
        sc+=cc[i]
        sa+=cc[i]*aa[i]
    #print(cr)

    ans=10**16
    s=0
    for i in range(n):
        s+=cc[i]
        if s<k:cur=cl[i]+cr[i]+k-cc[i]
        else:cur=cl[i]+k-cc[i]
        if cur<ans:ans=cur
        if s>=k:break
    s=0
    for i in range(n-1,-1,-1):
        s+=cc[i]
        if s<k:cur=cl[i]+cr[i]+k-cc[i]
        else:cur=cr[i]+k-cc[i]
        if cur<ans:ans=cur
        if s>=k:break
    print(max(ans,0))

main()
