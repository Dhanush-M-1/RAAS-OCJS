n = int(input())
A = list(map(int,input().split()))
S = 0
for i in range(len(A)):
    S += A[i]
B = list(map(int,input().split()))
S1 = 0
for i in range(len(B)):
    S1 += B[i]
C = list(map(int,input().split()))
S2 = 0
for i in range(len(C)):
    S2 += C[i]

print(S - S1)
print(S1-S2)