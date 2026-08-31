
import sys
n,k = map(int,input().split())

M = []
A = []
B = []

for i in range(n):

    t,a,b = map(int,input().split())
    if a == 1 and b == 1:
        M.append(t)
    elif a == 1:
        A.append(t)
    elif b == 1:
        B.append(t)

if min(len(M)+len(A) , len(M)+len(B)) < k:
    print (-1)
    sys.exit()

A.append(0)
B.append(0)
M.append(0)
A.sort()
B.sort()
M.sort()

for i in range(len(A)-1):
    A[i+1] += A[i]
for i in range(len(B)-1):
    B[i+1] += B[i]
for i in range(len(M)-1):
    M[i+1] += M[i]

ans = float("inf")
for i in range(k+1):

    j = k-i

    if len(A) > i and len(B) > i and len(M) > j:
        ans = min(ans , A[i] + B[i] + M[j])

print (ans)
