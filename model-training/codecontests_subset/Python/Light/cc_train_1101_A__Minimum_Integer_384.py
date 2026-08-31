import math
n = int(input())
for i in range(n):
    x = list(map(int,input().split()))
    l = x[0]
    r = x[1]
    d = x[2]

    if d < l:
        print (d)
    else:

        print (r + d - (r % d))