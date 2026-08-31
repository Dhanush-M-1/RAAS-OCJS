A = dict()
B = dict()
n = int(input())
Arr = list(map(int, input().split()))
for j in Arr:
	if j in A:
		A[j] += 1
	else :
		A[j] = 1
Arr = list(map(int, input().split()))
for j in Arr:
	A[j] -= 1
	if j in B:
		B[j] += 1
	else :
		B[j] = 1
for t in A:
	if (A[t] == 1):
		f = t
Arr = list(map(int, input().split()))
for j in Arr:
	B[j] -= 1
for t in B:
	if (B[t] == 1):
		print(f, "\n", t, sep = "")