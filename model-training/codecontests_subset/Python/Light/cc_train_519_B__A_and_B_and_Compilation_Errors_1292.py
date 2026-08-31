N = int(input())

A = list(map(int, input().split()))
B = list(map(int, input().split()))
C = list(map(int, input().split()))
A.sort()
B.sort()
C.sort()

for i in range(len(A)):
    if i == len(A) - 1:
        print(A[-1])
        break
    if A[i] != B[i]:
        print(A[i])
        break

for i in range(len(B)):
    if i == len(B) - 1:
        print(B[-1])
        break
    if B[i] != C[i]:
        print(B[i])
        break