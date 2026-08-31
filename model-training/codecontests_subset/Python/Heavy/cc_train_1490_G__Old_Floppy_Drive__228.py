import sys,os,io ; from sys import stdin
from bisect import bisect_left , bisect_right
if(os.path.exists('input.txt')):
    sys.stdin = open("input.txt","r") ; sys.stdout = open("output.txt","w") 
else:
    input = io.BytesIO(os.read(0, os.fstat(0).st_size)).readline
si = lambda : input()
ii = lambda : int(input())
li = lambda:list(map(int,input().split()))
t = 1
t = int(input())
def divideCeil(n,x):
    if (n%x==0):
        return n//x
    return n//x+1
for _ in range(t):
    n,m = li()
    a = li()
    xl = li()
    mx = []
    curSum = 0
    mxind = []
    for i in range(n):
        curSum+=a[i]
        if mx==[] or mx[-1]<curSum:
            mx.append(curSum)
            mxind.append(i)
    res = []
    for x in xl:
        if (x>mx[-1] and curSum<=0):
            res.append(-1)
        else:
            temp = 0
            if (x>mx[-1]):
                dif = x-mx[-1]
                temp = divideCeil(dif,curSum)
            toFind = x-temp*curSum
            ind = bisect_left(mx,toFind)
            res.append(temp*n+mxind[ind])
    print(*res)
    






