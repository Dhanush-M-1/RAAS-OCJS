import sys
import time
import itertools
import math

def inp():
    ln = input().split()
    return int(ln[0]) if len(ln) == 1 else [int(i) for i in ln]

def prl(x):
    print(' '.join([str(i) for i in x]))

# Problem A

# testcases = inp()
# n, d = inp()
# a = inp()
# a.sort()
# ans=[]
# for i in range(n):
#     if d-a[i]>=0: d-=a[i]
#     ans.append(i)
# print(len(ans))
# prl(ans)

# Problem B

testcases = inp()

for testcase in range (testcases):
    n=inp()
    a=[]
    for i in range(n): a.append(inp())
    l=10**10
    h=0
    for i in a:
        l=min(l,i[1])
        h=max(h,i[0])
    if h>l:
        print(h-l)
    else: print(0)


# Problem C

# testcases = inp()
#
# for testcase in range (testcases):
#


# Problem D

# testcases = inp()
#
# for testcase in range (testcases):
#


# Problem E

# testcases = inp()
#
# for testcase in range (testcases):
#
