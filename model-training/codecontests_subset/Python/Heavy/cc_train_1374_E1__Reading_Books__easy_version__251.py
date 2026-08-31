# cook your dish here
#code
import math
import collections
from sys import stdin,stdout,setrecursionlimit
from bisect import bisect_left as bsl
from bisect import bisect_right as bsr
import heapq as hq
setrecursionlimit(2**20)

T = 1
#T = int(stdin.readline())

for _ in range(T):
    #n = int(stdin.readline())
    
    n,k = list(map(int, stdin.readline().rstrip().split()))
    
    t,a,b = [],[],[]
    sa,sb = 0,0
    for i in range(n):
        
        t1,t2,t3 = list(map(int, stdin.readline().rstrip().split()))
        t.append(t1)
        a.append(t2)
        b.append(t3)
        sa += t2
        sb += t3
        
    if(sa<k or sb<k):
        print(-1)
        continue
    else:
        on_a = []
        on_b = []
        on_ab = []
        for i in range(n):
            if(a[i]==1 and b[i]==1):
                on_ab.append(t[i])
            elif(a[i]==1):
                on_a.append(t[i])
            elif(b[i]==1):
                on_b.append(t[i])
                
        on_a.sort()
        on_b.sort()
        on_ab.sort()
        ans = 0
        ai, bi, abi = 0,0,0
        cnta, cntb = 0,0
        while((cnta!=k and cntb!=k) and (ai<len(on_a) and bi<len(on_b) and abi<len(on_ab)) ):
            if(on_a[ai]+on_b[bi]<on_ab[abi]):
                cnta += 1
                cntb += 1
                ans += (on_a[ai] + on_b[bi])
                ai += 1
                bi += 1
            else:
                cnta += 1
                cntb += 1
                ans += on_ab[abi]
                abi += 1
                
                
        if(cnta==k):
            print(ans)
            continue
        elif(abi<len(on_ab)):
            while(cnta!=k):
                ans += on_ab[abi]
                abi += 1
                cnta+=1
                
            print(ans)
            continue
        else:
            while(cnta!=k):
                ans += on_a[ai]
                ai += 1
                cnta+=1
            while(cntb!=k):
                ans += on_b[bi]
                bi += 1
                cntb+=1
            print(ans)
            continue
            