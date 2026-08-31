import atexit
import io
import sys
import math
from collections import defaultdict,Counter

# _INPUT_LINES = sys.stdin.read().splitlines()
# input = iter(_INPUT_LINES).__next__
# _OUTPUT_BUFFER = io.StringIO()
# sys.stdout = _OUTPUT_BUFFER

# @atexit.register
# def write():
#     sys.__stdout__.write(_OUTPUT_BUFFER.getvalue())

# sys.stdout=open("CP2/output.txt",'w')
# sys.stdin=open("CP2/input.txt",'r')

# m=pow(10,9)+7
t=int(input())
for i in range(t):
    n=int(input())
    a=list(map(int,input().split()))
    # l=[]
    ma=0
    mi=1000000000
    m=0
    flag=0
    for j in range(n):
        if a[j]!=-1:
            flag=1
            if j-1>=0 and a[j-1]==-1:
                ma=max(ma,a[j])
                mi=min(mi,a[j])
            elif j-1>=0:
                m=max(m,abs(a[j]-a[j-1]))
            if j+1<n and a[j+1]==-1:
                ma=max(ma,a[j])
                mi=min(mi,a[j])

        # if a[j]==-1:
        #     if j+1<n and a[j+1]!=-1:
        #         l.append(a[j+1])
        #     if j-1>=0 and a[j-1]!=-1:
        #         l.append(a[j-1])
    if flag==0:
        print(0,0)
    else:
        s=(mi+ma)//2
        m=max(m,abs(s-mi),abs(s-ma))
        print(m,s)
