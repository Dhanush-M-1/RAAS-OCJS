from bisect import bisect_left
import math
for _ in range(int(input())):
    n,m=map(int,input().split())
    a=list(map(int,input().split()))
    x=list(map(int,input().split()))
    curSum=0
    mx=[]
    mxindx=[]
    for i in range(n):
        curSum+=a[i]
        if mx==[] or mx[-1]<curSum:
            mx.append(curSum)
            mxindx.append(i)
    stack=[]
    for i in range(m):
        if x[i]>mx[-1] and curSum<=0:
            stack.append(-1)
        else:
            temp=0
            if(x[i]>mx[-1]):
                diff=x[i]-mx[-1]
                temp=math.ceil(diff/curSum)
            stack.append(temp*n+mxindx[bisect_left(mx,x[i]-curSum*temp)])
    print(*stack)