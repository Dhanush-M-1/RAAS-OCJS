import sys
from sys import stdin

tt = int(stdin.readline())


for loop in range(tt):

    n = int(stdin.readline())

    s = [stdin.readline()[:-1] for i in range(n)]

    ans = []
    for i in range(2**4):

        a,b = int(s[0][1]),int(s[1][0])
        c,d = int(s[n-2][n-1]),int(s[n-1][n-2])

        now = []
        if i & 1 > 0:
            a ^= 1
            now.append((1,2))
        if i & 2 > 0:
            b ^= 1
            now.append((2,1))

        if i & 4 > 0:
            c ^= 1
            now.append((n-1,n))

        if i & 8 > 0:
            d ^= 1
            now.append((n,n-1))

        if len(now) <= 2 and ((a+b==0 and c+d==2) or (a+b==2 and c+d==0)):
            ans = now
            break

    print (len(ans))
    for i in ans:
        print (*i)