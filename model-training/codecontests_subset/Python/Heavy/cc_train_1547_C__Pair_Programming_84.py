'''input
5

3 2 2
2 0
0 5

4 3 2
2 0 5
0 6

0 2 2
1 0
2 3

5 4 4
6 0 8 0
0 7 0 9

5 4 1
8 7 8 0
0

'''

import sys
import string
from decimal import Decimal
from math import log
############ ---- Input Functions ---- ############
# input = sys.stdin.readline
def inp():
    return(int(input()))
def inplist():
    return(list(map(int,input().split())))
def inpstrlist():
    s = input()
    return(list(s[:len(s)]))
def invr():
    return(map(int,input().split()))
def printlist(var) : sys.stdout.write(' '.join(map(str, var))+'\n')
############ ---- Output Functions ---- ############

t = inp()
for _ in range(t):
    space = input()
    k, n, m = invr()
    A = inplist()
    B = inplist()

    i = 0
    j = 0
    ans = []
    flag = 0
    while(i!=n and j!=m):
        if A[i]==0:
            ans.append(A[i])
            i += 1
            k += 1
        elif B[j]==0:
            ans.append(B[j])
            j += 1
            k += 1
        elif A[i]<=B[j]:
            if A[i] <= k:
                ans.append(A[i])
                i += 1
            else:
                flag = 1
                break
        else:
            if B[j] <= k:
                ans.append(B[j])
                j += 1
            else:
                flag = 1
                break

    while(i!=n):
        if A[i] == 0:
            ans.append(A[i])
            k += 1
        elif A[i] <= k:
            ans.append(A[i])
        else:
            flag = 1
            break
        i += 1

    while(j!=m):
        if B[j] == 0:
            ans.append(B[j])
            k += 1
        elif B[j] <= k:
            ans.append(B[j])
        else:
            flag = 1
            break
        j += 1

    if flag:
        print(-1)
    else:
        print(*ans)