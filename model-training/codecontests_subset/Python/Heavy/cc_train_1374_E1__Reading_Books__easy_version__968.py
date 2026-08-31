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

# sys.stdout=open("CP3/output.txt",'w')
# sys.stdin=open("CP3/input.txt",'r')

# m=pow(10,9)+7
n,k=map(int,input().split())
c1=0
c2=0
l1=[]
l2=[]
l=[]
# visit=[0]*n
for i in range(n):
    t,a,b=map(int,input().split())
    c1+=a
    c2+=b
    if a+b==2:
        l.append([t,i])
        continue
    if a==1:
        l1.append([t,i])
    if b==1:
        l2.append([t,i])
        # visit[i]=1

if c1<k or c2<k:
    print(-1)
else:
    l1.sort(reverse=True)
    l2.sort(reverse=True)
    l.sort(reverse=True)
    # print(l)
    # print(l1)
    # print(l2)
    time=0
    while k:
        if len(l1)==0 or len(l2)==0 or (l and l1[-1][0]+l2[-1][0]>l[-1][0]):
                time+=l.pop()[0]

        else:
            time+=l1.pop()[0]
            time+=l2.pop()[0]
        k-=1

    print(time)