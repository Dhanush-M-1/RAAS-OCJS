import math
from collections import Counter
L=lambda:list(map(int,input().split()))
M=lambda:map(int,input().split())
I=lambda:int(input())
IN=lambda:input()
def s(a):
    print(" ".join(list(map(str,a))))
#______________________-------------------------------_____________________#
for i in range(I()):
    n=I()
    A=[[0,0]]
    for i in range(n):
        a,b=M()
        A.append([a,b])
    k=0
    for i in range(n):
        if A[i+1][0]>=A[i][0] and A[i+1][0]-A[i][0]+A[i][1]>=A[i+1][1] and A[i+1][1]>=A[i][1]:
            continue
        else:
            k=1
            break
    if k==0:
        print("YES")
    else:
        print("NO")
