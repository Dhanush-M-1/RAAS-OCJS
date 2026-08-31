import sys
import math
def alele(): return list(map(int, sys.stdin.readline().strip().split()))
def ilele(): return map(int, sys.stdin.readline().strip().split())
def input(): return sys.stdin.readline().strip()
def ii():   return int(sys.stdin.readline().strip())

def absdefpair(a):
    return max([abs(s-t) for s, t in zip(a, a[1:])])

for _ in range(int(input())):
    N = int(input())
    A = alele()
    B = []
    if A[0] != -1 and A[1] == -1:
        B.append(A[0])
    if A[-1] != -1 and A[-2] == -1:
        B.append(A[-1])
    for i in range(1,len(A)-1):
        if (A[i-1] == -1 or A[i+1] == -1) and A[i] != -1:
            B.append(A[i])

    dif3 = 1e9;value2 =0
    if B:
        k = (min(B)+max(B))//2
        #print(k)
        for i in range(k-1,k+1):
            B = A.copy();diff = -1e9
            if B[0] == -1:
                B[0] = i
            for j in range(1,len(B)):
                if B[j] == -1:
                    if B[j-1] == -1:
                        dif = 0
                    else:
                        dif = abs(B[j-1] - i)
                else:
                    if B[j-1] == -1:
                        dif = abs(B[j] - i)
                    else:
                        dif = abs(B[j-1] - B[j])
                if dif >= diff:
                    diff = dif
                    value = i
            if diff<=dif3:
                dif3 = diff
                value2 = value
        print(dif3,value2)   
    else:
        print(0,0)
    
            