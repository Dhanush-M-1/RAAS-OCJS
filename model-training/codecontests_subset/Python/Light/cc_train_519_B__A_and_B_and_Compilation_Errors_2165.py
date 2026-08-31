n=int(input())
A=[int(i) for i in input().split()]
B=[int(i) for i in input().split()]
C=[int(i) for i in input().split()]
A.sort()
B.sort()
C.sort()
for i in range(len(B)):
    if A[i]!=B[i]:
        print(A[i])
        break
else:
    print(A[i+1])
for j in range(len(C)):
    if B[j]!=C[j]:
        print(B[j])
        break
else:
    print(B[j+1])

    
