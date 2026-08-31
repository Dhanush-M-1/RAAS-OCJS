#import math
#from functools import lru_cache
import heapq
#from collections import defaultdict
#from collections import Counter
#from collections import deque
#from sys import stdout
#from sys import setrecursionlimit
#setrecursionlimit(10**7)
from sys import stdin
input = stdin.readline

INF = 2*10**9 + 7
MAX = 10**7 + 7
MOD = 10**9 + 7

n, M, k = [int(x) for x in input().strip().split()]
c, a, b, u = [], [], [], []
for ni in range(n):
    ti, ai, bi = [int(x) for x in input().strip().split()]
    if(ai ==1 and bi == 1):
        c.append((ti, ni+1))
    elif(ai == 1):
        a.append((ti, ni+1))
    elif(bi == 1):
        b.append((ti, ni+1))
    else:
        u.append((ti, ni+1))
c.sort(reverse = True)
a.sort(reverse = True)
b.sort(reverse = True)
u.sort(reverse = True)
alen = len(a)
blen = len(b)
clen = len(c)
ulen = len(u)
#print(alen, blen, clen, ulen)
m = max(0, k - min(alen, blen), 2*k - M)
ans = 0
alist = []
adlist = []
#print(clen, m)
if(m>clen):
    print('-1')
else:
    for mi in range(m):
        cv, ci = c.pop()
        ans += cv
        heapq.heappush(alist, (-cv, ci))
    ka = k - m
    kb = k - m
    M -= m
    while(ka or kb):
        ca = (c[-1][0] if c else INF)
        da = 0
        ap, bp = 0, 0
        if(ka):
            da += (a[-1][0] if a else INF)
            ap = 1
        if(kb):
            da += (b[-1][0] if b else INF)
            bp = 1
        if(da<=ca and M>=2):
            ans += da
            if(ap):
                ka -= 1
                adlist.append(a[-1] if a else (INF, -1))
                if a: a.pop()
                M -= 1
            if(bp):
                kb -= 1
                adlist.append(b[-1] if b else (INF, -1))
                if b: b.pop()
                M -= 1
        else:
            ans += ca
            heapq.heappush(alist, (-c[-1][0], c[-1][1]) if c else (INF, -1))
            if c: c.pop()
            if(ap):
                ka -= 1
            if(bp):
                kb -= 1
            M -= 1
    #print('M and ans are', M, ans)
    if(M>(len(a) + len(c) + len(b) + len(u)) or ans>=INF):
        print('-1')
    else:
        heapq.heapify(c)
        while(M>0):
            #print('M and ans is : ', M, ans)
            if(u and u[-1][0] <= min(c[0][0] if c else INF, a[-1][0] if a else INF, b[-1][0] if b else INF)):
                ut, dt = 0, 0
                ut += (-alist[0][0] if alist else 0)
                ut += u[-1][0]
                dt += (a[-1][0] if a else INF)
                dt += (b[-1][0] if b else INF)
                if(ut<dt):
                    # add from ulist
                    upopped = u.pop()
                    adlist.append(upopped)
                    M -= 1
                    ans += upopped[0]
                else:
                    # remove from alist and add from ab
                    alpopped = (heapq.heappop(alist) if alist else (-INF, -1))
                    heapq.heappush(c, (-alpopped[0], alpopped[1]))
                    ans += alpopped[0]
                    bpopped = (b.pop() if b else (INF, -1))
                    apopped = (a.pop() if a else (INF, -1))
                    adlist.append(bpopped)
                    adlist.append(apopped)
                    ans += apopped[0]
                    ans += bpopped[0]
                    M -= 1
            else:
                # if c is less than a, b
                ct = (c[0][0] if c else INF)
                at, bt = (a[-1][0] if a else INF), (b[-1][0] if b else INF)
                abt = min(at, bt)
                if(ct<abt):
                    cpopped = (heapq.heappop(c) if c else (INF, -1))
                    heapq.heappush(alist, (-cpopped[0], cpopped[1]))
                    ans += cpopped[0]               
                    M-=1
                else:
                    # minimum is among a and b; straight forward
                    if(at<bt):
                        apopped = (a.pop() if a else (INF, -1))
                        adlist.append(apopped)
                        ans += apopped[0]
                    else:
                        bpopped = (b.pop() if b else (INF, -1))
                        adlist.append(bpopped)
                        ans += bpopped[0]
                    M-=1
            if(ans>=INF): break
        print(ans if ans<INF else '-1')
        if(ans < INF):
            for ai in adlist:
                print(ai[1], end = ' ')
            for ai in alist:
                print(ai[1], end = ' ')
            print('')            
