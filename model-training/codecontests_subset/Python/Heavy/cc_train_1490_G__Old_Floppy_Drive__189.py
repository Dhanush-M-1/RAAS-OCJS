import sys
from sys import stdin
import bisect

tt = int(stdin.readline())

for loop in range(tt):

    n,m = map(int,stdin.readline().split())

    a = list(map(int,stdin.readline().split()))
    xlis = list(map(int,stdin.readline().split()))

    s = 0
    inds = []
    sums = []

    for i in range(n):
        s += a[i]
        if len(inds) == 0:
            if s > 0:
                inds.append(i)
                sums.append(s)
        elif sums[-1] < s:
            inds.append(i)
            sums.append(s)

    ans = []
    if len(sums) == 0:
        print (*[-1 for i in range(m)] )
        continue

    for x in xlis:
        if s <= 0:
            if sums[-1] < x:
                ans.append(-1)
            else:
                ans.append( inds[ bisect.bisect_left(sums,x) ] )

        else:

            l = -1
            r = x+1

            while r-l != 1:
                mid = (l+r)//2
                if s*mid + sums[-1] >= x:
                    r = mid
                else:
                    l = mid

            nans = n * r
            rem = x - r * s

            ans.append ( nans + inds[ bisect.bisect_left(sums,rem) ] )

    print (*ans)