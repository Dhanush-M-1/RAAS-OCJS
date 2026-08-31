N = int(input())
A = list(map(int, input().split()))
A.sort()
B = list(map(int, input().split()))
B.sort()
C = list(map(int, input().split()))
C.sort()
for i in range(0, N-1):
	if A[i] != B[i]:
		print(A[i])
		break
	if i == N-2: print(A[N-1])
for i in range(0, N-2):
	if B[i] != C[i]:
		print(B[i])
		break
	if i == N-3: print(B[N-2])
