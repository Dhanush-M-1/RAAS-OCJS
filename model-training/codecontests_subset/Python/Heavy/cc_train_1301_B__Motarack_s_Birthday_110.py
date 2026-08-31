from sys import stdin, stdout
from math import *
from heapq import *
from collections import *

def main():
    ntest=int(stdin.readline())
    for test in range(ntest):
        n=int(stdin.readline().strip())
        a=[int(x) for x in stdin.readline().strip().split()]
        vset=set(a)
        if len(vset)<=2:
            stdout.write('0 %d\n'%(max(max(vset),0)))
            continue
        minm=0
        dset=set()
        for i in range(1,n):
            if a[i]==a[i-1]:
                continue
            if (-1 not in [a[i-1],a[i]]):
                minm=max(minm,abs(a[i-1]-a[i]))
            else:
                dset.add(max(a[i-1],a[i]))
        k=trunc((max(dset)+min(dset)+1)/2)
        m=max(max(max(dset)-k, k-min(dset)),minm)
        stdout.write("%d %d\n"%(m,k))
    return 0

if __name__ == "__main__":
    main()