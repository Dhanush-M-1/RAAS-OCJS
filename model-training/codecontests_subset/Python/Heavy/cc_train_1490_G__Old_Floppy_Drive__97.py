import math
import sys
import collections
import bisect
import heapq



testcases = int(sys.stdin.readline())

for _ in range(testcases):
    arr = list(map(int,sys.stdin.readline().strip().split()))
    n = arr[0]
    m = arr[1]
    

    ns = list(map(int,sys.stdin.readline().strip().split()))
    ms = list(map(int,sys.stdin.readline().strip().split()))

    subs = [0]*n
    mx = 0
    s = 0
    improves = []
    imp = []
    for i,j in enumerate(ns):
        s += j
        subs[i] = s
        if s > mx:
            mx = s
            improves.append((s,i))
            imp.append(s)

    #print(subs)
    #print(improves)
    #print(imp)

    for m in ms:
        #print("output", m)
        if subs[-1] <= 0 and m > mx:
            print(-1,end=" ")
            continue
        else:
            res = 0
            x = m - mx
            #print(x, "x")
            if x > 0:
                res = math.ceil(x/subs[-1])*len(ns)
                m -= math.ceil(x/subs[-1])*subs[-1]
            
            #print(m, "m")

            ind = bisect.bisect_left(imp,m)
            #print(ind, "ind")
            res += improves[ind][1]

            print(res, end = " ")

    print("")
            

