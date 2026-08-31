n = int(input())
A = [int(x) for x in input().split()]
B = [int(x) for x in input().split()]
C = [int(x) for x in input().split()]
A.sort()
B.sort()
C.sort()


i = 0
while i < len(B) and A[i] == B[i]:
    i += 1
print(A[i])
i = 0
while i < len(C) and B[i] == C[i]:
    i += 1
print(B[i])
    
