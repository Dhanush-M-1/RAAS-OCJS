from bisect import bisect_left
import math
ii = lambda : int(input())
li = lambda:list(map(int,input().split()))
t = int(input())
for _ in range(t):
    n,m = li(); a = li();xl = li()
    mx = []; curSum = 0;mxind = [];res = []
    for i in range(n):
        curSum+=a[i]
        if mx==[] or mx[-1]<curSum:
            mx.append(curSum); mxind.append(i)
    for x in xl:
        if (x>mx[-1] and curSum<=0):
            res.append(-1)
        else:
            temp = 0
            if (x>mx[-1]):
                dif = x-mx[-1];temp = math.ceil(dif/curSum)
            res.append(temp*n+mxind[bisect_left(mx,x-temp*curSum)])
    print(*res)
    






