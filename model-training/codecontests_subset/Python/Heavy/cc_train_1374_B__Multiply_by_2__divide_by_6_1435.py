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
    ans=0
    while True:
        if n<9:
            if n==1:
                pass
            elif n==6:
                ans+=1
            elif n==3:
                ans+=2
            else:
                ans=-1
            break
        elif n%9!=0:
            ans=-1
            break
        if n%6==0:
            n//=6
        else:
            n*=2
        ans+=1
    print(ans)
