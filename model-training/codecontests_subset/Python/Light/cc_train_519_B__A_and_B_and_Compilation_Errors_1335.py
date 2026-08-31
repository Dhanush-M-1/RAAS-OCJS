n=int(input())
A=[int(x)for x in input().split()]
B=[int(x)for x in input().split()]
C=[int(x)for x in input().split()]
A.sort()
B.sort()
C.sort()
a=0
for i in range(n-1):
    if A[i]!=B[i]:
        print(A[i])
        a=1
        break
if a==0:
    print(A[n-1])
    a=1
for i in range(n-2):
    if B[i]!=C[i]:
        print(B[i])
        a=0
        break
if a==1:
    print(B[n-2])
